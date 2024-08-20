package mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesMenus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;
import java.util.List;

import static mod.minigameplugin.Utils.getProfile;
import static mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesMenus.UpgradeResetMenu.openResetRecipieMenu;
import static mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesMenus.UpgradesMenu.openPlayerUpgradesMenu;

public class UpgradesMenuMAIN implements Listener {


    public static void openUpgradeMenuMAIN(Player player){

        Inventory playerUpgradeMenuMAIN = Bukkit.createInventory(null, 27, ChatColor.AQUA + "" + ChatColor.BOLD + "Upgrade Menu");

        playerUpgradeMenuMAIN.setItem(0,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(1,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(2,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(3,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(4,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(5,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(6,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(7,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(8,guiGlass_BLACK());

        playerUpgradeMenuMAIN.setItem(9,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(10,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(11,speedUpgrade_GUI_INFO());
        playerUpgradeMenuMAIN.setItem(12,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(13,toUpgradeMenu());
        playerUpgradeMenuMAIN.setItem(14,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(15,toResetRecipiMenu());
        playerUpgradeMenuMAIN.setItem(16,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(17,guiGlass_BLACK());

        playerUpgradeMenuMAIN.setItem(18,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(19,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(20,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(21,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(22,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(23,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(24,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(25,guiGlass_BLACK());
        playerUpgradeMenuMAIN.setItem(26,guiGlass_BLACK());




        player.openInventory(playerUpgradeMenuMAIN);

    }

    private static ItemStack guiGlass_BLACK() {

        ItemStack guiGlass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = guiGlass.getItemMeta();

        meta.setDisplayName(" ");


        guiGlass.setItemMeta(meta);
        return guiGlass;
    }




    public static ItemStack speedUpgrade_GUI_INFO() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/d01afe973c5482fdc71e6aa10698833c79c437f21308ea9a1a095746ec274a0f");
        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Info");
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.DARK_PURPLE + "You can gain upgrade points");
        lore.add(ChatColor.DARK_PURPLE + "in different ways. Use them in");
        lore.add(ChatColor.DARK_PURPLE + "the power up menu to unlock");
        lore.add(ChatColor.DARK_PURPLE + "different buffs.");

        meta.setLore(lore);
        meta.setOwnerProfile(profile);
        info.setItemMeta(meta);

        return info;
    }

    public static ItemStack toUpgradeMenu() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/74b662d3b529a187261cab86c6e56423bf876aa249d030faeaf34362f3447277");
        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Upgrades Menu");

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Click]");


        meta.setLore(lore);

        meta.setOwnerProfile(profile);
        info.setItemMeta(meta);

        return info;
    }

    public static ItemStack toResetRecipiMenu() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/6db32b15d7f32704ed626fa52d06fb2b4071d336fdbfe61e6e41c669d6e37f47");
        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Reset Orb Recipe");

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Click]");

        meta.setLore(lore);

        meta.setOwnerProfile(profile);
        info.setItemMeta(meta);

        return info;
    }


    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        ItemStack itemInHand = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "Upgrade Menu")) {

            if (itemInHand != null && itemInHand.getType() == Material.PLAYER_HEAD && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Upgrades Menu")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                openPlayerUpgradesMenu(player);

            }

            if (itemInHand != null && itemInHand.getType() == Material.PLAYER_HEAD && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Reset Orb Recipe")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                openResetRecipieMenu(player);

            }

            e.setCancelled(true);

        }

    }



}
