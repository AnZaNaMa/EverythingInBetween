package com.anzanama.everythinginbetween.Common.Enum;

import net.minecraft.util.IStringSerializable;

/**
 * Created by Andrew Graber on 8/16/2016.
 */
public enum EnumPlayerAugment implements IStringSerializable {
    NONE(0, "none"),
    SPEED(1, "speed"),
    OUTPUT(2, "output"),
    DURATION(3, "duration");

    private final int ID;
    private final String name;
    private static final EnumPlayerAugment[] LOOKUP = new EnumPlayerAugment[values().length];

    EnumPlayerAugment(int ID, String name){
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

    public static EnumPlayerAugment getByNumber(int num){
        if(num < 0 || num >= LOOKUP.length){
            num = 0;
        }
        return LOOKUP[num];
    }

    static
    {
        for(EnumPlayerAugment augment : values()){
            LOOKUP[augment.getID()] = augment;
        }
    }

}
