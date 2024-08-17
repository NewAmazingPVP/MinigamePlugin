package mod.minigameplugin.ZombieSurvivalGame.Scoreboards;

import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mod.minigameplugin.ZombieSurvivalGame.ZombiesDeathManager.zombiesPlayersAlive;
import static mod.minigameplugin.ZombieSurvivalGame.ZombiesDeathManager.zombiesPlayersDead;
import static mod.minigameplugin.ZombieSurvivalGame.ZombiesKillsManager.linkPlayerToKillCount;
import static org.bukkit.Bukkit.getServer;

public class ZombieGameMainScoreboard implements Listener {



    public final Map<Player, FastBoard> zombieGameBoards = new HashMap<>();

    public static List<Player> playersInZombieGame = new ArrayList<>();




    public static void updateZombieGameScoreboard(FastBoard board, Player player) {

        board.updateLines(
                "",
                ChatColor.AQUA + "" + ChatColor.BOLD + "Players " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Alive" + ChatColor.AQUA + "" + ChatColor.BOLD + "/" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Dead" + ChatColor.AQUA + "" + ChatColor.BOLD + ": " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + zombiesPlayersAlive.size() + ChatColor.AQUA + "" + ChatColor.BOLD + " / " + ChatColor.DARK_RED + "" + ChatColor.BOLD + zombiesPlayersDead.size(),

                "",
                ChatColor.AQUA + "" + ChatColor.BOLD + "Kills: " + linkPlayerToKillCount.get(player),
                ""
        );

    }



    @EventHandler
    public void playerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();


        FastBoard board = new FastBoard(player);

        board.updateTitle(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "===[Zombies]===");

        this.zombieGameBoards.put(player, board);


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        FastBoard board = this.zombieGameBoards.remove(player);

        if (board != null) {
            board.delete();
        }
    }





}
