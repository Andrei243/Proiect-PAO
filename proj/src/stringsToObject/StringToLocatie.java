package stringsToObject;

import models.Locatie;

import java.util.ArrayList;

public class StringToLocatie implements StringToObject<Locatie> {
    @Override
    public Locatie proceseazaStringuri(ArrayList<String> stringuri){
        return new Locatie(stringuri.get(0),stringuri.get(1));

    }

}
