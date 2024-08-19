package mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UpgradesPlayerData implements Listener {

    public static HashMap<Player, Integer> linkPlayerToSpeedUpgrade = new HashMap<>();

    public static HashMap<Player, Integer> linkPlayerToJumpUpgrade = new HashMap<>();

    public static HashMap<Player, Integer> linkPlayerToSlowUpgrade = new HashMap<>();

    public static HashMap<Player, Integer> linkPlayerToLifeStealUpgrade = new HashMap<>();

    public static HashMap<Player, Integer> linkPlayerToGoldBoostUpgrade = new HashMap<>();

    public static HashMap<Player, Integer> linkPlayerToHpBoostUpgrade = new HashMap<>();

    public static HashMap<Player, Integer> linkPlayerToWitherUpgrade = new HashMap<>();







    List<HashMap> statsHashMaps = new ArrayList<>(Arrays.asList(linkPlayerToSpeedUpgrade,linkPlayerToJumpUpgrade,linkPlayerToSlowUpgrade,linkPlayerToLifeStealUpgrade,linkPlayerToGoldBoostUpgrade,linkPlayerToHpBoostUpgrade,linkPlayerToWitherUpgrade));

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();


        for (HashMap statsHashMap : statsHashMaps) {

            if (!isPlayerInHashMap(player,statsHashMap)) {
                statsHashMap.put(player, 0);
                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Debug]" + ChatColor.GREEN + "Added a data slot for u in " + statsHashMap);
            }

        }


        
    }


    private static boolean isPlayerInHashMap(Player player,HashMap map) {
        return map.containsKey(player);
    }

}
