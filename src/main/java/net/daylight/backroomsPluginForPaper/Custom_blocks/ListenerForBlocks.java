package net.daylight.backroomsPluginForPaper.Custom_blocks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class ListenerForBlocks implements Listener {



    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!(event.getBlockPlaced().getType() == Material.DIAMOND_BLOCK)) {return;}

        int type = 0;

        switch (type) {
            case 0 -> {
                BlockHelper.PlaceBlock(event.getBlockPlaced(), CustomBlockType.MIDDLE_WALL);
                Bukkit.getConsoleSender().sendMessage("Custom plock placed with tone "+ CustomBlockType.MIDDLE_WALL.getNote());
            }
        }
    }

    @EventHandler
    public void onBlockUpdate(BlockPhysicsEvent event) {
        if (CustomBlockType.isCustomBlockType(event.getBlock())) {
            event.setCancelled(true);
        }
    }
}
