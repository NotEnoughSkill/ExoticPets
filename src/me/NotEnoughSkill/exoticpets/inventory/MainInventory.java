package me.NotEnoughSkill.simplepets.inventory;

import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.pets.Pets;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class MainInventory implements Listener, CommandExecutor {
    Main main;

    Pets pets;

    public MainInventory (Main main, Pets pets) {
        this.main = main;
        this.pets = pets;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        if (!(sender instanceof  Player)) {
            sender.sendMessage("You must be a player to use this command!");
        }

        if (cmd.getName().equalsIgnoreCase("petshop")) {
            if (p.hasPermission("exoticpets.shop") || p.hasPermission("exoticpets.*")) {
                Player player = (Player)sender;
                Inventory petShop = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', "&ePet Shop"));
                ItemStack blank = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
                ItemMeta blankMeta = blank.getItemMeta();
                blankMeta.setDisplayName(" ");
                blank.setItemMeta(blankMeta);

                petShop.setItem(0, blank);
                petShop.setItem(1, blank);
                petShop.setItem(2, Pets.getSimplePetEgg());
                petShop.setItem(3, blank);
                petShop.setItem(4, Pets.getLegendaryPetEgg());
                petShop.setItem(5, blank);
                petShop.setItem(6, Pets.getMythicPetEgg());
                petShop.setItem(7, blank);
                petShop.setItem(8, blank);
                player.openInventory(petShop);
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Invalid-Permission")));
            }
        }
        if (cmd.getName().equalsIgnoreCase("petlist")) {
            if (p.hasPermission("exoticpets.list") || p.hasPermission("exoticpets.*")) {
                Player player = (Player)sender;
                Inventory petList = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&ePet List"));
                ItemStack blank = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
                ItemMeta blankMeta = blank.getItemMeta();
                blankMeta.setDisplayName(" ");
                blank.setItemMeta(blankMeta);

                petList.setItem(0, blank);
                petList.setItem(1, blank);
                petList.setItem(2, blank);
                petList.setItem(3, blank);
                petList.setItem(4, blank);
                petList.setItem(5, blank);
                petList.setItem(6, blank);
                petList.setItem(7, blank);
                petList.setItem(8, blank);
                petList.setItem(9, blank);
                petList.setItem(10, Pets.getPotion());
                petList.setItem(11, Pets.getCow());
                petList.setItem(12, Pets.getBerserker());
                petList.setItem(13, Pets.getIronGolem());
                petList.setItem(14, Pets.getValue());
                petList.setItem(15, Pets.getLeech());
                petList.setItem(16, Pets.getMoney());
                petList.setItem(17, blank);
                petList.setItem(18, blank);
                petList.setItem(19, blank);
                petList.setItem(20, Pets.getElsa());
                petList.setItem(21, Pets.getZombie());
                petList.setItem(22, Pets.getMiner());
                petList.setItem(23, Pets.getSpider());
                petList.setItem(24, Pets.getSonic());
                petList.setItem(25, blank);
                petList.setItem(26, blank);
                petList.setItem(27, blank);
                petList.setItem(28, blank);
                petList.setItem(29, blank);
                petList.setItem(30, blank);
                petList.setItem(31, blank);
                petList.setItem(32, blank);
                petList.setItem(33, blank);
                petList.setItem(34, blank);
                petList.setItem(35, blank);
                player.openInventory(petList);
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Invalid-Permission")));
            }
        }
        return false;
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        Inventory petShop = event.getInventory();
        ItemStack itemClicked = event.getCurrentItem();
        if (petShop.getName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&ePet Shop"))) {
            event.setCancelled(true);
            if (itemClicked.hasItemMeta() && itemClicked.getItemMeta().hasDisplayName() && itemClicked.getItemMeta().hasLore() && itemClicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&6&lLegendary Pet Egg"))) {
                if (player.getLevel() >= this.main.getConfig().getInt("PetShop.Legendary.cost")) {
                    if (player.getInventory().firstEmpty() < 0) {
                        player.sendMessage(ChatColor.RED + "Your inventory is full!");
                        return;
                    }
                    player.setLevel(player.getLevel() - this.main.getConfig().getInt("PetShop.Legendary.cost"));
                    player.getInventory().addItem(new ItemStack[] { Pets.getLegendaryPetEgg() });
                }
            } else if (itemClicked.hasItemMeta() && itemClicked.getItemMeta().hasDisplayName() && itemClicked.getItemMeta().hasLore() && itemClicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&7&lSimple Pet Egg"))) {
                if (player.getLevel() >= this.main.getConfig().getInt("PetShop.Simple.cost")) {
                    if (player.getInventory().firstEmpty() < 0) {
                        player.sendMessage(ChatColor.RED + "Your inventory is full!");
                        return;
                    }
                    player.setLevel(player.getLevel() - this.main.getConfig().getInt("PetShop.Simple.cost"));
                    player.getInventory().addItem(new ItemStack[] { Pets.getSimplePetEgg() });
                }
            } else if (itemClicked.hasItemMeta() && itemClicked.getItemMeta().hasDisplayName() && itemClicked.getItemMeta().hasLore() && itemClicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&d&lMythic Pet Egg"))) {
                if (player.getLevel() >= this.main.getConfig().getInt("PetShop.Mythic.cost")) {
                    if (player.getInventory().firstEmpty() < 0) {
                        player.sendMessage(ChatColor.RED + "Your inventory is full!");
                        return;
                    }
                    player.setLevel(player.getLevel() - this.main.getConfig().getInt("PetShop.Mythic.cost"));
                    player.getInventory().addItem(new ItemStack[] { Pets.getMythicPetEgg() });
                }
            }
        }
        if (petShop.getName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&ePet List"))) {
            event.setCancelled(true);
        }
    }
}
