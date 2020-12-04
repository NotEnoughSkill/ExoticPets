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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class Value implements Listener {
    Main plugin;

    private HashMap<String, Integer> cooldownTime = new HashMap<>();

    private HashMap<String, BukkitRunnable> cooldownTask = new HashMap<>();

    public Value(Main paramCore) {
        this.plugin = paramCore;
    }

    @EventHandler
    public void valuePet(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        ItemStack petSkull = player.getItemInHand();
        if (petSkull != null && petSkull.hasItemMeta() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().hasDisplayName() && petSkull.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Value.name"))) && event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (this.cooldownTime.containsKey(player.getName())) {
                player.sendMessage(ChatColor.RED + "Your pet is on cooldown for" + " (" + this.cooldownTime.get(player.getName()) + "s)");
                return;
            }

            if (Leveling.getLevel(petSkull) <= 5) {
                int rand = (int)(Math.floor(Math.random() * 5.0D) + 1.0D);
                ItemStack sponge = new ItemStack(Material.SPONGE, rand);
                ItemMeta spongeMeta = sponge.getItemMeta();
                ArrayList<String> spongeLore = new ArrayList<String>();
                spongeMeta.setDisplayName(ChatColor.AQUA + "Sponge Cell Value");
                spongeLore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                spongeLore.add(ChatColor.translateAlternateColorCodes('&', "&7* When placed in a cell"));
                spongeLore.add(ChatColor.translateAlternateColorCodes('&', "&7  it will give you +x"));
                spongeLore.add(ChatColor.translateAlternateColorCodes('&', "&7  cell value."));
                sponge.setItemMeta(spongeMeta);
                spongeMeta.setLore(spongeLore);
                player.getInventory().addItem(sponge);
            }
            if (Leveling.getLevel(petSkull) >= 6 && Leveling.getLevel(petSkull) <= 10) {
                int rand = (int)(Math.floor(Math.random() * 10.0D) + 1.0D);
                ItemStack beacon = new ItemStack(Material.BEACON, rand);
                ItemMeta beaconMeta = beacon.getItemMeta();
                ArrayList<String> beaconLore = new ArrayList<String>();
                beaconMeta.setDisplayName(ChatColor.AQUA + "Beacon Cell Value");
                beaconLore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                beaconLore.add(ChatColor.translateAlternateColorCodes('&', "&7* When placed in a cell"));
                beaconLore.add(ChatColor.translateAlternateColorCodes('&', "&7  it will give you +x"));
                beaconLore.add(ChatColor.translateAlternateColorCodes('&', "&7  cell value."));
                beacon.setItemMeta(beaconMeta);
                beaconMeta.setLore(beaconLore);
                player.getInventory().addItem(beacon);
            }
            if (Leveling.getLevel(petSkull) >= 11 && Leveling.getLevel(petSkull) <= 15) {
                int rand = (int)(Math.floor(Math.random() * 20.0D) + 1.0D);
                ItemStack noteblock = new ItemStack(Material.NOTE_BLOCK, rand);
                ItemMeta noteblockMeta = noteblock.getItemMeta();
                ArrayList<String> noteblockLore = new ArrayList<String>();
                noteblockMeta.setDisplayName(ChatColor.AQUA + "Noteblock Cell Value");
                noteblockLore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                noteblockLore.add(ChatColor.translateAlternateColorCodes('&', "&7* When placed in a cell"));
                noteblockLore.add(ChatColor.translateAlternateColorCodes('&', "&7  it will give you +x"));
                noteblockLore.add(ChatColor.translateAlternateColorCodes('&', "&7  cell value."));
                noteblock.setItemMeta(noteblockMeta);
                noteblockMeta.setLore(noteblockLore);
                player.getInventory().addItem(noteblock);
            }
            player.sendMessage(ChatColor.GREEN + "Your Value pet just activated!");
            Leveling.addExp(player, petSkull, ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Pets.Value.name")));
            this.cooldownTime.put(player.getName(), Integer.valueOf(600));
            this.cooldownTask.put(player.getName(), new BukkitRunnable() {
                public void run() {
                    Value.this.cooldownTime.put(player.getName(), Integer.valueOf(((Integer)Value.this.cooldownTime.get(player.getName())).intValue() - 1));
                    if (((Integer)Value.this.cooldownTime.get(player.getName())).intValue() == 0) {
                        Value.this.cooldownTime.remove(player.getName());
                        Value.this.cooldownTask.remove(player.getName());
                        cancel();
                    }
                }
            });
            ((BukkitRunnable)this.cooldownTask.get(player.getName())).runTaskTimer((Plugin)this.plugin, 40L, 40L);
        }
    }
}
