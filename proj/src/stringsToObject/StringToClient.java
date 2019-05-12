package stringsToObject;

import models.Client;

import java.util.ArrayList;

public class StringToClient implements StringToObject<Client> {
    @Override
    public Client proceseazaStringuri(ArrayList<String> stringuri){
        return new Client(stringuri.get(0));
    }
}
