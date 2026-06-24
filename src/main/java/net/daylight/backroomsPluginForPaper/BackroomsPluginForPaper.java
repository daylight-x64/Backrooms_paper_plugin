package net.daylight.backroomsPluginForPaper;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BackroomsPluginForPaper extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("Hello world!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
