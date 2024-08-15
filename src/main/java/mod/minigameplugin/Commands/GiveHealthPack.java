package mod.minigameplugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static mod.minigameplugin.ZombieSurvivalGame.ZombieGameItems.HealPack.HealPackChargesManager.arrayList;
import static mod.minigameplugin.ZombieSurvivalGame.ZombieGameItems.HealPack.HealPackChargesManager.healthPack;

public class GiveHealthPack implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        player.sendMessage(String.valueOf(arrayList.size())); 

        player.getInventory().addItem(healthPack(player));

        return true;
    }

}
