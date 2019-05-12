package stringsToObject;

import models.companies.FirmaProductie;

import java.util.ArrayList;

public class StringtoFirmaProductie implements StringToObject<FirmaProductie> {
    @Override
    public FirmaProductie proceseazaStringuri(ArrayList<String> stringuri){
        return new FirmaProductie(stringuri.get(0));
    }

}
