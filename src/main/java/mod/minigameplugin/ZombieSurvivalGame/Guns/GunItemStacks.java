package mod.minigameplugin.ZombieSurvivalGame.Guns;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GunItemStacks {



    public static ItemStack pistolAmmo(){

        ItemStack pistolAmmo = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = pistolAmmo.getItemMeta();

        meta.setDisplayName(ChatColor.BLUE + "Pistol Ammo");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Used to load a pistol.");
        meta.setLore(lore);

        return pistolAmmo;
    }

    public static ItemStack shotgunAmmo(){

        ItemStack pistolAmmo = new ItemStack(Material.RED_CANDLE);
        ItemMeta meta = pistolAmmo.getItemMeta();

        meta.setDisplayName(ChatColor.RED + "Shotgun Ammo");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Used to load a shotgun.");
        meta.setLore(lore);

        return pistolAmmo;
    }
    
    public static ItemStack specialAmmo(){

        ItemStack pistolAmmo = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta meta = pistolAmmo.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "Special Ammo");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Used to load special guns.");
        meta.setLore(lore);

        return pistolAmmo;
    }






















    public static ItemStack pistol(Boolean reloading, Integer bulletCount) {
        ItemStack testGun = new ItemStack(Material.WOODEN_HOE);
        ItemMeta meta = testGun.getItemMeta();


        if(!reloading) {

            meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "[GUN] " + ChatColor.AQUA + "" + ChatColor.BOLD + "Pistol" + ChatColor.DARK_GREEN + " | " + bulletCount);


            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Right Click]" + ChatColor.DARK_PURPLE + " To Fire.");
            lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Left Click]" + ChatColor.DARK_PURPLE + " To Reload.");
            lore.add(ChatColor.DARK_GRAY + "ID: pistol");
            meta.setLore(lore);



        }else{
            meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Reloading..." + bulletCount);
        }


        testGun.setItemMeta(meta);
        return testGun;
    }

}
