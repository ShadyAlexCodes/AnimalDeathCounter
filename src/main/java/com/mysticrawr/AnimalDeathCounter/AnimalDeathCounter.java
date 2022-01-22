package com.mysticrawr.AnimalDeathCounter;

import com.mysticrawr.AnimalDeathCounter.listeners.DeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AnimalDeathCounter extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().info("The Animal Death Counter has been enabled!");
        new DeathEvent(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("The Animal Death Counter has been disabled!");
    }

}
