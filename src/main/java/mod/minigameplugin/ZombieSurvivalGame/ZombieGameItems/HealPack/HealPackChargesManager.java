package mod.minigameplugin.ZombieSurvivalGame.ZombieGameItems.HealPack;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HealPackChargesManager {

    //Create list of heal charges a player has
    public static HashMap<Player, List<Integer>> linkPlayerToHealPack = new HashMap<>();




    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!isPlayerInHashMap(player)) {

            linkPlayerToHealPack.put(player, new ArrayList<>(Arrays.asList(5,7,8,1,2)));

        }
    }


    private static boolean isPlayerInHashMap(Player player) {
        return linkPlayerToHealPack.containsKey(player);
    }



    //Item stack
    public static ItemStack healthPack(Player player){

        ItemStack pistolAmmo = new ItemStack(Material.POTION);
        ItemMeta meta = pistolAmmo.getItemMeta();


        meta.setDisplayName(ChatColor.RED + "Health Pack");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Right Click] " + ChatColor.DARK_PURPLE + "Heals you as long as there is a charge.");

        lore.add(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "---------------");

        for(int i = (linkPlayerToHealPack.get(player)).size(); i>0; i-- ){
            lore.add(ChatColor.DARK_RED + "" +  linkPlayerToHealPack.get(player).get(i) + " ❤");
        }

        lore.add(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "---------------");

        lore.add(ChatColor.DARK_GRAY + "ID: healthPack");




        meta.setLore(lore);
        pistolAmmo.setItemMeta(meta);

        return pistolAmmo;
    }
    



}
