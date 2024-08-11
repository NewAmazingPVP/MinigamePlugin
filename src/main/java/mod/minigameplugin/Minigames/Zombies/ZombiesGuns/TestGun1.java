package mod.minigameplugin.Minigames.Zombies.ZombiesGuns;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;


public class TestGun1 {



    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player attacker = event.getPlayer();
        ItemStack itemInHand = attacker.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (event.getAction().name().contains("RIGHT_CLICK") && event.getItem() != null) {
            if (itemInHand != null && itemInHand.hasItemMeta()) {
                if (meta.hasLore() && meta.getLore().toString().contains("Test Gun")) {

                    if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

                        //int bulletCount = linkPlayerToBulletCount.get(attacker);

                        //if (bulletCount > 0) {

                            Location location = attacker.getEyeLocation().add(0, 0.2, 0);
                            Vector attackerLookDir = attacker.getLocation().getDirection().multiply(0.1);
                            Vector direction = attacker.getEyeLocation().getDirection();
                            Location targetLocation = attacker.getEyeLocation().clone();
                            double range = 500;


                            for (double i = 0; i < 150; i++) {
                                location.add(attackerLookDir);
                                for (Player player2 : Bukkit.getOnlinePlayers()) {
                                    player2.getWorld().spawnParticle(Particle.END_ROD, location, 0);


                                }
                            }

                            for (int i = 0; i < range; i++) {
                                targetLocation.add(direction);

                                Entity target = getTargetEntityAtLocation(targetLocation);
                                if (target != null) {
                                    if (target instanceof Entity) {
                                        if (event.getItem().getType() == Material.STICK) {

                                            //Things you want staff to do goes here

                                            ((LivingEntity) target).damage(1);
                                        }
                                    }
                                    break;
                                }
                                // Target location is obstructed by a block
                                if (targetLocation.getBlock().getType().isSolid()) {
                                    break;
                                }
                            }
                        }else{
                            attacker.sendMessage(ChatColor.RED + "Out Of Ammo");
                        }
                    }
                }
            }
        }
    //}

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
