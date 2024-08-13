package mod.minigameplugin.ZombieSurvivalGame.Guns;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

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
                break;
            default:
                player.sendMessage(ChatColor.RED + "[ERROR] plz report this =(");
        }










    }



}
