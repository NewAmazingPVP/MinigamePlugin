package mod.minigameplugin.ZombieSurvivalGame.Guns;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GunItemStacks {

    public static ItemStack pistol(Boolean reloading, Double bulletCount) {
        ItemStack testGun = new ItemStack(Material.WOODEN_HOE);
        ItemMeta meta = testGun.getItemMeta();


        if(!reloading) {

            if(bulletCount / 100 > .50) {
                meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "[GUN] " + ChatColor.AQUA + "" + ChatColor.BOLD + "Pistol" + ChatColor.DARK_GREEN + " | " + bulletCount);

            }else if(bulletCount / 100 <= .50 && bulletCount / 100 > .10) {
                meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "[GUN] " + ChatColor.AQUA + "" + ChatColor.BOLD + "Pistol" + ChatColor.YELLOW + " | " + bulletCount);

            }else if(bulletCount / 100 <= .10 && bulletCount / 100 > 0) {
                meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "[GUN] " + ChatColor.AQUA + "" + ChatColor.BOLD + "Pistol" + ChatColor.DARK_RED + " | ⚠ " + bulletCount + " ⚠");

            }else if(bulletCount / 100 <= 0) {
                meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "[GUN] " + ChatColor.AQUA + "" + ChatColor.BOLD + "Pistol" + ChatColor.DARK_RED + " | ⚠ EMPTY ⚠ " + ChatColor.YELLOW + "Left Click To Reload!");
            }

            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Right Click]" + ChatColor.DARK_PURPLE + " To Fire.");
            lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Left Click]" + ChatColor.DARK_PURPLE + " To Reload.");
            lore.add("" + bulletCount);
            lore.add(ChatColor.DARK_GRAY + "ID: pistol");
            meta.setLore(lore);



        }else{
            meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Reloading...");
        }


        testGun.setItemMeta(meta);
        return testGun;
    }

}
