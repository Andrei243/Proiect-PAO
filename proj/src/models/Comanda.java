package models;

import models.events.Eveniment;
import models.payments.InstantaPlata;

import java.io.Serializable;

public class Comanda implements Comparable<Comanda>, Serializable {
    static int nrComenzi=0;
    private int nr_comanda;
    private Client client;
    private Eveniment eveniment;
    private InstantaPlata instantaPlata;

    @Override
    public int compareTo(Comanda o) {
        return nr_comanda-o.nr_comanda;
    }

    @Override
    public String toString(){
        return "Comanda nr "+nr_comanda+"achizitionat de "+client.getNume()    +":\n"+eveniment.toString()+"\n"+instantaPlata.toString();

    }

    @Override
    public int hashCode(){
        return nr_comanda;
    }

    public Comanda(Client _client,Eveniment event)throws AdaugareImposibila {
        client=_client;
        eveniment=event;

        instantaPlata=event.adauga_bilet();
        nrComenzi++;
        nr_comanda=nrComenzi;
    }

    public Comanda(Client _client,Eveniment event,int _nr_comanda)throws AdaugareImposibila{
        client=_client;
        eveniment=event;
        nr_comanda=_nr_comanda;
        instantaPlata=event.adauga_bilet();
        nrComenzi=Math.max(nr_comanda+1,nrComenzi+1);

    }
}
