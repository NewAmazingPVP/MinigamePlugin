package mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class UpgradePointsManager {

    public static HashMap<UUID, Integer> linkPlayerToNumberOfUpgradePoints = new HashMap<>();


    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();


        if (!isPlayerInHashMap(uuid)) {

            linkPlayerToNumberOfUpgradePoints.put(uuid, 5);

        }
    }


    private static boolean isPlayerInHashMap(UUID uuid) {
        return linkPlayerToNumberOfUpgradePoints.containsKey(uuid);
    }

}
