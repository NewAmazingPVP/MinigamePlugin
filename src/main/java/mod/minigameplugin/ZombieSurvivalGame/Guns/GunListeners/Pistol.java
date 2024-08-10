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
import java.util.List;

import static mod.minigameplugin.Minigames.Zombies.ZombiesGuns.GUN_UTILS.linkPlayerToBulletCount;
import static mod.minigameplugin.ZombieSurvivalGame.Guns.GunItemStacks.pistol;

public class Pistol implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player attacker = event.getPlayer();
        ItemStack itemInHand = attacker.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (event.getAction().name().contains("RIGHT_CLICK") && event.getItem() != null) {
            attacker.sendMessage("test1");
            if (itemInHand != null && itemInHand.hasItemMeta()) {

                    attacker.sendMessage("test2");

                    if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

                        if (meta.hasLore() && meta.getItemName().toString().contains("Pistol")) {

                            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();

                            String currentBulletCountString = lore.get(3); //<<<<<<<<<<<<<<<<<<< CHANGE IF NEEDED

                            int currentBulletCountInt = 0;

                            attacker.sendMessage("test3"); 

                        for (char c : currentBulletCountString.toCharArray()) {
                            if (Character.isDigit(c)) {
                                currentBulletCountInt += c;
                            }
                        }

                        attacker.sendMessage(" " + currentBulletCountInt);

                        currentBulletCountInt -= 1;

                        attacker.getInventory().setItemInMainHand(pistol(false, currentBulletCountInt));

                        if (currentBulletCountInt >= 1) {


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
                        } else {
                            attacker.sendMessage(ChatColor.RED + "Out Of Ammo");
                        }
                    }
                }
            }
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
