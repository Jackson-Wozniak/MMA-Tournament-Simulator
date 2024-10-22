package internal.api.backend.factory;

import internal.api.backend.enums.FighterType;
import internal.api.backend.model.Fighter;
import internal.api.backend.utils.FighterFactoryUtils;
import internal.api.backend.utils.NameUtils;

public class FighterFactory {

    public Fighter generate(){
        String name = NameUtils.generateName();
        FighterType type = FighterFactoryUtils.randomType();
        return switch(type){
            case MIXED_MARTIAL_ARTIST -> Fighter.mixedMartialArtist(name);
            case GRAPPLER -> Fighter.grappler(name);
            case STRIKER -> Fighter.striker(name);
        };
    }
}
