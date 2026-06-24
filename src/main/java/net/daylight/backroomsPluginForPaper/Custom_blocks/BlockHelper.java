package net.daylight.backroomsPluginForPaper.Custom_blocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.NoteBlock;

public final class BlockHelper {

    public static void PlaceBlock (Block block, CustomBlockType type){
        block.setType(Material.NOTE_BLOCK);

        NoteBlock data = (NoteBlock) block.getBlockData();

        data.setInstrument(type.getInstrument());
        data.setNote(type.getNote());

        block.setBlockData(data);
    }

}
