package mod.minigameplugin.ZombieSurvivalGame.Guns;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class GunUtils implements Listener {




    //Ammo manager

    public static HashMap<Player, Integer> linkPlayerToBulletCount = new HashMap<>();


    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!isPlayerInHashMap(player)) {

            linkPlayerToBulletCount.put(player, 0);

        }
    }

    private static boolean isPlayerInHashMap(Player player) {
        return linkPlayerToBulletCount.containsKey(player);
    }



}
