package services;

import models.AdaugareImposibila;

public class UserService {
    private LocationService locationService;
    private ComandService comandService;
    private EventService eventService;
    private ProductionService productionService;
    private ScanService scanService;
    private ClientService clientService;

    public UserService(){
        locationService=new LocationService();
        comandService=new ComandService();
        eventService=new EventService();
        productionService=new ProductionService();
        scanService=new ScanService();
        clientService=new ClientService();
        locationService.init();
        clientService.init();
        productionService.init();
        scanService.init();
    }



    public void adauga_locatie(){
        locationService.adauga_locatie();
    }
    public void afiseaza_locatii(){
        locationService.afiseaza_locatii();
    }
    public void adauga_client(){
        clientService.adauga_client();
    }
    public void afiseaza_clienti(){
        clientService.afiseaza_clienti();
    }
    public void adauga_firma_productie(){
        productionService.adauga_firma_productie();
    }
    public void afiseaza_firme_productie(){
        productionService.afiseaza_firme_productie();
    }
    public void adauga_firma_scanare(){
        scanService.adauga_firma_scanare();
    }
    public void afiseaza_firme_scanare(){
        scanService.afiseaza_firme_scanare();
    }
    public void adauga_eveniment()throws AdaugareImposibila {
        eventService.adauga_eveniment(productionService,scanService,locationService);
    }
    public void afiseaza_evenimente(){
        eventService.afiseaza_evenimente();
    }
    public void adauga_comanda()throws AdaugareImposibila{
        comandService.adauga_comanda(clientService,eventService);
    }
    public void afiseaza_comenzi(){
        comandService.afiseaza_comanda();
    }

}
