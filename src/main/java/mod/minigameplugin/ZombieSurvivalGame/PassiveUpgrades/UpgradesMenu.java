package mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UpgradesMenu implements Listener {


    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "        Upgrade Menu")) {

            e.setCancelled(true);

        }

    }







    public static void openPlayerUpgradesMenu(Player player){

        Inventory playerUpgradeMenu = Bukkit.createInventory(null, 54, ChatColor.AQUA + "" + ChatColor.BOLD + "        Upgrade Menu");

        playerUpgradeMenu.setItem(0,guiGlass_BLACK());
        playerUpgradeMenu.setItem(9,guiGlass_BLACK());
        playerUpgradeMenu.setItem(18,guiGlass_BLACK());
        playerUpgradeMenu.setItem(27,guiGlass_BLACK());
        playerUpgradeMenu.setItem(36,guiGlass_BLACK());
        playerUpgradeMenu.setItem(45,guiGlass_BLACK());

        playerUpgradeMenu.setItem(2,guiGlass_BLACK());
        playerUpgradeMenu.setItem(11,guiGlass_BLACK());
        playerUpgradeMenu.setItem(20,guiGlass_BLACK());
        playerUpgradeMenu.setItem(29,guiGlass_BLACK());
        playerUpgradeMenu.setItem(38,guiGlass_BLACK());
        playerUpgradeMenu.setItem(47,guiGlass_BLACK());

        playerUpgradeMenu.setItem(4,guiGlass_BLACK());
        playerUpgradeMenu.setItem(13,guiGlass_BLACK());
        playerUpgradeMenu.setItem(22,guiGlass_BLACK());
        playerUpgradeMenu.setItem(31,guiGlass_BLACK());
        playerUpgradeMenu.setItem(40,guiGlass_BLACK());
        playerUpgradeMenu.setItem(49,guiGlass_BLACK());

        playerUpgradeMenu.setItem(6,guiGlass_BLACK());
        playerUpgradeMenu.setItem(15,guiGlass_BLACK());
        playerUpgradeMenu.setItem(24,guiGlass_BLACK());
        playerUpgradeMenu.setItem(33,guiGlass_BLACK());
        playerUpgradeMenu.setItem(42,guiGlass_BLACK());
        playerUpgradeMenu.setItem(51,guiGlass_BLACK());

        playerUpgradeMenu.setItem(8,guiGlass_BLACK());
        playerUpgradeMenu.setItem(17,guiGlass_BLACK());
        playerUpgradeMenu.setItem(26,guiGlass_BLACK());
        playerUpgradeMenu.setItem(35,guiGlass_BLACK());
        playerUpgradeMenu.setItem(44,guiGlass_BLACK());
        playerUpgradeMenu.setItem(53,guiGlass_BLACK());



        player.openInventory(playerUpgradeMenu);

    }


    private static ItemStack guiGlass_BLACK(){

        ItemStack guiGlass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = guiGlass.getItemMeta();

        meta.setDisplayName(" ");


        guiGlass.setItemMeta(meta);
        return guiGlass;
    }


}
