package mod.minigameplugin.MainLobby;

//This is just mainly a test

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class RandomCoinPickup implements Listener {

    public static HashMap<Player, Integer> lastNumOfCoinsBeforeLastSave = new HashMap<>();














    //TODO:This will all need to be re done when we add data save test
    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!isPlayerInHashMap(player)) {

            lastNumOfCoinsBeforeLastSave.put(player, 0);

        }
    }

    private static boolean isPlayerInHashMap(Player player) {
        return lastNumOfCoinsBeforeLastSave.containsKey(player);
    }


}
