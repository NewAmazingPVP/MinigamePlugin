package mod.minigameplugin.ZombieSurvivalGame;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZombiesDeathManager {

    public static List<Player> zombiesPlayersAlive = new ArrayList<>();

    public static List<Player> zombiesPlayersDead = new ArrayList<>();

    public static HashMap<Player, Integer> linkPlayerToDeathCount = new HashMap<>();


    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!isPlayerInHashMap(player)) {

            linkPlayerToDeathCount.put(player, 0);

        }
    }


    private static boolean isPlayerInHashMap(Player player) {
        return linkPlayerToDeathCount.containsKey(player);
    }


}
