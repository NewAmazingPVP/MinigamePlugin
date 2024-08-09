package mod.minigameplugin.ZombieSurvivalGame;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

import static mod.minigameplugin.MinigamePlugin.minigamePlugin;
import static mod.minigameplugin.ZombieSurvivalGame.ZombiesLocations.startGameSpawn;

public class ZombieGameMain {

    public static boolean isZombieGameRunning = false;



    public static BukkitRunnable preGameTimer;
    public static List<Player> playersInCurrentGame = new ArrayList<>();

    private static int preGameTimerCountdown = 10;



    public static void startZombieGame(){

        playersInCurrentGame.addAll(Bukkit.getOnlinePlayers());

        for (Player player : playersInCurrentGame) {
            player.teleport(startGameSpawn);
        }


        preGameTimer = new BukkitRunnable() {
            @Override
            public void run() {


                if (preGameTimerCountdown <= 0) {

                    Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Game Starting!]");
                    Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Game Starting!]", " ", 10, 40, 5));

                    this.cancel();
                    return;
                }

                Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "[" + preGameTimerCountdown + "]");

                if (preGameTimerCountdown <= 5) {
                    Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "[" + preGameTimerCountdown + "]", " ", 10, 40, 5));
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.UI_BUTTON_CLICK, 2.0f, 1.0f);
                    }
                }
                preGameTimerCountdown -= 1;
            }
        };
        preGameTimer.runTaskTimer(minigamePlugin, 0L, 20L);







    }



}
