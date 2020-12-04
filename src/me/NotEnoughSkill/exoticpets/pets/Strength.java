package me.NotEnoughSkill.simplepets.pets;

import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.utili.Leveling;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class Strength implements Listener {
    Main plugin;

    private HashMap<String, Integer> cooldownTime = new HashMap<>();

    private HashMap<String, BukkitRunnable> cooldownTask = new HashMap<>();

    public Strength(Main paramCore) {
        this.plugin = paramCore;
    }

    @EventHandler
    public void berserkerPet(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        ItemStack petSkull = player.getItemInHand();
        if (petSkull != null && petSkull.hasItemMeta() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Berserker.name"))) && event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (this.cooldownTime.containsKey(player.getName())) {
                player.sendMessage(ChatColor.RED + "Your pet is on cooldown for" + " (" + this.cooldownTime.get(player.getName()) + "s)");
                return;
            }
            if (Leveling.getLevel(petSkull) <= 5) {
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 3));
            }
            if (Leveling.getLevel(petSkull) >= 6 && Leveling.getLevel(petSkull) <= 10) {
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 3));
            }
            if (Leveling.getLevel(petSkull) >= 11 && Leveling.getLevel(petSkull) <= 15) {
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 3));
            }
            if (Leveling.getLevel(petSkull) >= 20) {
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 3));
            }
            player.sendMessage(ChatColor.GREEN + "Your Berserker pet just activated!");
            Leveling.addExp(player, petSkull, ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Berserker.name")));
            this.cooldownTime.put(player.getName(), Integer.valueOf(900));
            this.cooldownTask.put(player.getName(), new BukkitRunnable() {
                public void run() {
                    Strength.this.cooldownTime.put(player.getName(), Integer.valueOf(((Integer)Strength.this.cooldownTime.get(player.getName())).intValue() - 1));
                    if (((Integer)Strength.this.cooldownTime.get(player.getName())).intValue() == 0) {
                        Strength.this.cooldownTime.remove(player.getName());
                        Strength.this.cooldownTask.remove(player.getName());
                        cancel();
                    }
                }
            });
            ((BukkitRunnable)this.cooldownTask.get(player.getName())).runTaskTimer((Plugin)this.plugin, 40L, 40L);
        }
    }


}
