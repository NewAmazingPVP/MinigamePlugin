package mod.minigameplugin.AllMinigameListeners;

import org.bukkit.*;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static mod.minigameplugin.MinigamePlugin.minigamePlugin;

public class SummonDamageIndicatorEntity {

    public static BukkitRunnable mageMobAttackRate;

    public SummonDamageIndicatorEntity(Location location, Double damageAmount, World world) {

        //Make zombie
        /*ArmorStand armorStand = (ArmorStand) world.spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setSmall(true);
        armorStand.setInvulnerable(true);
        armorStand.setGravity(true);
        armorStand.setCustomNameVisible(true);

        String customTag = "damage_indicator";
        MetadataValue customTagValue = new FixedMetadataValue(minigamePlugin, customTag);
        armorStand.setMetadata(customTag, customTagValue);

        if (damageAmount <= 1) {
            armorStand.setCustomName(ChatColor.GREEN + "" + ChatColor.BOLD + damageAmount + ChatColor.GREEN + "❤");
        } else if (damageAmount > 1 && damageAmount <= 2) {
            armorStand.setCustomName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + damageAmount + ChatColor.DARK_GREEN + "❤");
        } else if (damageAmount > 2 && damageAmount <= 3) {
            armorStand.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + damageAmount + ChatColor.YELLOW + "❤");
        } else if (damageAmount > 3 && damageAmount <= 4) {
            armorStand.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + damageAmount + ChatColor.GOLD + "❤");
        } else if (damageAmount > 4 && damageAmount <= 5) {
            armorStand.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + damageAmount + ChatColor.RED + "❤");
        } else if (damageAmount > 5 && damageAmount <= 6) {
            armorStand.setCustomName(ChatColor.DARK_RED + "" + ChatColor.BOLD + damageAmount + ChatColor.DARK_RED + "❤");
        } else if (damageAmount > 6 && damageAmount <= 7) {
            armorStand.setCustomName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + damageAmount + ChatColor.LIGHT_PURPLE + "❤");
        } else if (damageAmount > 7) {
            armorStand.setCustomName(ChatColor.BLACK + "" + ChatColor.BOLD + damageAmount + ChatColor.BLACK + "❤");
        }

        double randomX = Math.random() * 2 - 1; // Random value between -1 and 1
        double randomZ = Math.random() * 2 - 1; // Random value between -1 and 1

        double randomXFix = randomX / 2;
        double randomZFix = randomZ / 3;

        org.bukkit.util.Vector velocity = new Vector(randomXFix, .2, randomZFix);
        armorStand.setVelocity(velocity);*/


        /*mageMobAttackRate = new BukkitRunnable() {
            @Override
            public void run() {

                if (armorStand.isDead()) {
                    this.cancel();
                    return;
                }

                armorStand.remove();

            }
        };
        mageMobAttackRate.runTaskTimer(minigamePlugin, 40L, 20L);*/



        TextDisplay textDisplay = (TextDisplay) world.spawnEntity(location, EntityType.TEXT_DISPLAY);


        textDisplay.setSeeThrough(false);
        textDisplay.setShadowed(true);
        textDisplay.setBackgroundColor(Color.AQUA); 

        if (damageAmount <= 1) {
            textDisplay.setCustomName(ChatColor.GREEN + "" + ChatColor.BOLD + damageAmount + ChatColor.GREEN + "❤");
        } else if (damageAmount > 1 && damageAmount <= 2) {
            textDisplay.setCustomName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + damageAmount + ChatColor.DARK_GREEN + "❤");
        } else if (damageAmount > 2 && damageAmount <= 3) {
            textDisplay.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + damageAmount + ChatColor.YELLOW + "❤");
        } else if (damageAmount > 3 && damageAmount <= 4) {
            textDisplay.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + damageAmount + ChatColor.GOLD + "❤");
        } else if (damageAmount > 4 && damageAmount <= 5) {
            textDisplay.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + damageAmount + ChatColor.RED + "❤");
        } else if (damageAmount > 5 && damageAmount <= 6) {
            textDisplay.setCustomName(ChatColor.DARK_RED + "" + ChatColor.BOLD + damageAmount + ChatColor.DARK_RED + "❤");
        } else if (damageAmount > 6 && damageAmount <= 7) {
            textDisplay.setCustomName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + damageAmount + ChatColor.LIGHT_PURPLE + "❤");
        } else if (damageAmount > 7) {
            textDisplay.setCustomName(ChatColor.BLACK + "" + ChatColor.BOLD + damageAmount + ChatColor.BLACK + "❤");
        }



    }

}
