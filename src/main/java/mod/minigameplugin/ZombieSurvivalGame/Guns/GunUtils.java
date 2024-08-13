package mod.minigameplugin.ZombieSurvivalGame.Guns;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

import static mod.minigameplugin.MinigamePlugin.minigamePlugin;
import static mod.minigameplugin.ZombieSurvivalGame.Guns.GunItemStacks.pistol;

public class GunUtils implements Listener {




    //Ammo manager

    public static HashMap<Player, Integer> linkPlayerToPistolBulletCount = new HashMap<>();


    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!isPlayerInHashMap(player)) {

            linkPlayerToPistolBulletCount.put(player, 15);

        }
    }


    private static boolean isPlayerInHashMap(Player player) {
        return linkPlayerToPistolBulletCount.containsKey(player);
    }




    public static void reloadGun(Player player, String gunType){

        switch (gunType) {

            case "PISTOL":

                for(int i = 1; i <= 15; i++) {
                    player.getInventory().setItem(0, pistol(true, linkPlayerToPistolBulletCount.get(player)));
                    linkPlayerToPistolBulletCount.put(player, linkPlayerToPistolBulletCount.getOrDefault(player, 0) + 1);
                }
                player.getInventory().setItemInMainHand(pistol(false, linkPlayerToPistolBulletCount.get(player)));

                /*BukkitRunnable reloadAnimation;

                reloadAnimation = new BukkitRunnable() {

                    int bulletCount = 15;

                    @Override
                    public void run() {



                        player.sendMessage("test3");

                        if (bulletCount <= 0) {
                            player.sendMessage("stoped");
                            player.getInventory().setItemInMainHand(pistol(false, linkPlayerToPistolBulletCount.get(player)));
                            this.cancel();
                            return;
                        }

                        bulletCount -= 1;

                        player.getInventory().setItem(0, pistol(true, linkPlayerToPistolBulletCount.get(player)));
                        linkPlayerToPistolBulletCount.put(player, linkPlayerToPistolBulletCount.getOrDefault(player, 0) + 1);


                    }
                };reloadAnimation.runTaskTimer(minigamePlugin, 0L, 20L); */

                break;
            default:
                player.sendMessage(ChatColor.RED + "[ERROR] plz report this =(");
        }





    }



    public static void playSoundFromLocToEvryone(Player player, Sound sound, Float volume, Float pitch) {

        Location loc = player.getLocation();

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(loc, sound, volume, pitch); 

        }
    }



}
