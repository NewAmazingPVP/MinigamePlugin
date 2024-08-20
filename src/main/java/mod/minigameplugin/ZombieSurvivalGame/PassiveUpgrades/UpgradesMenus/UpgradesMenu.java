package mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesMenus;

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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradePointsManager.linkPlayerToNumberOfUpgradePoints;
import static mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesPlayerData.linkPlayerToSpeedUpgrade;

public class UpgradesMenu implements Listener {










    public static void openPlayerUpgradesMenu(Player player){

        UUID uuid = player.getUniqueId();



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

        playerUpgradeMenu.setItem(46,guiGlass_BLACK());
        playerUpgradeMenu.setItem(48,guiGlass_BLACK());
        playerUpgradeMenu.setItem(50,guiGlass_BLACK());
        playerUpgradeMenu.setItem(52,guiGlass_BLACK());

        playerUpgradeMenu.setItem(37,speedUpgrade_GUI_TEMP());


        player.openInventory(playerUpgradeMenu);

    }


    private static ItemStack guiGlass_BLACK(){

        ItemStack guiGlass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = guiGlass.getItemMeta();

        meta.setDisplayName(" ");


        guiGlass.setItemMeta(meta);
        return guiGlass;
    }

    private static ItemStack guiGlass_RED(){

        ItemStack guiGlass = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta meta = guiGlass.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Not Yet Unlocked]");

        guiGlass.setItemMeta(meta);
        return guiGlass;
    }

    private static ItemStack guiGlass_LIME(){

        ItemStack guiGlass = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta meta = guiGlass.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Unlocked]");


        guiGlass.setItemMeta(meta);
        return guiGlass;
    }

    private static ItemStack speedUpgrade_GUI_TEMP(){

        ItemStack guiGlass = new ItemStack(Material.SUGAR);
        ItemMeta meta = guiGlass.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "[Speed Upgrade]");

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "----------");
        lore.add(ChatColor.YELLOW + "Click to upgrade");
        lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "----------");



        meta.setLore(lore);
        guiGlass.setItemMeta(meta);
        return guiGlass;
    }






















    private static ItemStack speedUpgrade_GUI(Integer lvl, Boolean canUpgrade){

        ItemStack guiGlass = new ItemStack(Material.SUGAR);
        ItemMeta meta = guiGlass.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "[Speed Upgrade]");

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "----------");

        if(lvl == 0){
            lore.add(ChatColor.GOLD + "+.1 Speed!");
            lore.add(ChatColor.AQUA + "Requires 1 upgrade point.");
        }else if(lvl == 1){
            lore.add(ChatColor.GOLD + "+.2 Speed!");
            lore.add(ChatColor.AQUA + "Requires 2 upgrade points.");
        }else if(lvl == 2){
            lore.add(ChatColor.GOLD + "+.3 Speed!");
            lore.add(ChatColor.AQUA + "Requires 3 upgrade points.");
        }else if(lvl == 3){
            lore.add(ChatColor.DARK_AQUA + "Maxed Out!");
        }else{
            lore.add(ChatColor.RED + "Error... Plz report this (it was nap's fault)");
        }

        lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "----------");

        if(canUpgrade){
            lore.add(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Click To Upgrade]");
        }else {
            lore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Not Enough Upgrade Points]");
        }

        meta.setLore(lore);
        guiGlass.setItemMeta(meta);
        return guiGlass;
    }


}
