package me.NotEnoughSkill.simplepets;

import me.NotEnoughSkill.simplepets.commands.GivePet;
import me.NotEnoughSkill.simplepets.eggs.Legendary;
import me.NotEnoughSkill.simplepets.eggs.Mythic;
import me.NotEnoughSkill.simplepets.eggs.Simple;
import me.NotEnoughSkill.simplepets.inventory.MainInventory;
import me.NotEnoughSkill.simplepets.items.PetLeash;
import me.NotEnoughSkill.simplepets.pets.*;
import me.NotEnoughSkill.simplepets.utili.Cooldown;
import me.NotEnoughSkill.simplepets.utili.Events;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements Listener, CommandExecutor {

    public static Main instance;
    Pets pets;


    public Cooldown cooldown;
    public static Economy eco = null;
    Main plugin;

        PluginManager pm = this.getServer().getPluginManager();

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("**************************");
        Bukkit.getConsoleSender().sendMessage("*******Exotic Pets********");
        Bukkit.getConsoleSender().sendMessage("*********Made By:*********");
        Bukkit.getConsoleSender().sendMessage("******NotEnoughSkill******");
        Bukkit.getConsoleSender().sendMessage("**************************");

        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        this.cooldown = new Cooldown();
        this.getCommand("Pets").setExecutor((CommandExecutor)new GivePet(this, this.pets));
        this.getCommand("Petshelp").setExecutor((CommandExecutor)new GivePet(this, this.pets));
        this.getCommand("Petshop").setExecutor((CommandExecutor)new MainInventory(this, this.pets));
        this.getCommand("Petlist").setExecutor((CommandExecutor)new MainInventory(this, this.pets));
        if (!this.setupEconomy()) {
            this.getLogger().severe(String.format("Disabled due to no Vault found!", this.getDescription().getName()));
            this.getServer().getPluginManager().disablePlugin((Plugin)this);
        }
        this.pm.registerEvents((Listener)new Cow(this), (Plugin)this);
        this.pm.registerEvents((Listener)new IronGolem(this), (Plugin)this);
        this.pm.registerEvents((Listener)new Money(this), (Plugin)this);
        this.pm.registerEvents((Listener)new Strength(this), (Plugin)this);
        this.pm.registerEvents((Listener)new Value(this), (Plugin)this);
        this.pm.registerEvents((Listener)new Potion(this), (Plugin)this);
        this.pm.registerEvents((Listener)new Zombie(this), (Plugin)this);
        this.pm.registerEvents((Listener)new Elsa(this), (Plugin)this);
        this.pm.registerEvents((Listener)new Sonic(this), (Plugin)this);
        this.pm.registerEvents((Listener)new Simple(this), (Plugin)this);
        this.pm.registerEvents((Listener)new Legendary(this), (Plugin)this);
        this.pm.registerEvents((Listener)new Mythic(this), (Plugin)this);
        this.pm.registerEvents((Listener)new MainInventory(this, this.pets), (Plugin)this);
        this.pm.registerEvents((Listener)new Events(this, this.pets), (Plugin)this);
        this.pm.registerEvents((Listener)new PetLeash(), (Plugin)this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, (BukkitRunnable)new Leech(this), 60L, 60L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, (BukkitRunnable)new Miner(this), 60L, 60L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, (BukkitRunnable)new Spider(this), 60L, 60L);

        instance = this;
        this.pets = new Pets(this);

    }

    private boolean setupEconomy() {
        if (this.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        final RegisteredServiceProvider<Economy> rps = (RegisteredServiceProvider<Economy>)this.getServer().getServicesManager().getRegistration((Class)Economy.class);
        if (rps == null) {
            return false;
        }
        Main.eco = (Economy)rps.getProvider();
        return Main.eco != null;
    }

    static {
        Main.eco = null;
    }

    public void sendMsg (final Player player, final String string) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
    }

    @Override
    public void onDisable() {

    }

}
