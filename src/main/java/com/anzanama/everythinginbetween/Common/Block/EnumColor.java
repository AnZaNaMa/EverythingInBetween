package com.anzanama.everythinginbetween.Common.Block;

import net.minecraft.util.IStringSerializable;

/**
 * Created by Andrew Graber on 8/12/2016.
 */
public enum EnumColor implements IStringSerializable {
    DEFAULT(0, "default"),
    WHITE(1, "white"),
    BLACK(2, "black"),
    BLUE(3, "blue"),
    GREEN(4, "green"),
    ORANGE(5, "orange"),
    YELLOW(6, "yellow"),
    TEAL(7, "teal"),
    LIGHTBLUE(8, "lightblue"),
    LIGHTGREEN(9, "lightgreen"),
    LIGHTORANGE(10, "lightorange"),
    LIGHTYELLOW(11, "lightyellow"),
    LIGHTTEAL(12, "lightteal"),
    LIGHTPINK(13, "lightpink"),
    LIGHTVIOLET(14, "lightviolet"),
    LIGHTRED(15, "lightred");

    private final int ID;
    private final String name;
    private static final EnumColor[] META_LOOKUP = new EnumColor[values().length];

    EnumColor(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString(){
        return getName();
    }

    public static EnumColor byMetadata(int meta){
        if(meta < 0 || meta >= META_LOOKUP.length){
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    static
    {
        for(EnumColor color : values()){
            META_LOOKUP[color.getID()] = color;
        }
    }

}