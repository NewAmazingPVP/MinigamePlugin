package mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class UpgradesMenu {

    public static void openPlayerUpgradesMenu(Player player){

        Inventory playerUpgradeMenu = Bukkit.createInventory(null, 36, ChatColor.AQUA + "" + ChatColor.BOLD + "         Upgrade Menu");

        player.openInventory(playerUpgradeMenu);

    }


}
