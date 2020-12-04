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
import java.util.List;

public class Cow implements Listener {
    Main plugin;

    private HashMap<String, Integer> cooldownTime = new HashMap<>();

    private HashMap<String, BukkitRunnable> cooldownTask = new HashMap<>();

    public Cow(Main paramCore) {
        this.plugin = paramCore;
    }

    @EventHandler
    public void cowPet(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        ItemStack petSkull = player.getItemInHand();
        if (petSkull != null && petSkull.hasItemMeta() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Cow.name"))) && event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (this.cooldownTime.containsKey(player.getName())) {
                player.sendMessage(ChatColor.RED + "Your pet is on cooldown for" + " (" + this.cooldownTime.get(player.getName()) + "s)");
                return;
            }
            player.removePotionEffect(PotionEffectType.SLOW);
            player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
            player.removePotionEffect(PotionEffectType.BLINDNESS);
            player.removePotionEffect(PotionEffectType.WITHER);
            player.removePotionEffect(PotionEffectType.WEAKNESS);
            player.removePotionEffect(PotionEffectType.POISON);
            player.sendMessage(ChatColor.GREEN + "Your Cow pet just activated!");
            Leveling.addExp(player, petSkull, ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Cow.name")));
            this.cooldownTime.put(player.getName(), Integer.valueOf(300));
            this.cooldownTask.put(player.getName(), new BukkitRunnable() {
                public void run() {
                    Cow.this.cooldownTime.put(player.getName(), Integer.valueOf(((Integer)Cow.this.cooldownTime.get(player.getName())).intValue() - 1));
                    if (((Integer)Cow.this.cooldownTime.get(player.getName())).intValue() == 0) {
                        Cow.this.cooldownTime.remove(player.getName());
                        Cow.this.cooldownTask.remove(player.getName());
                        cancel();
                    }
                }
            });
            ((BukkitRunnable)this.cooldownTask.get(player.getName())).runTaskTimer((Plugin)this.plugin, 40L, 40L);
        }
    }
}
