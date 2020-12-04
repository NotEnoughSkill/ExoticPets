package me.NotEnoughSkill.simplepets.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PetLeash implements Listener {
    public HashMap<String, List<ItemStack>> pLeashedItems = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        ItemStack hand = event.getCursor();
        if (item == null || hand == null) {
            return;
        }
        Player player = (Player)event.getWhoClicked();
        if (hand.hasItemMeta() && hand.getItemMeta().hasDisplayName() && hand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&cPet Leash"))) {
            event.setCancelled(true);
            if (isLeashed(item)) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "This pet is already leashed!"));
                return;
            }
            leash(item);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "Leash Applied!"));
            if (hand.getAmount() > 1) {
                hand.setAmount(hand.getAmount() - 1);
            } else {
                player.setItemOnCursor(new ItemStack(Material.AIR));
            }
        }
    }

    @EventHandler
    private void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        ArrayList<ItemStack> arrayList = new ArrayList<>();
        for (ItemStack itemStack : new ArrayList<>(event.getDrops())) {
            if (isLeashed(itemStack)) {
                unleash(itemStack);
            }
            arrayList.add(itemStack);
            event.getDrops().remove(itemStack);
        }
        storeItemsDeath(player, arrayList);
    }

    @EventHandler
    private void onPlayerRespawnHighest (PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        ArrayList arrayList = new ArrayList();
        List<ItemStack> list = retrieveItemsDeath(player);
        if (list != null) {
            for (ItemStack itemStack : list) {
                player.getInventory().addItem(new ItemStack[] { itemStack });
            }
            this.pLeashedItems.remove(player.getName());
        }
    }

    public boolean isLeashed (ItemStack item) {
        if (item == null || !item.hasItemMeta() ||!item.getItemMeta().hasLore()) {
            return false;
        }
        for (String str : item.getItemMeta().getLore()) {
            if (str.contains(ChatColor.translateAlternateColorCodes('&', "&6&lLeashed"))) {
                return true;
            }
        }
        return false;
    }

    public void leash (ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        ArrayList<String> arrayList = new ArrayList<>();
        if (itemMeta.hasLore()) {
            for (String str : itemMeta.getLore()) {
                arrayList.add(str);
            }
        }
        arrayList.add(ChatColor.translateAlternateColorCodes('&', "&6&lLeashed"));
        itemMeta.setLore(arrayList);
        item.setItemMeta(itemMeta);
    }

    public boolean unleash (ItemStack item) {
        if (isLeashed(item)) {
            ItemMeta itemMeta = item.getItemMeta();
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : itemMeta.getLore()) {
                if (!str.contains(ChatColor.translateAlternateColorCodes('&', "&6&lLeashed"))) {
                    arrayList.add(str);
                }
            }
            itemMeta.setLore(arrayList);
            item.setItemMeta(itemMeta);
            return true;
        }
        return false;
    }

    public void storeItemsDeath (Player player, List<ItemStack> list) {
        String str = player.getName();
        if (this.pLeashedItems.containsKey(str)) {
            this.pLeashedItems.put(str, null);
        }
        this.pLeashedItems.put(str, list);
    }

    public List<ItemStack> retrieveItemsDeath (Player player) {
        String str = player.getName();
        if (this.pLeashedItems.containsKey(str)) {
            return this.pLeashedItems.get(str);
        }
        return null;
    }
}
