package mod.minigameplugin.ZombieSurvivalGame.Guns.GunListeners;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mod.minigameplugin.ZombieSurvivalGame.Guns.GunItemStacks.pistol;
import static mod.minigameplugin.ZombieSurvivalGame.Guns.GunUtils.*;

public class Pistol implements Listener {

    private final Map<Player, CooldownManager> tntCooldowns = new HashMap<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player attacker = event.getPlayer();
        ItemStack itemInHand = attacker.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (event.getAction().name().contains("RIGHT_CLICK") && event.getItem() != null && itemInHand != null && itemInHand.hasItemMeta() && meta.getLore().toString().contains("ID: pistol")) {


            if (linkPlayerToPistolBulletCount.get(attacker) >= 1) {


                linkPlayerToPistolBulletCount.put(attacker, linkPlayerToPistolBulletCount.getOrDefault(attacker, 0) - 1);

                attacker.getInventory().setItemInMainHand(pistol(false, linkPlayerToPistolBulletCount.get(attacker)));


                Location location = attacker.getEyeLocation().add(0, 0.2, 0);
                Vector attackerLookDir = attacker.getLocation().getDirection().multiply(.5);
                Vector direction = attacker.getEyeLocation().getDirection();
                Location targetLocation = attacker.getEyeLocation().clone();
                double range = 500;


                for (double i = 0; i < 10; i++) {
                    location.add(attackerLookDir);
                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                        player2.getWorld().spawnParticle(Particle.CRIT, location, 0);


                    }
                }

                playSoundFromLocToEvryone(attacker, Sound.ENTITY_BLAZE_HURT, 1.0f, 2.0f);

                for (int i = 0; i < range; i++) {
                    targetLocation.add(direction);

                    Entity target = getTargetEntityAtLocation(targetLocation);
                    if (target != null) {
                        if (target instanceof Entity) {


                            ((LivingEntity) target).damage(1,attacker);


                        }
                        break;
                    }
                    // Target location is obstructed by a block
                    if (targetLocation.getBlock().getType().isSolid()) {
                        break;
                    }
                }
            } else {
                attacker.sendMessage(ChatColor.RED + "Out Of Ammo: Left Click To Reload!");
            }
        }else if(event.getAction().name().contains("LEFT_CLICK") && event.getItem() != null && itemInHand != null && itemInHand.hasItemMeta() && meta.getLore().toString().contains("ID: pistol")) {
            reloadGun(attacker,"PISTOL");
        }


    }



    private Entity getTargetEntityAtLocation(Location location) {
        for (Entity target : location.getWorld().getEntities()) {
            if ((target.getLocation().getBlock().getX() == location.getBlock().getX()) &&
                    (target.getLocation().getBlock().getZ() == location.getBlock().getZ()) &&
                    (target.getLocation().getBlock().getY() >= location.getBlock().getY() - target.getHeight()) &&
                    (target.getLocation().getBlock().getY() <= location.getBlock().getY() + target.getHeight()) &&
                    (target instanceof LivingEntity)) {
                return target;
            }
        }
        return null;
    }
}
