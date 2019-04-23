package services;

import modules.AdaugareImposibila;
import modules.Client;
import modules.Eveniment;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ComandService {
    private Set<Comanda> comenzi=new TreeSet<>();

    private Comanda citeste_comanda(ClientService clientService,EventService eventService)throws AdaugareImposibila {
        System.out.println("Cine cumpara acest bilet?");
        Client client=clientService.ret_client();
        System.out.println("La ce eveniment vrea?");
        Eveniment eveniment=eventService.ret_eveniment();
        Comanda comanda=new Comanda(client,eveniment);
        return comanda;

    }

    public void adauga_comanda(ClientService clientService,EventService eventService)throws AdaugareImposibila{
        Comanda comanda=citeste_comanda(clientService,eventService);
        comenzi.add(comanda);
    }
    public void afiseaza_comanda(){
        Iterator<Comanda> iterator = comenzi.iterator();
        int i=1;
        while(iterator.hasNext()){
            System.out.println(i+"."+iterator.next().toString());
        }


    }
}
