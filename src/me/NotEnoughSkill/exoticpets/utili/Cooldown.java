package me.NotEnoughSkill.simplepets.utili;

import me.NotEnoughSkill.simplepets.Main;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Cooldown {

    private HashMap<Player, Integer> cooldown;

    public Cooldown() {
        this.cooldown = new HashMap<Player, Integer>();
    }

    public Integer getPlayer (final Player player) {
        return this.cooldown.get(player);
    }

    public boolean containsPlayer (final Player player) {
        return this.cooldown.containsKey(player);
    }

    public void addPlayer (final Player player, final int seconds) {
        this.cooldown.put(player, seconds);
    }

    public void removePlayer (final Player player) {
        this.cooldown.remove(player);
    }

    public void runTimer (final Player player) {
        new BukkitRunnable() {
            public void run() {
                if (Cooldown.this.cooldown.get(player) > 0) {
                    Cooldown.this.cooldown.put(player, Cooldown.this.cooldown.get(player) - 1);
                }
                if (Cooldown.this.cooldown.get(player) == 0) {
                    Cooldown.this.cooldown.remove(player);
                    this.cancel();
                }
            }
        }.runTaskTimer((Plugin) JavaPlugin.getPlugin((Class) Main.class), 20L, 20L);
    }

}
