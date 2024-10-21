package internal.api.backend.utils;

import internal.api.backend.enums.FighterType;

public class FighterFactoryUtils {

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
