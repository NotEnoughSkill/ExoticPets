package me.NotEnoughSkill.simplepets.commands;

import me.NotEnoughSkill.simplepets.Main;
import me.NotEnoughSkill.simplepets.pets.Pets;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class GivePet implements Listener, CommandExecutor {

    Main main;
    Pets pets;

    public GivePet (Main main, Pets pets) {
        this.main = main;
        this.pets = pets;
    }

    public void Give(Main instance) {
        this.main = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        // ********************************
        // ************* PETS *************
        // ********************************

        if (p.hasPermission("exoticpets.pets") || p.hasPermission("exoticpets.*")) {
            if (cmd.getLabel().equalsIgnoreCase("pets")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Incorrect-Usage")));
                    return false;
                }
                if (args.length == 1)
                    if (args[0].equalsIgnoreCase("reload")) {
                        if (p.hasPermission("exoticpets.reload") || p.hasPermission("exoticpets.*")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Reload-Message")));
                            this.main.reloadConfig();
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Invalid-Permission")));
                        }
                    } else if (args[0].equalsIgnoreCase("give")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Incorrect-Usage")));
                    }
                if (args.length == 2 &&
                        args[0].equalsIgnoreCase("give")) {
                    Player target = Bukkit.getPlayerExact(args[1]);
                    if (target != null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Incorrect-Usage")));
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Offline-Player")));
                    }
                }
                if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
                    if (p.hasPermission("exoticpets.give") || p.hasPermission("exoticpets.*")) {
                        Player target = Bukkit.getPlayerExact(args[1]);
                        if (target != null) {
                            if (args.length == 3 && args[2].equalsIgnoreCase("Cow")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getCow() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved a Cow Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("IronGolem")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getIronGolem() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved an Iron Golem Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Money")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getMoney() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved a Money Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Berserker")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getBerserker() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved an Berserker Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Value")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getValue() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved a Value Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Leech")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getLeech() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved a Leech Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Potion")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getPotion() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved a Potion Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Zombie")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getZombie() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved a Zombie Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Miner")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getMiner() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved a Miner Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Spider")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getSpider() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved a Spider Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Elsa")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getElsa() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved a Elsa Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Sonic")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getSonic() });
                                sender.sendMessage(" ");
                                target.sendMessage(ChatColor.GREEN + "You have recieved a Sonic Pet");
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Legendary")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getLegendaryPetEgg() });
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Simple")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getSimplePetEgg() });
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Mythic")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getMythicPetEgg() });
                            } else if (args.length == 3 && args[2].equalsIgnoreCase("Leash")) {
                                target.getInventory().addItem(new ItemStack[] { Pets.getPetLeash() });
                            }
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Offline-Player")));
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Invalid-Permission")));
                    }
                }
            }
            if (cmd.getName().equalsIgnoreCase("petshelp")) {
                if (p.hasPermission("exoticpets.help") || p.hasPermission("exoticpets.*")) {
                    for (String helpString : main.getConfig().getStringList ("Messages.Help-Message")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', helpString));
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&l* &eDeveloped by &7NotEnoughSkill#2866"));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Invalid-Permission")));
                }
            }
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("Messages.Invalid-Permission")));
        }


        return false;
    }

    private void addItem(Player player, ItemStack item) {
        player.getInventory().addItem(new ItemStack[] { item });
        player.updateInventory();
    }
}