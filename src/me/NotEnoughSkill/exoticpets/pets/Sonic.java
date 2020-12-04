package me.NotEnoughSkill.simplepets.pets;

import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.utili.Leveling;
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

public class Sonic implements Listener {
    Main plugin;

    private HashMap<String, Integer> cooldownTime = new HashMap<>();

    private HashMap<String, BukkitRunnable> cooldownTask = new HashMap<>();

    public Sonic(Main paramCore) {
        this.plugin = paramCore;
    }

    @EventHandler
    public void sonicPet(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        ItemStack petSkull = player.getItemInHand();
        if (petSkull != null && petSkull.hasItemMeta() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Sonic.name"))) && event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (this.cooldownTime.containsKey(player.getName())) {
                player.sendMessage(ChatColor.RED + "Your pet is on cooldown for" + " (" + this.cooldownTime.get(player.getName()) + "s)");
                return;
            }
            if (Leveling.getLevel(petSkull) <= 5) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));
            }
            if (Leveling.getLevel(petSkull) >= 6 && Leveling.getLevel(petSkull) <= 10) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 3));
            }
            if (Leveling.getLevel(petSkull) >= 15) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 3));
            }
            player.sendMessage(ChatColor.GREEN + "Your Sonic pet just activated!");
            Leveling.addExp(player, petSkull, ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Sonic.name")));
            this.cooldownTime.put(player.getName(), Integer.valueOf(600));
            this.cooldownTask.put(player.getName(), new BukkitRunnable() {
                public void run() {
                    Sonic.this.cooldownTime.put(player.getName(), Integer.valueOf(((Integer)Sonic.this.cooldownTime.get(player.getName())).intValue() - 1));
                    if (((Integer)Sonic.this.cooldownTime.get(player.getName())).intValue() == 0) {
                        Sonic.this.cooldownTime.remove(player.getName());
                        Sonic.this.cooldownTask.remove(player.getName());
                        cancel();
                    }
                }
            });
            ((BukkitRunnable)this.cooldownTask.get(player.getName())).runTaskTimer((Plugin)this.plugin, 40L, 40L);
        }
    }
}
