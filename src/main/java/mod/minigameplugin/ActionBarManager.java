package mod.minigameplugin;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class ActionBarManager {


    public static HashMap<Player, String> linkPlayerToStringForActionBar = new HashMap<>();


    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!isPlayerInHashMap(player)) {

            linkPlayerToStringForActionBar.put(player, " ");

        }
    }

    private static boolean isPlayerInHashMap(Player player) {
        return linkPlayerToStringForActionBar.containsKey(player);
    }

    public static void showActionBarToPlayer(Player player){


        player.sendActionBar(linkPlayerToStringForActionBar.get(player));


    }


}
