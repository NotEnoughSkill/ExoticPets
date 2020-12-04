package me.NotEnoughSkill.simplepets.utili;

import me.NotEnoughSkill.simplepets.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public class Leveling {
    public static HashMap<String, Integer> progress = new HashMap<>();

    Main plugin;

    public Leveling(Main plugin) {
        this.plugin = plugin;
    }

    public static int getLevel(ItemStack item) {
        String petLevel = item.getItemMeta().getLore().get(9);
        String[] arrayOfString = petLevel.split(" ");
        int i = Integer.valueOf(arrayOfString[1]).intValue();
        return i;
    }

    public static void addExp(Player player, ItemStack petItem, String string) {
        List<String> lore = petItem.getItemMeta().getLore();
        ItemMeta meta = petItem.getItemMeta();
        String expString = lore.get(10); // XP BAR
        String[] expAmount = expString.split(" ");
        int currentExp = Integer.valueOf(expAmount[1]).intValue() + 10;
        int maximumExp = Integer.valueOf(expAmount[3]).intValue();
        if (progress.get(String.valueOf(player.getName()) + expAmount[1] + string) == null)
            progress.put(String.valueOf(player.getName()) + expAmount[1] + string, Integer.valueOf(0));
        lore.set(10, ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 " + Integer.toString(currentExp) + " / " + Integer.toString(maximumExp)));
        int k = 50;
        int m = ((Integer)progress.get(String.valueOf(player.getName()) + expAmount[1] + string)).intValue();
        int n = maximumExp / 50 * 5;
        if (Integer.valueOf(expAmount[1]).intValue() % n == 0 && Integer.valueOf(expAmount[1]).intValue() != 0)
            progress.put(String.valueOf(player.getName()) + expAmount[1] + string, Integer.valueOf(((Integer)progress.get(String.valueOf(player.getName()) + expAmount[1] + string)).intValue() + 5));
        StringBuffer expBar = new StringBuffer();
        expBar.append(ChatColor.YELLOW.toString());
        int i1;
        for (i1 = 1; i1 <= m; i1++)
            expBar.append('|');
        i1 = k - m;
        expBar.append(ChatColor.RED.toString());
        for (int i2 = 1; i2 <= i1; i2++)
            expBar.append('|');
        String str2 = expBar.toString();
        lore.set(11, str2);
        if (Integer.valueOf(expAmount[1]).intValue() % n == 0 || Integer.valueOf(expAmount[1]).intValue() != 0) {
            progress.put(String.valueOf(player.getName()) + currentExp + string, progress.get(String.valueOf(player.getName()) + expAmount[1] + string));
            progress.remove(String.valueOf(player.getName()) + expAmount[1] + string);
        }
        if (currentExp >= maximumExp) {
            String str3 = petItem.getItemMeta().getLore().get(9); // XP
            String[] arrayOfString2 = str3.split(" ");
            progress.remove(String.valueOf(player.getName()) + currentExp + string);
            int i3 = Integer.valueOf(arrayOfString2[1]).intValue() + 1;
            player.sendMessage(ChatColor.GREEN + "(!) Your " + string + ChatColor.GREEN + " has leveled up!");
            lore.set(9, ChatColor.translateAlternateColorCodes('&', "&6&lLevel:&7 " + Integer.toString(i3)));
            lore.set(10, ChatColor.translateAlternateColorCodes('&', "&6&lEXP:&7 0 / " + Integer.toString(maximumExp + 200)));
            lore.set(11, ChatColor.RED + "||||||||||||||||||||||||||||||||||||||||||||||||||");
        }
        meta.setLore(lore);
        petItem.setItemMeta(meta);
    }

}
