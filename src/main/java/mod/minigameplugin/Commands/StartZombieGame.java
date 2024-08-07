package mod.minigameplugin.Commands;

import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class StartZombieGame implements CommandExecutor, TabCompleter {

    private final ArrayList<String> subcommands = new ArrayList<>(List.of("start", "stop"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Please specify a argument.");
            return false;
        }


        switch (args[0].toLowerCase()) {
            case "start":
                zombieGameRunning = true;
                break;
            case "stop":
                zombieGameRunning = false;
                break;
            default:
                sender.sendMessage("Error.");
                return false;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            for (String subcommand : subcommands) {
                if (subcommand.startsWith(args[0].toLowerCase())) {
                    completions.add(subcommand);
                }
            }
            return completions;
        }
        return null;
    }



}
