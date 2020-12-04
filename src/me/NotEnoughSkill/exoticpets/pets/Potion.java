package me.NotEnoughSkill.simplepets.pets;

import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.utili.Leveling;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class Potion implements Listener {
    Main plugin;

    private HashMap<String, Integer> cooldownTime = new HashMap<>();

    private HashMap<String, BukkitRunnable> cooldownTask = new HashMap<>();

    public Potion(Main paramCore) {
        this.plugin = paramCore;
    }

    @EventHandler
    public void potionPet(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        ItemStack petSkull = player.getItemInHand();
        if (petSkull != null && petSkull.hasItemMeta() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Potion.name"))) && event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (this.cooldownTime.containsKey(player.getName())) {
                player.sendMessage(ChatColor.RED + "Your pet is on cooldown for" + " (" + this.cooldownTime.get(player.getName()) + "s)");
                return;
            }

            Inventory inv = player.getInventory();
            for (int i = 0; i < player.getInventory().getSize(); i++) {
                if (inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR)) {
                    inv.setItem(i, new ItemStack(Material.POTION, 1, (short)16389));
                }
            }
            player.sendMessage(ChatColor.GREEN + "Your Potion pet just activated!");
            Leveling.addExp(player, petSkull, ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Potion.name")));
            this.cooldownTime.put(player.getName(), Integer.valueOf(300));
            this.cooldownTask.put(player.getName(), new BukkitRunnable() {
                public void run() {
                    Potion.this.cooldownTime.put(player.getName(), Integer.valueOf(((Integer)Potion.this.cooldownTime.get(player.getName())).intValue() - 1));
                    if (((Integer)Potion.this.cooldownTime.get(player.getName())).intValue() == 0) {
                        Potion.this.cooldownTime.remove(player.getName());
                        Potion.this.cooldownTask.remove(player.getName());
                        cancel();
                    }
                }
            });
            ((BukkitRunnable)this.cooldownTask.get(player.getName())).runTaskTimer((Plugin)this.plugin, 40L, 40L);
        }
    }
}
