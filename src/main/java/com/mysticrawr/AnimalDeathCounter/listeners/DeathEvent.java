package com.mysticrawr.AnimalDeathCounter.listeners;

import com.mysticrawr.AnimalDeathCounter.AnimalDeathCounter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathEvent implements Listener {

    private AnimalDeathCounter plugin;

    public DeathEvent(AnimalDeathCounter plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void countDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Entity killer = event.getEntity().getKiller();
        if(killer instanceof Player) {
            if(entity.getType().equals(EntityType.CREEPER)) {
                Bukkit.broadcastMessage("A creeper has died!");
            }
        }
    }

}
