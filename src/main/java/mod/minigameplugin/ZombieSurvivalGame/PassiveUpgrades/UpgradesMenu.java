package mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class UpgradesMenu {

    public static void openPlayerUpgradesMenu(Player player){

        Inventory playerUpgradeMenu = Bukkit.createInventory(null, 54, ChatColor.AQUA + "" + ChatColor.BOLD + "        Upgrade Menu");

        playerUpgradeMenu.setItem(0,guiGlass_BLACK());


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
