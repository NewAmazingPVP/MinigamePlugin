package mod.minigameplugin.ZombieSurvivalGame;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class ZombiesKillsManager {

    public static HashMap<Player, Integer> linkPlayerToKillCount = new HashMap<>();


    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!isPlayerInHashMap(player)) {

            linkPlayerToKillCount.put(player, 0);

        }
    }


    private static boolean isPlayerInHashMap(Player player) {
        return linkPlayerToKillCount.containsKey(player);
    }

}
