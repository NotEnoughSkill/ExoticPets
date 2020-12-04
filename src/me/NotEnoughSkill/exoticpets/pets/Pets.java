package me.NotEnoughSkill.simplepets.pets;

import me.NotEnoughSkill.simplepets.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Pets implements Listener {
    public static Main plugin;

    public Pets(Main plugin) {
        Pets.plugin = plugin;
    }

    public static ItemStack getIronGolem() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.IronGolem.name")));
        meta.setOwner("MHF_Golem");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        for (String loreString : plugin.getConfig().getStringList("Pets.IronGolem.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
        }
        lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&6&lLegendary"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&l10 Mins"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getCow() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Cow.name")));
        meta.setOwner("MHF_Cow");
        ArrayList<String> lore = new ArrayList<>();
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
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getBerserker() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Berserker.name")));
        meta.setOwner("zHensey");
        ArrayList<String> lore = new ArrayList<>();
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
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getValue() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Value.name")));
        meta.setOwner("avncharlie");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        for (String loreString : plugin.getConfig().getStringList("Pets.Value.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
        }
        lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&6&lLegendary"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&l10 Mins"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getLeech() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Leech.name")));
        meta.setOwner("Aka_Aaron");
        ArrayList<String> lore = new ArrayList<>();
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
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getMoney() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setOwner("zdsadasf");
        ArrayList<String> lore = new ArrayList<>();
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
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getPotion() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setOwner("1_More_Game");
        ArrayList<String> lore = new ArrayList<>();
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
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getZombie() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setOwner("Zombie");
        ArrayList<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Zombie.name")));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        for (String loreString : plugin.getConfig().getStringList("Pets.Zombie.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
        }
        lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&6&lLegendary"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&l10 Mins"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getMiner() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setOwner("Miner");
        ArrayList<String> lore = new ArrayList<>();
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
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getSpider() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setOwner("_Tinycloud");
        ArrayList<String> lore = new ArrayList<>();
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
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getElsa() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setOwner("Elsa");
        ArrayList<String> lore = new ArrayList<>();
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
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getSonic() {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setOwner("Sonic");
        ArrayList<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Pets.Sonic.name")));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        for (String loreString : plugin.getConfig().getStringList("Pets.Sonic.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
        }
        lore.add(ChatColor.GRAY + "Rarity: " + ChatColor.translateAlternateColorCodes('&', "&6&lLegendary"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        lore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.translateAlternateColorCodes('&', "&f&l10 Mins"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&r"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 0"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / 200"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&c||||||||||||||||||||||||||||||||||||||||||||||||||"));
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getLegendaryPetEgg() {
        ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (short)3);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Eggs.Legendary.name")));
        ArrayList<String> lore = new ArrayList<>();
        for (String loreString : plugin.getConfig().getStringList("Eggs.Legendary.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
        }
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7&lCost: " + plugin.getConfig().getInt("PetShop.Legendary.cost")));
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getSimplePetEgg() {
        ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (short)3);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Eggs.Simple.name")));
        ArrayList<String> lore = new ArrayList<>();
        for (String loreString : plugin.getConfig().getStringList("Eggs.Simple.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
        }
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7&lCost: " + plugin.getConfig().getInt("PetShop.Simple.cost")));
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getMythicPetEgg() {
        ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (short)3);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Eggs.Mythic.name")));
        ArrayList<String> lore = new ArrayList<>();
        for (String loreString : plugin.getConfig().getStringList("Eggs.Mythic.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
        }
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7&lCost: " + plugin.getConfig().getInt("PetShop.Mythic.cost")));
        meta.setLore(lore);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public static ItemStack getPetLeash() {
        ItemStack item = new ItemStack(Material.LEASH, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cPet Leash"));
        item.setItemMeta(itemMeta);
        return item;
    }

}
