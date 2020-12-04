package me.NotEnoughSkill.simplepets.eggs;

import me.NotEnoughSkill.simplepets.Main;
import org.bukkit.Bukkit;
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
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class Mythic implements Listener {
    public static Main plugin;

    public Mythic(Main plugin) {
        Mythic.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR && e.getItem().getType() == Material.MONSTER_EGG &&
                e.getPlayer().getItemInHand().hasItemMeta() && e
                .getPlayer().getItemInHand().getItemMeta().getDisplayName()
                .equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&d&lMythic Pet Egg"))) {
            ItemStack stack1 = p.getItemInHand();
            if (stack1.getAmount() > 1) {
                stack1.setAmount(stack1.getAmount() - 1);
            } else {
                p.getInventory().clear(p.getInventory().getHeldItemSlot());
            }
            int rand = (int)(Math.floor(Math.random() * 4.0D) + 1.0D);
            if (rand == 1) {
                ArrayList<String> lore = new ArrayList<>();
                ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
                SkullMeta meta = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
                meta.setOwner("zdsadasf");
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Money.name")));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                for (String loreString : plugin.getConfig().getStringList("Pets.Money.lore")) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
                }
                lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&d&lMythic"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&l15 Mins"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
                meta.setLore((List) lore);
                stack.setItemMeta((ItemMeta) meta);
                p.getInventory().addItem(new ItemStack[] { new ItemStack(stack) });
                p.updateInventory();
            }
            if (rand == 2) {
                ArrayList<String> lore = new ArrayList<>();
                ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
                SkullMeta meta = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
                meta.setOwner("zHensey");
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Berserker.name")));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                for (String loreString : plugin.getConfig().getStringList("Pets.Berserker.lore")) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
                }
                lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&d&lMythic"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&l15 Mins"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
                meta.setLore((List) lore);
                stack.setItemMeta((ItemMeta) meta);
                p.getInventory().addItem(new ItemStack[] { new ItemStack(stack) });
                p.updateInventory();
            }
            if (rand == 3) {
                ArrayList<String> lore = new ArrayList<>();
                ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
                SkullMeta meta = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
                meta.setOwner("Aka_Aaron");
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Leech.name")));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                for (String loreString : plugin.getConfig().getStringList("Pets.Leech.lore")) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
                }
                lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&d&lMythic"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&lPassive"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
                meta.setLore((List) lore);
                stack.setItemMeta((ItemMeta) meta);
                p.getInventory().addItem(new ItemStack[] { new ItemStack(stack) });
                p.updateInventory();
            }
            if (rand == 4) {
                ArrayList<String> lore = new ArrayList<>();
                ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
                SkullMeta meta = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
                meta.setOwner("Elsa");
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Elsa.name")));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                for (String loreString : plugin.getConfig().getStringList("Pets.Elsa.lore")) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
                }
                lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&d&lMythic"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&l15 Mins"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
                meta.setLore((List) lore);
                stack.setItemMeta((ItemMeta) meta);
                p.getInventory().addItem(new ItemStack[] { new ItemStack(stack) });
                p.updateInventory();
            }
        }
    }
}
