package me.NotEnoughSkill.simplepets.eggs;

import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.pets.Pets;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class Simple implements Listener {
    public static Main plugin;

    public Simple(Main plugin) {
        Simple.plugin = plugin;
    }

    @EventHandler
    public void onInteract (final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR && e.getItem().getType() == Material.MONSTER_EGG && e.getPlayer().getItemInHand().hasItemMeta() && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&7&lSimple Pet Egg"))) {
            final ItemStack stack1 = p.getItemInHand();
            if (stack1.getAmount() > 1) {
                stack1.setAmount(stack1.getAmount() - 1);
            } else {
                p.getInventory().clear(p.getInventory().getHeldItemSlot());
            }
            final int rand = (int)(Math.floor(Math.random() * 4.0) + 1.0);
            if (rand == 1) {
                final ArrayList<String> lore = new ArrayList<String>();
                final ItemStack stack2 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
                meta.setOwner("MHF_Cow");
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Cow.name")));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                for (String loreString : plugin.getConfig().getStringList("Pets.Cow.lore")) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
                }
                lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&8&lSimple"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&l5 Mins"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
                meta.setLore((List) lore);
                stack2.setItemMeta((ItemMeta) meta);
                p.getInventory().addItem(new ItemStack[] { new ItemStack(stack2) });
                p.updateInventory();
            }
            if (rand == 2) {
                final ArrayList<String> lore = new ArrayList<String>();
                final ItemStack stack2 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
                meta.setOwner("1_More_Game");
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Potion.name")));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                for (String loreString : plugin.getConfig().getStringList("Pets.Potion.lore")) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
                }
                lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&8&lSimple"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&l5 Mins"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
                meta.setLore((List) lore);
                stack2.setItemMeta((ItemMeta) meta);
                p.getInventory().addItem(new ItemStack[] { new ItemStack(stack2) });
                p.updateInventory();
            }
            if (rand == 3) {
                final ArrayList<String> lore = new ArrayList<String>();
                final ItemStack stack2 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
                meta.setOwner("Miner");
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Miner.name")));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                for (String loreString : plugin.getConfig().getStringList("Pets.Miner.lore")) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
                }
                lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&8&lSimple"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&lPassive"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
                meta.setLore((List) lore);
                stack2.setItemMeta((ItemMeta) meta);
                p.getInventory().addItem(new ItemStack[] { new ItemStack(stack2) });
                p.updateInventory();
            }
            if (rand == 4) {
                final ArrayList<String> lore = new ArrayList<String>();
                final ItemStack stack2 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
                meta.setOwner("_Tinycloud");
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Spider.name")));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                for (String loreString : plugin.getConfig().getStringList("Pets.Spider.lore")) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
                }
                lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&8&lSimple"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&lPassive"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
                meta.setLore((List) lore);
                stack2.setItemMeta((ItemMeta) meta);
                p.getInventory().addItem(new ItemStack[] { new ItemStack(stack2) });
                p.updateInventory();
            }
        }
    }
}
