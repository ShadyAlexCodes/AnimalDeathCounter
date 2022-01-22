package com.mysticrawr.AnimalDeathCounter;

import com.mysticrawr.AnimalDeathCounter.configuration.FileConfiguration;
import com.mysticrawr.AnimalDeathCounter.listeners.DeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class AnimalDeathCounter extends JavaPlugin {

    private FileConfiguration file;

    @Override
    public void onEnable() {
        getLogger().info("The Animal Death Counter has been enabled!");
        new DeathEvent(this);
        file = new FileConfiguration(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("The Animal Death Counter has been disabled!");
    }

    public FileConfiguration getFileConfig() {
        return file;
    }

}
