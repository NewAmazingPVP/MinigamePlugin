package mod.minigameplugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.*;

import static mod.minigameplugin.MinigamePlugin.essentials;

public class Utils {

    public static void setPrefix(Player p, String s) {
        essentials.getUser(p.getUniqueId()).setNickname(ChatColor.translateAlternateColorCodes('&', s) + " " + p.getName());
    }

    public static Player returnPlayerDamager(Entity damager) {
        Player attacker = null;
        if (damager instanceof Player) {
            attacker = (Player) damager;
        } else if (damager instanceof Arrow arrow) {
            if (arrow.getShooter() instanceof Player) {
                attacker = (Player) arrow.getShooter();
            }
        } else if (damager instanceof TNTPrimed tnt) {
            if (tnt.getSource() instanceof Player) {
                attacker = (Player) tnt.getSource();
            }
        } else if (damager instanceof ThrownPotion potion) {
            if (potion.getShooter() instanceof Player) {
                attacker = (Player) potion.getShooter();
            }
        } else if (damager instanceof Trident trident) {
            if (trident.getShooter() instanceof Player) {
                attacker = (Player) trident.getShooter();
            }
        }
        return attacker;
    }

}
