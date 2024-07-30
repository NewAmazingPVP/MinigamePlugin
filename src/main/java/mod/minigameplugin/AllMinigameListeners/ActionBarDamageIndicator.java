package mod.minigameplugin.AllMinigameListeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.text.DecimalFormat;

import static mod.minigameplugin.Utils.returnPlayerDamager;

public class ActionBarDamageIndicator implements Listener {

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
        String name = entity.getName();





        double maxHealth = damagedEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        double currentHealth = Math.max(damagedEntity.getHealth() - e.getFinalDamage(), 0);
        DecimalFormat df = new DecimalFormat("0.0");



        String actionbarVisual = ChatColor.GOLD + name + " - ";


        actionbarVisual += ChatColor.RED + "";

        if(currentHealth > 0) {


            for (int i = 0; i < currentHealth; i++) {
                actionbarVisual += "❤";
            }

            actionbarVisual += ChatColor.GRAY;

            double missingHP = maxHealth - currentHealth;

            for (int i = 0; i < missingHP; i++) {
                actionbarVisual += "❤";
            }

            actionbarVisual += ChatColor.RED + " " + df.format(e.getDamage()); 

            attacker.sendActionBar(actionbarVisual);

        }else{
            attacker.sendActionBar(ChatColor.GOLD + name + " - " + ChatColor.RED + "DEAD " + df.format(e.getDamage()));
        }

    }

}
