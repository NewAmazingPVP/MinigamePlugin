package mod.minigameplugin.MainLobby;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyMain implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();
        player.getInventory().setItem(0, mainLobbyGamesSelector());


    }


    public static ItemStack mainLobbyGamesSelector() {
        ItemStack reviveBeacon = new ItemStack(Material.COMPASS);
        ItemMeta meta = reviveBeacon.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Games" + ChatColor.YELLOW + "" + ChatColor.BOLD + " [Right Click]");
        reviveBeacon.setItemMeta(meta);
        return reviveBeacon;
    }



    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {

        ItemStack itemInHand = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();


        if (itemInHand != null && itemInHand.getType() == Material.BARRIER && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Games" + ChatColor.YELLOW + "" + ChatColor.BOLD + " [Right Click]")) {
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f);
            event.setCancelled(true);


        }
    }


}
