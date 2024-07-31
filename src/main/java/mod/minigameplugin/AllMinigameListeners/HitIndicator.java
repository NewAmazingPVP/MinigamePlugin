package mod.minigameplugin.AllMinigameListeners;

import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
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
        World world = entity.getWorld();



        DecimalFormat df = new DecimalFormat("0.0");

        new SummonDamageIndicatorEntity(location, damageAmount, world);


    }


}
