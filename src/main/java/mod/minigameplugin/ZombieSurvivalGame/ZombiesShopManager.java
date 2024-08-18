package mod.minigameplugin.ZombieSurvivalGame;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class ZombiesShopManager {

    public static HashMap<Player, Integer> linkPlayerToCoinCount = new HashMap<>();


    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!isPlayerInHashMap(player)) {

            linkPlayerToCoinCount.put(player, 0);

        }
    }


    private static boolean isPlayerInHashMap(Player player) {
        return linkPlayerToCoinCount.containsKey(player);
    }

}
