package net.daylight.backroomsPluginForPaper;

import net.daylight.backroomsPluginForPaper.Custom_blocks.ListenerForBlocks;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("Hello world!");
        getServer().getPluginManager().registerEvents(new ListenerForBlocks(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return getPlugin(Main.class);
    }
}
