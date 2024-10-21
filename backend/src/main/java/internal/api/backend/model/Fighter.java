package internal.api.backend.model;

import internal.api.backend.enums.FighterType;
import internal.api.backend.utils.FighterFactoryUtils;
import lombok.Getter;

@Getter
public class Fighter {

    public final String name;
    public final int strikingAbility;
    public final int strikingDefense;
    public final int grapplingAbility;
    public final int grapplingDefense;
    public final int totalAbility;

    protected Fighter(String name, FighterType type){
        this.name = name;
        this.strikingAbility = FighterFactoryUtils.randomStriking(type);
        this.strikingDefense = FighterFactoryUtils.randomStriking(type);
        this.grapplingAbility = FighterFactoryUtils.randomGrappling(type);
        this.grapplingDefense = FighterFactoryUtils.randomGrappling(type);
        this.totalAbility = average();
    }

    private int average(){
        int sum = grapplingAbility + grapplingDefense + strikingDefense + strikingAbility;
        return sum / 4;
    }

    public Fighter grappler(String name){
        return new Fighter(name, FighterType.GRAPPLER);
    }

    public Fighter striker(String name){
        return new Fighter(name, FighterType.STRIKER);
    }

    public Fighter mixedMartialArtist(String name){
        return new Fighter(name, FighterType.MIXED_MARTIAL_ARTIST);
    }
}
