package mod.minigameplugin.ZombieSurvivalGame.Scoreboards;

import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mod.minigameplugin.ZombieSurvivalGame.ZombieGameMain.currentZombieGameTime;
import static mod.minigameplugin.ZombieSurvivalGame.ZombieGameMain.playersInCurrentGame;
import static mod.minigameplugin.ZombieSurvivalGame.ZombiesDeathManager.*;
import static mod.minigameplugin.ZombieSurvivalGame.ZombiesKillsManager.linkPlayerToKillCount;
import static mod.minigameplugin.ZombieSurvivalGame.ZombiesShopManager.linkPlayerToCoinCount;
import static org.bukkit.Bukkit.getServer;

public class ZombieGameMainScoreboard implements Listener {



    public final Map<Player, FastBoard> zombieGameBoards = new HashMap<>();



    public static void updateZombieGameScoreboard(FastBoard board, Player player) {

        board.updateLines(
                ChatColor.DARK_GREEN + "" + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "--------------------",

                ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Coins]: " + ChatColor.GREEN + linkPlayerToCoinCount.get(player),

                "",

                ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Kills]: " + ChatColor.GREEN + linkPlayerToKillCount.get(player),

                "",

                ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Deaths]: " + ChatColor.GREEN + linkPlayerToDeathCount.get(player),

                "",

                ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Time]: " + ChatColor.GREEN + formatTime(currentZombieGameTime),

                //ChatColor.DARK_GREEN + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "--" + ChatColor.GREEN + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Players" + ChatColor.GREEN + "" + ChatColor.BOLD + "]" + ChatColor.DARK_GREEN + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "----------",


                ChatColor.DARK_GREEN + "" + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "--------------------"


        );

    }

    private static String formatTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }







    @EventHandler
    public void playerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();



        FastBoard board = new FastBoard(player);

        board.updateTitle(ChatColor.DARK_RED + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "------" + ChatColor.GREEN + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Zombies" + ChatColor.GREEN + "" + ChatColor.BOLD + "]" + ChatColor.DARK_GREEN + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "------");



       updateZombieGameScoreboard(board, player);


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
