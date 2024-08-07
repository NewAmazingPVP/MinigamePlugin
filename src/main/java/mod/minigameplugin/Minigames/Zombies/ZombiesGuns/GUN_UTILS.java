package mod.minigameplugin.Minigames.Zombies.ZombiesGuns;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class GUN_UTILS implements Listener {

    public static void gunReloadAnimation() {

    }




    //AMMO COUNT MANAGER

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









    //Scan to make it so players can only hold one gun

    @EventHandler
    public void playerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Inventory inv = player.getInventory();
        scanForMoreThan1Gun(player,inv);

    }


    private static void scanForMoreThan1Gun(Player player, Inventory inv){
        int numOfGuns = 0;

        ItemStack[] items = inv.getContents();
        for (int i = 0; i < items.length; i++) {
            ItemStack item = items[i];
            ItemMeta meta = item.getItemMeta();
            if (item != null && meta.hasDisplayName() && ChatColor.stripColor(meta.getDisplayName()).contains("[GUN]")) {
                numOfGuns+=1;

            }
        }

        if(numOfGuns > 1){
            for (int i = 0; i < items.length; i++) {
                ItemStack item = items[i];
                ItemMeta meta = item.getItemMeta();
                if (item != null && meta.hasDisplayName() && ChatColor.stripColor(meta.getDisplayName()).contains("[GUN]")) {
                    player.getInventory().setItem(i, ItemStack.of(Material.AIR));
                    break;
                }
            }
        }
    }




}
