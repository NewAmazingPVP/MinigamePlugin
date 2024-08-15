package mod.minigameplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static mod.minigameplugin.ZombieSurvivalGame.Guns.GunItemStacks.*;


public class GiveZombiesItemCMD implements CommandExecutor, TabCompleter {


    private final ArrayList<String> subcommands = new ArrayList<>(List.of("testgun","pistolammo","shotgunammo","specialammo"));
    private final ArrayList<ItemStack> subItems = new ArrayList<>(List.of(pistol(false, -1),pistolAmmo(),shotgunAmmo(),specialAmmo()));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player p) {
                Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "CustomItems");
                for (ItemStack r : subItems) {
                    inv.addItem(r);
                }
                p.openInventory(inv);
            }
        } else if (args.length == 1) {
            int index = subcommands.indexOf(args[0].toLowerCase());
            if (index == -1) return false;
            Player p = (Player) sender;
            p.getInventory().addItem(subItems.get(index));
        } else if (args.length == 2) {
            {
                Player p = Bukkit.getPlayer(args[0]);
                int index = subcommands.indexOf(args[1].toLowerCase());
                if (index == -1 || p == null) return false;
                p.getInventory().addItem(subItems.get(index));
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1 || args.length == 2) {
            return subcommands;
        }
        return null;
    }


}
