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
import static mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesMenus.UpgradesMenu.openPlayerUpgradesMenu;

public class UpgradeResetMenu implements Listener {


    public static void openResetRecipieMenu(Player player){

        Inventory resetOrbMenu = Bukkit.createInventory(null, 45, ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Reset Orb Recipe");

        resetOrbMenu.setItem(0,guiGlass_RED());
        resetOrbMenu.setItem(1,guiGlass_RED());
        resetOrbMenu.setItem(2,guiGlass_BLACK());
        resetOrbMenu.setItem(3,guiGlass_BLACK());
        resetOrbMenu.setItem(4,guiGlass_BLACK());
        resetOrbMenu.setItem(5,guiGlass_BLACK());
        resetOrbMenu.setItem(6,guiGlass_BLACK());
        resetOrbMenu.setItem(7,guiGlass_RED());
        resetOrbMenu.setItem(8,guiGlass_RED());

        resetOrbMenu.setItem(9,guiGlass_RED());
        resetOrbMenu.setItem(10,amethystShard);
        resetOrbMenu.setItem(11,amethystShard);
        resetOrbMenu.setItem(12,amethystShard);
        resetOrbMenu.setItem(13,guiGlass_BLACK());
        resetOrbMenu.setItem(14,guiGlass_BLACK());
        resetOrbMenu.setItem(15,guiGlass_BLACK());
        resetOrbMenu.setItem(16,guiGlass_BLACK());
        resetOrbMenu.setItem(17,guiGlass_RED());

        resetOrbMenu.setItem(18,guiGlass_BLACK());
        resetOrbMenu.setItem(19,diamond);
        resetOrbMenu.setItem(20,diamond);
        resetOrbMenu.setItem(21,diamond);
        resetOrbMenu.setItem(22,guiGlass_BLACK());
        resetOrbMenu.setItem(23,craftingTableItem);
        resetOrbMenu.setItem(24,guiGlass_BLACK());
        resetOrbMenu.setItem(25,resetOrbItem());
        resetOrbMenu.setItem(26,guiGlass_BLACK());

        resetOrbMenu.setItem(27,guiGlass_RED());
        resetOrbMenu.setItem(28,copperBlock);
        resetOrbMenu.setItem(29,copperBlock);
        resetOrbMenu.setItem(30,copperBlock);
        resetOrbMenu.setItem(31,guiGlass_BLACK());
        resetOrbMenu.setItem(32,guiGlass_BLACK());
        resetOrbMenu.setItem(33,guiGlass_BLACK());
        resetOrbMenu.setItem(34,guiGlass_BLACK());
        resetOrbMenu.setItem(35,guiGlass_RED());

        resetOrbMenu.setItem(36,guiGlass_RED());
        resetOrbMenu.setItem(37,guiGlass_RED());
        resetOrbMenu.setItem(38,guiGlass_BLACK());
        resetOrbMenu.setItem(39,guiGlass_BLACK());
        resetOrbMenu.setItem(40,guiGlass_BLACK());
        resetOrbMenu.setItem(41,guiGlass_BLACK());
        resetOrbMenu.setItem(42,guiGlass_BLACK());
        resetOrbMenu.setItem(43,guiGlass_RED());
        resetOrbMenu.setItem(44,guiGlass_RED());


        player.openInventory(resetOrbMenu);

    }

    private static final ItemStack craftingTableItem = new ItemStack(Material.CRAFTING_TABLE);

    private static final ItemStack amethystShard = new ItemStack(Material.AMETHYST_SHARD);

    private static final ItemStack copperBlock = new ItemStack(Material.COPPER_BLOCK);

    private static final ItemStack diamond = new ItemStack(Material.DIAMOND);


    private static ItemStack guiGlass_BLACK() {

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


    public static ItemStack resetOrbItem() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/6db32b15d7f32704ed626fa52d06fb2b4071d336fdbfe61e6e41c669d6e37f47");
        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Reset Orb");

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Right Click]");
        lore.add(ChatColor.DARK_PURPLE + "Resets all your upgrade points");
        lore.add(ChatColor.DARK_PURPLE + "and gives them back to you.");

        meta.setLore(lore);

        meta.setOwnerProfile(profile);
        info.setItemMeta(meta);

        return info;
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        ItemStack itemInHand = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Reset Orb Recipe")) {

            /*if (itemInHand != null && itemInHand.getType() == Material.PLAYER_HEAD && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Upgrades Menu")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                openPlayerUpgradesMenu(player);

            }*/

            e.setCancelled(true);

        }

    }



}
