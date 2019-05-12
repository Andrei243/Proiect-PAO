package stringsToObject;

import models.companies.FirmaScanare;

import java.util.ArrayList;

public class StringToFirmaScanare implements StringToObject<FirmaScanare> {
    @Override
    public FirmaScanare proceseazaStringuri(ArrayList<String> stringuri){
        return new FirmaScanare(stringuri.get(0),Integer.parseInt(stringuri.get(1)));

    }

}
