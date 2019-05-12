package services;

import models.AdaugareImposibila;
import stringsToObject.*;


public class AppService {
    private LocationService locationService;
    private ComandService comandService;
    private EventService eventService;
    private ProductionService productionService;
    private ScanService scanService;
    private ClientService clientService;

    public AppService(){
        locationService=new LocationService();
        comandService=new ComandService();
        eventService=new EventService();
        productionService=new ProductionService();
        scanService=new ScanService();
        clientService=new ClientService();
        StringToClient proc1=new StringToClient();
        clientService.init("clienti",proc1);
        StringToLocatie proc2 = new StringToLocatie();
        locationService.init("locatii",proc2);
        StringtoFirmaProductie proc3=new StringtoFirmaProductie();
        productionService.init("firmeProductie",proc3);
        StringToFirmaScanare proc4=new StringToFirmaScanare();
        scanService.init("firmeScanare",proc4);
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
    public void inchidere(){
//        clientService.inchidere();
//        locationService.inchidere();
//        productionService.inchidere();
//        scanService.inchidere();

    }

}
