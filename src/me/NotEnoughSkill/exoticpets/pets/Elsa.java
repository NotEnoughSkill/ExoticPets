package me.NotEnoughSkill.simplepets.pets;

import com.SirBlobman.combatlogx.utility.CombatUtil;
import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.utili.Leveling;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Elsa implements Listener {
    Main plugin;

    private boolean inCombat = false;
    private boolean freeze = false;

    private int dur = 100;

    private HashMap<String, Integer> cooldownTime = new HashMap<>();

    private HashMap<String, BukkitRunnable> cooldownTask = new HashMap<>();

    private HashMap<String, Player> frozen = new HashMap<String, Player>();

    public Elsa(Main paramCore) {
        this.plugin = paramCore;
    }

    @EventHandler
    public void elsaPet(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        ItemStack petSkull = player.getItemInHand();
        if (petSkull != null && petSkull.hasItemMeta() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Elsa.name"))) && event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (CombatUtil.isInCombat(player)) {
                if (this.cooldownTime.containsKey(player.getName())) {
                    player.sendMessage(ChatColor.RED + "Your pet is on cooldown for" + " (" + this.cooldownTime.get(player.getName()) + "s)");
                    return;
                }
                if (Leveling.getLevel(petSkull) <= 5) {
                    freeze = true;
                    dur = 100;
                }
                if (Leveling.getLevel(petSkull) >= 6 && Leveling.getLevel(petSkull) <= 10) {
                    freeze = true;
                    dur = 150;
                }
                if (Leveling.getLevel(petSkull) >= 15) {
                    freeze = true;
                    dur = 200;
                }
                player.sendMessage(ChatColor.GREEN + "Your Elsa pet just activated!");
                Leveling.addExp(player, petSkull, ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Elsa.name")));
                this.cooldownTime.put(player.getName(), Integer.valueOf(900));
                this.cooldownTask.put(player.getName(), new BukkitRunnable() {
                    public void run() {
                        Elsa.this.cooldownTime.put(player.getName(), Integer.valueOf(((Integer)Elsa.this.cooldownTime.get(player.getName())).intValue() - 1));
                        if (((Integer)Elsa.this.cooldownTime.get(player.getName())).intValue() == 0) {
                            Elsa.this.cooldownTime.remove(player.getName());
                            Elsa.this.cooldownTask.remove(player.getName());
                            cancel();
                        }
                    }
                });
                ((BukkitRunnable)this.cooldownTask.get(player.getName())).runTaskTimer((Plugin)this.plugin, 40L, 40L);
            } else {
                player.sendMessage(ChatColor.RED + "No valid target!");
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity (EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            Player attacker = (Player) e.getDamager();
            Player damaged = (Player) e.getEntity();
            if (freeze && CombatUtil.isInCombat(damaged) && CombatUtil.isInCombat(attacker)) {
                attacker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, dur, 1000));
                attacker.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, dur, 250));
                attacker.sendMessage(ChatColor.RED + "You have been frozen for 5s!");
                damaged.sendMessage(ChatColor.GREEN + "You have frozen " + ChatColor.GREEN + attacker.getDisplayName() + ChatColor.GREEN + "!");
                freeze = false;
                attacker.sendMessage(ChatColor.RED + "You are no longer frozen!");
                damaged.sendMessage(ChatColor.GREEN + attacker.getDisplayName() + ChatColor.GREEN + " is no longer frozen!");
            }
        }
    }

    public void move(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Player damaged = frozen.get("Damaged");
        if (inCombat && freeze) {
            //damaged.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1000));
        }
    }


}
