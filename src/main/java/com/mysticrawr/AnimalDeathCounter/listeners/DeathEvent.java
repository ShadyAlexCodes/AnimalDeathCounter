package com.mysticrawr.AnimalDeathCounter.listeners;

import com.mysticrawr.AnimalDeathCounter.AnimalDeathCounter;
import com.mysticrawr.AnimalDeathCounter.configuration.FileConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class DeathEvent implements Listener {

    private AnimalDeathCounter plugin;



    public DeathEvent(AnimalDeathCounter plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    // Count player killed entities
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Entity killer = event.getEntity().getKiller();
        if(killer instanceof Player) {
            if(entity.getType().equals(EntityType.CREEPER)) {
                Bukkit.broadcastMessage("A creeper has died!");
                increaseKill(entity.getType());
                Bukkit.broadcastMessage(String.valueOf(entity));
            }
        }
    }

    // Count explosion entities
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if(event.getEntity() instanceof Creeper) {
            Bukkit.broadcastMessage("A creeper has explored!");
        }
    }

    public void increaseKill(EntityType entity) {

        if(!plugin.getFileConfig().getConfig().contains(String.valueOf(entity))) {
            plugin.getFileConfig().getConfig().set(String.valueOf(entity)+ ".deaths", 0);
            plugin.getFileConfig().saveFile();
        } else {
            //file.getConfig().set(String.valueOf(entity), getDeaths(entity) + 1);
            plugin.getFileConfig().saveFile();
        }

    }

    private int getDeaths(Entity entity) {
        return plugin.getFileConfig().getConfig().getInt(entity.getType().toString() + ".deaths");
    }

}
