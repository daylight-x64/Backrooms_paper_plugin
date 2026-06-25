package net.daylight.backroomsPluginForPaper.Custom_blocks;

import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.NoteBlock;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public enum CustomBlockType {
    BOTTOM_WALL(Instrument.DIDGERIDOO, new Note(0), "Wall bottom"),
    MIDDLE_WALL(Instrument.DIDGERIDOO, new Note(1), "Wall middle"),;

    private final Instrument instrument;
    private final Note note;
    private final String displayName;

    CustomBlockType(Instrument instrument, Note note, String displayName) {
        this.instrument = instrument;
        this.note = note;
        this.displayName = displayName;

    }

    public static boolean isCustomBlockType(Block block) {
        if (!(block.getType() == Material.NOTE_BLOCK)) {return false;}
        NoteBlock data = (NoteBlock) block.getBlockData();
        if (data.getInstrument() != Instrument.DIDGERIDOO) {return false;}


        for (CustomBlockType type : CustomBlockType.values()) {
            if (type.getNote().equals(data.getNote())) {return true;}
        }

        return false;
    }

    public ItemStack createItem(JavaPlugin plugin) {
        ItemStack item = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName("§e" + this.displayName); // Yellow name

            // Tag it with a persistent key so we know exactly which custom block this is
            NamespacedKey key = new NamespacedKey(plugin, "custom_block_type");
            meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, this.name());

            item.setItemMeta(meta);
        }
        return item;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public Note getNote() {
        return note;
    }
}

