package mod.minigameplugin.Commands;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IAmAFuckingShowoff implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {

            Player player = (Player) sender;

            getItemLoreForChat(player);

            return true;
        }



        if (args.length == 1) {

            String playerName = args[0];
            Player player = Bukkit.getPlayerExact(playerName);
            if (player == null) {
                sender.sendMessage("Player not found.");
            }




            return true;
        }




        return false;
    }


    //itemLoreChatDisplay.setFont("minecraft:uniform");

    private static void getItemLoreForChat(Player player){
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();

        TextComponent itemLoreChatDisplay = new TextComponent("test");


        //itemLoreChatDisplay.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new ComponentBuilder(item).create()));
        HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_ITEM, new ComponentBuilder("§6" + item).create());
        
        itemLoreChatDisplay.setHoverEvent(hoverEvent);

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()){
            player.spigot().sendMessage(itemLoreChatDisplay);
        }

    }



}
