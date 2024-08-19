package mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.*;

public class UpgradesPlayerData implements Listener {

    public static HashMap<UUID, Integer> linkPlayerToSpeedUpgrade = new HashMap<>();

    public static HashMap<UUID, Integer> linkPlayerToJumpUpgrade = new HashMap<>();

    public static HashMap<UUID, Integer> linkPlayerToSlowUpgrade = new HashMap<>();

    public static HashMap<UUID, Integer> linkPlayerToLifeStealUpgrade = new HashMap<>();

    public static HashMap<UUID, Integer> linkPlayerToGoldBoostUpgrade = new HashMap<>();

    public static HashMap<UUID, Integer> linkPlayerToHpBoostUpgrade = new HashMap<>();

    public static HashMap<UUID, Integer> linkPlayerToWitherUpgrade = new HashMap<>();







    List<HashMap> statsHashMaps = new ArrayList<>(Arrays.asList(linkPlayerToSpeedUpgrade,linkPlayerToJumpUpgrade,linkPlayerToSlowUpgrade,linkPlayerToLifeStealUpgrade,linkPlayerToGoldBoostUpgrade,linkPlayerToHpBoostUpgrade,linkPlayerToWitherUpgrade));

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        UUID uuid = player.getUniqueId();


        for (HashMap statsHashMap : statsHashMaps) {

            if (!isPlayerInHashMap(uuid,statsHashMap)) {
                statsHashMap.put(uuid, 0);
                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Debug] " + ChatColor.GREEN + "Added a data slot for u in " + statsHashMap);
            }

        }



    }


    private static boolean isPlayerInHashMap(UUID uuid,HashMap map) {
        return map.containsKey(uuid);
    }



}
