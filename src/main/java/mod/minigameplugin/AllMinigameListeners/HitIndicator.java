package mod.minigameplugin.AllMinigameListeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.text.DecimalFormat;

import static mod.minigameplugin.Utils.returnPlayerDamager;

public class HitIndicator implements Listener {

    @EventHandler
    public void entityDamaged(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof LivingEntity damagedEntity)) {
            return;
        }

        Player attacker = returnPlayerDamager(e.getDamager());

        if (attacker == null) {
            return;
        }

        Entity entity = e.getEntity();
        Location location = entity.getLocation();
        double damageAmount = e.getDamage();



        DecimalFormat df = new DecimalFormat("0.0");

        ArmorStand armorStand = (ArmorStand) entity.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setSmall(true);
        armorStand.setInvulnerable(true);
        armorStand.setGravity(true);
        armorStand.setCustomNameVisible(true);

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
        double randomZFix = randomZ / 2;

        org.bukkit.util.Vector velocity = new Vector(randomXFix, .2, randomZFix);
        armorStand.setVelocity(velocity);

        Bukkit.getScheduler().runTaskLater((Plugin) this, armorStand::remove, 100);



    }

}
