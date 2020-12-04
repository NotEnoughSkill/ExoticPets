package me.NotEnoughSkill.simplepets.pets;

import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.utili.Leveling;
import me.clip.autosell.AutoSell;
import me.clip.autosell.AutoSellAPI;
import me.clip.autosell.multipliers.Multipliers;
import me.clip.autosell.objects.Multiplier;
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

import java.util.HashMap;

public class Money implements Listener {
    Main plugin;

    private HashMap<String, Integer> cooldownTime = new HashMap<>();

    private HashMap<String, BukkitRunnable> cooldownTask = new HashMap<>();

    public Money(Main paramCore) {
        this.plugin = paramCore;
    }

    @EventHandler
    public void moneyPet(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        ItemStack petSkull = player.getItemInHand();
        if (petSkull != null && petSkull.hasItemMeta() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Money.name"))) && event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (this.cooldownTime.containsKey(player.getName())) {
                player.sendMessage(ChatColor.RED + "Your pet is on cooldown for" + " (" + this.cooldownTime.get(player.getName()) + "s)");
                return;
            }
            if (Leveling.getLevel(petSkull) <= 5) {
                if (Multipliers.getMultiplierByUuid(player.getUniqueId().toString()) == null) {
                    Multiplier m = new Multiplier(player.getUniqueId().toString(), player.getName(), 1, 2, false);
                    Multipliers.getMultiplier(player);
                    Multipliers.addMultiplier(m);
                }
                player.sendMessage(ChatColor.GREEN + "You have a 2x multiplier for 60 Secs!");
            }
            if (Leveling.getLevel(petSkull) >= 6 && Leveling.getLevel(petSkull) <= 10) {
                if (Multipliers.getMultiplierByUuid(player.getUniqueId().toString()) == null) {
                    Multiplier m = new Multiplier(player.getUniqueId().toString(), player.getName(), 1, 4, false);
                    Multipliers.getMultiplier(player);
                    Multipliers.addMultiplier(m);
                }
                player.sendMessage(ChatColor.GREEN + "You have a 4x multiplier for 60 Secs!");
            }
            if (Leveling.getLevel(petSkull) >= 11 && Leveling.getLevel(petSkull) <= 15) {
                if (Multipliers.getMultiplierByUuid(player.getUniqueId().toString()) == null) {
                    Multiplier m = new Multiplier(player.getUniqueId().toString(), player.getName(), 1, 6, false);
                    Multipliers.getMultiplier(player);
                    Multipliers.addMultiplier(m);
                }
                player.sendMessage(ChatColor.GREEN + "You have a 6x multiplier for 60 Secs!");
            }
            if (Leveling.getLevel(petSkull) >= 20) {
                if (Multipliers.getMultiplierByUuid(player.getUniqueId().toString()) == null) {
                    Multiplier m = new Multiplier(player.getUniqueId().toString(), player.getName(), 1, 8, false);
                    Multipliers.getMultiplier(player);
                    Multipliers.addMultiplier(m);
                }
                player.sendMessage(ChatColor.GREEN + "You have a 8x multiplier for 60 Secs!");
            }
            player.sendMessage(ChatColor.GREEN + "Your Money pet just activated!");
            Leveling.addExp(player, petSkull, ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Money.name")));
            this.cooldownTime.put(player.getName(), Integer.valueOf(900));
            this.cooldownTask.put(player.getName(), new BukkitRunnable() {
                public void run() {
                    Money.this.cooldownTime.put(player.getName(), Integer.valueOf(((Integer)Money.this.cooldownTime.get(player.getName())).intValue() - 1));
                    if (((Integer)Money.this.cooldownTime.get(player.getName())).intValue() == 0) {
                        Money.this.cooldownTime.remove(player.getName());
                        Money.this.cooldownTask.remove(player.getName());
                        cancel();
                    }
                }
            });
            ((BukkitRunnable)this.cooldownTask.get(player.getName())).runTaskTimer((Plugin)this.plugin, 40L, 40L);
        }
    }
}
