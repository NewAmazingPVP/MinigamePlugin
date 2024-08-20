package mod.minigameplugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesMenus.UpgradesMenu.openPlayerUpgradesMenu;
import static mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesMenus.UpgradesMenuMAIN.openUpgradeMenuMAIN;
import static mod.minigameplugin.ZombieSurvivalGame.ZombieGameItems.HealPack.HealPackChargesManager.healthPack;

public class GiveHealthPack implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;


        player.getInventory().addItem(healthPack(player));

        openUpgradeMenuMAIN(player);

        return true;
    }

}
