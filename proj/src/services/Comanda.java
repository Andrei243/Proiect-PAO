package services;

import modules.AdaugareImposibila;
import modules.Client;
import modules.Eveniment;
import modules.InstantaPlata;

public class Comanda implements Comparable<Comanda> {
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

    public Comanda(Client _client,Eveniment event)throws AdaugareImposibila {
        client=_client;
        eveniment=event;

        instantaPlata=event.adauga_bilet();
        nrComenzi++;
        nr_comanda=nrComenzi;
    }
}
