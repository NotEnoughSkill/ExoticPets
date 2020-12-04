package me.NotEnoughSkill.simplepets.pets;

import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.utili.Leveling;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Spider extends BukkitRunnable {
    Main plugin;

    public Spider(Main plugin) {
        this.plugin = plugin;
    }

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 36; i++) {
                ItemStack petSkull = player.getInventory().getItem(i);
                if (player.getInventory().getItem(i) != null) {
                    if (petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Spider.name")))) {
                        ItemStack petItem = player.getInventory().getItem(i);
                        if (Leveling.getLevel(petItem) <= 10) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 1));
                        }
                        if (Leveling.getLevel(petItem) >= 11 && Leveling.getLevel(petItem) <= 20) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 2));
                        }
                        if (Leveling.getLevel(petItem) >= 30) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 3));
                        }
                        Leveling.addExp(player, petItem, ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Spider.name")));
                    }
                }
            }
        }
    }

}
