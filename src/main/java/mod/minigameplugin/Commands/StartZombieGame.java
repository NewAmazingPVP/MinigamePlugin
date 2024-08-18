package mod.minigameplugin.Commands;

import mod.minigameplugin.ZombieSurvivalGame.ZombieGameMain;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static mod.minigameplugin.ZombieSurvivalGame.ZombieGameMain.startZombieGame;

public class StartZombieGame implements CommandExecutor, TabCompleter {

    private final ArrayList<String> subcommands = new ArrayList<>(List.of("start", "stop"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (args.length == 0) {
            sender.sendMessage("Please specify a argument.");
            return false;
        }


        switch (args[0].toLowerCase()) {
            case "start":
                ZombieGameMain.isZombieGameRunning = true;
                startZombieGame(player);
                break;
            case "stop":
                ZombieGameMain.isZombieGameRunning = false;
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
