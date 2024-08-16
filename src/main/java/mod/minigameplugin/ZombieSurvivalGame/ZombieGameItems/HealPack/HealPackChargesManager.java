package mod.minigameplugin.ZombieSurvivalGame.ZombieGameItems.HealPack;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HealPackChargesManager implements Listener {

    //Create list of heal charges a player has ==================================
    public static HashMap<Player, List<Integer>> linkPlayerToHealPack = new HashMap<>();

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!isPlayerInHashMap(player)) {

            linkPlayerToHealPack.put(player, new ArrayList<>(Arrays.asList(5,7,8,1,2,-1)));

        }
    }

    private static boolean isPlayerInHashMap(Player player) {
        return linkPlayerToHealPack.containsKey(player);
    }



    //Item stack =================================
    public static ItemStack healthPack(Player player){

        ItemStack healthPack = new ItemStack(Material.TNT_MINECART);
        ItemMeta meta = healthPack.getItemMeta();


        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Health Pack");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Right Click] " + ChatColor.DARK_PURPLE + "Heal Yourself.");
        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Left Click] " + ChatColor.DARK_PURPLE + "Open Menu.");



        lore.add(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "----" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Charges]" + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "----");

        for(int i = 0; i < linkPlayerToHealPack.get(player).size(); i++ ) {

            if(i==-1){
                lore.add(ChatColor.DARK_RED + "[" + linkPlayerToHealPack.get(player).get(i) + " HP ❤] <<<");
            }else{
                lore.add(ChatColor.DARK_RED + "[" + linkPlayerToHealPack.get(player).get(i) + " HP ❤]");
            }


        }

        lore.add(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "----------");

        lore.add(ChatColor.DARK_GRAY + "ID: healthPack");


        meta.setLore(lore);


        healthPack.setItemMeta(meta);

        return healthPack;
    }


    //=================================================

    @EventHandler
    public void playerClick(PlayerInteractEvent e){
        Player attacker = e.getPlayer();
        ItemStack itemInHand = attacker.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (e.getAction().name().contains("LEFT_CLICK") && e.getItem() != null && itemInHand != null && itemInHand.hasItemMeta() && meta.getLore().toString().contains("ID: healthPack")) {



        }
    }




}
