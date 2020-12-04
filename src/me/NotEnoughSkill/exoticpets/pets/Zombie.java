package me.NotEnoughSkill.simplepets.pets;

import com.SirBlobman.combatlogx.CombatLogX;
import com.SirBlobman.combatlogx.utility.CombatUtil;
import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.utili.Leveling;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;

public class Zombie implements Listener {
    Main plugin;

    Random rand = new Random();

    private HashMap<String, Integer> cooldownTime = new HashMap<>();

    private HashMap<String, BukkitRunnable> cooldownTask = new HashMap<>();

    public Zombie(Main paramCore) {
        this.plugin = paramCore;
    }

    @EventHandler
    public void zombiePet(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        ItemStack petSkull = player.getItemInHand();
        boolean isInCombat = CombatUtil.isInCombat(player);
        if (petSkull != null && petSkull.hasItemMeta() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().getDisplayName().contains(this.plugin.getConfig().getString("Pets.Zombie.name")) && event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (this.cooldownTime.containsKey(player.getName())) {
                player.sendMessage(ChatColor.RED + "Your pet is on cooldown for" + " (" + this.cooldownTime.get(player.getName()) + "s)");
                return;
            }
            for (Entity g : player.getNearbyEntities(5.0, 5.0, 5.0)) {
                if (isInCombat) {
                    if (g instanceof Player) {
                        if (Leveling.getLevel(petSkull) <= 5) {
                            ((Player)g).addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 160, 2));
                        }
                        if (Leveling.getLevel(petSkull) >= 11 && Leveling.getLevel(petSkull) <= 10) {
                            ((Player)g).addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 220, 3));
                        }
                        if (Leveling.getLevel(petSkull) >= 15) {
                            ((Player)g).addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 300, 4));
                        }
                        player.sendMessage(ChatColor.GREEN + "Your Zombie pet just activated!");
                        Leveling.addExp(player, petSkull, this.plugin.getConfig().getString("Pets.Zombie.name"));
                        this.cooldownTime.put(player.getName(), Integer.valueOf(600));
                        this.cooldownTask.put(player.getName(), new BukkitRunnable() {
                            public void run() {
                                Zombie.this.cooldownTime.put(player.getName(), Integer.valueOf(((Integer)Zombie.this.cooldownTime.get(player.getName())).intValue() - 1));
                                if (((Integer)Zombie.this.cooldownTime.get(player.getName())).intValue() == 0) {
                                    Zombie.this.cooldownTime.remove(player.getName());
                                    Zombie.this.cooldownTask.remove(player.getName());
                                    cancel();
                                }
                            }
                        });
                        ((BukkitRunnable)this.cooldownTask.get(player.getName())).runTaskTimer((Plugin)this.plugin, 40L, 40L);
                    }
                } else {
                    return;
                }
            }

        }
    }
}
