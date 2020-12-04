package me.NotEnoughSkill.simplepets.pets;

import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.utili.Leveling;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Leech extends BukkitRunnable{
    Main plugin;

    public Leech(Main plugin) {
        this.plugin = plugin;
    }

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 36; i++) {
                ItemStack petSkull = player.getInventory().getItem(i);
                if (player.getInventory().getItem(i) != null) {
                    if (petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Leech.name")))) {
                        ItemStack petItem = player.getInventory().getItem(i);
                        if (Leveling.getLevel(petItem) <= 10) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
                        }
                        if (Leveling.getLevel(petItem) >= 11 && Leveling.getLevel(petItem) <= 20) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 2));
                        }
                        if (Leveling.getLevel(petItem) >= 30) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 3));
                        }
                        Leveling.addExp(player, petItem, ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Leech.name")));
                    }
                }
            }
        }
    }

}
