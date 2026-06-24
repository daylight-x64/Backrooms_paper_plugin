package net.daylight.backroomsPluginForPaper.Custom_blocks;

import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.NoteBlock;

public enum CustomBlockType {
    BOTTOM_WALL(Instrument.DIDGERIDOO, new Note(0)),
    MIDDLE_WALL(Instrument.DIDGERIDOO, new Note(1));

    private final Instrument instrument;
    private final Note note;

    CustomBlockType(Instrument instrument, Note note) {
        this.instrument = instrument;
        this.note = note;
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

    public Instrument getInstrument() {
        return instrument;
    }

    public Note getNote() {
        return note;
    }
}

