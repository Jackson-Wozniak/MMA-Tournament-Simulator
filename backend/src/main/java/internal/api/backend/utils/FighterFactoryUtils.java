package internal.api.backend.utils;

import internal.api.backend.enums.FighterType;

import java.util.Random;

public class FighterFactoryUtils {

    private static final Random random = new Random();

    public static FighterType randomType(){
        int rand = random.nextInt(10) + 1;
        if(rand <= 6) return FighterType.MIXED_MARTIAL_ARTIST;
        if(rand <= 8) return FighterType.STRIKER;
        return FighterType.GRAPPLER;
    }

    public static int randomStriking(FighterType type){
        //create a random distribution of grades 1-100
        //incorporate the FighterType to make sure strikers have higher striking on average
        //Mixed Martial Artists are favored slightly, grapplers have lower striking
        return 1;
    }

    public static int randomGrappling(FighterType type){
        //create a random distribution of grades 1-100
        //incorporate the FighterType to make sure grapplers have higher grappling on average
        //Mixed Martial Artists are favored slightly, strikers have lower striking
        return 1;
    }
}
