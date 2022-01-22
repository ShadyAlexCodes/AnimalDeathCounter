package com.mysticrawr.AnimalDeathCounter.configuration;

import com.mysticrawr.AnimalDeathCounter.AnimalDeathCounter;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

public class FileConfiguration {

    private final AnimalDeathCounter plugin;

    private final File file;
    private final YamlConfiguration config;


    public FileConfiguration(AnimalDeathCounter plugin) {
        this.plugin = plugin;

        file = new File(plugin.getDataFolder(), "players.yml");
        config = new YamlConfiguration().loadConfiguration(file);

        createFile();
    }

    private void createFile(){
        if(!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }
    }

    public void saveFile() {
        try {
            config.save(file);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfig() {
        return config;
    }
}
