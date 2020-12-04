package me.NotEnoughSkill.simplepets.utili;

import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.pets.Pets;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {
    Main plugin;

    Pets pets;

    public Events(Main plugin, Pets pets) {
        this.plugin = plugin;
        this.pets = pets;
    }

    @EventHandler
    public void onPetPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInHand().hasItemMeta() && player.getInventory().getItemInHand().getItemMeta().hasDisplayName() && player.getInventory().getItemInHand().getItemMeta().hasLore() && player.getInventory().getItemInHand().getItemMeta().getDisplayName().contains(ChatColor.GRAY + "(Right-Click)"))
            event.setCancelled(true);
    }

    @EventHandler
    public void onEggSpawn(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInHand() != null && player.getInventory().getItemInHand().hasItemMeta() && player.getInventory().getItemInHand().getItemMeta().hasDisplayName() && player.getInventory().getItemInHand().getItemMeta().hasLore() && (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&a&lSimple Pet Egg")) || player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&6&lLegendary Pet Egg")) || player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&d&lMythic Pet Egg"))) && event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
            event.setCancelled(true);
    }
}


