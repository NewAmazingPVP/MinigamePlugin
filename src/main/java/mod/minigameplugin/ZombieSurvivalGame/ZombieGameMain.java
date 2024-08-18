package mod.minigameplugin.ZombieSurvivalGame;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

import static mod.minigameplugin.MinigamePlugin.minigamePlugin;
import static mod.minigameplugin.ZombieSurvivalGame.ZombiesLocations.startGameSpawn;

public class ZombieGameMain {

    public static boolean isZombieGameRunning = false;


    public static BukkitTask zombieGameMainRunnable;
    public static List<Player> playersInCurrentGame = new ArrayList<>();


    public static int currentZombieGameTime = 0;

    public static int roundNum = 0;

    public static void startZombieGame(Player player1) {

        player1.sendMessage("test1");

        playersInCurrentGame.addAll(Bukkit.getOnlinePlayers());

        player1.sendMessage("test2");

        /*for (Player player : playersInCurrentGame) {
            player.teleport(startGameSpawn);
        }*/


        zombieGameMainRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                currentZombieGameTime += 1;
            }
        }.runTaskTimer(minigamePlugin, 0L, 20L);












                /*if (zombieGameMainRunnable <= 0) {

                    Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Game Starting!]");
                    Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Game Starting!]", " ", 10, 40, 5));

                    this.cancel();
                    return;
                }

                Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "[" + zombieGameMainRunnable + "]");

                if (zombieGameMainRunnable <= 5) {
                    Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "[" + zombieGameMainRunnable + "]", " ", 10, 40, 5));
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.UI_BUTTON_CLICK, 2.0f, 1.0f);
                    }
                }
                zombieGameMainRunnable -= 1;*/

    }

}
