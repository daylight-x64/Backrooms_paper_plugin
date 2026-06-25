package net.daylight.backroomsPluginForPaper.Custom_blocks;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

public enum Items {
    BOTTOM_WALL("bottom_wall", Component.text("Bottom Wall")),
    MIDDLE_WALL("middle_wall", Component.text("Middle Wall"));

    private final String pdc;
    private final ItemStack item;
    private final Component name;

    Items(String pdc, ItemStack item, Component name) {
        this.pdc = pdc;
        this.item = item;
        this.name = name;
    }

    Items(String pdc, Component name) {
        this.pdc = pdc;
        this.item = new ItemStack(Material.BAMBOO_BLOCK);
        this.name = name;
    }

    public String getPdc() {
        return pdc;
    }

    public ItemStack getItem() {
        return item;
    }

    public Component getName() {
        return name;
    }
}
