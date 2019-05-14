package services;

import models.AdaugareImposibila;
import stringsToObject.*;

import java.util.ArrayList;


public class AppService {
    private static AppService instance=null;
    private LocationService locationService;
    private ComandService comandService;
    private EventService eventService;
    private ProductionService productionService;
    private ScanService scanService;
    private ClientService clientService;

    public static AppService getInstance() {
        if(instance==null){
            instance=new AppService();
        }
        return instance;
    }

    private AppService(){
        locationService=new LocationService();
        comandService=new ComandService();
        eventService=new EventService();
        productionService=new ProductionService();
        scanService=new ScanService();
        clientService=new ClientService();
        StringToClient proc1=new StringToClient();
        clientService.init("Clienti",proc1);
        StringToLocatie proc2 = new StringToLocatie();
        locationService.init("Locatii",proc2);
        StringtoFirmaProductie proc3=new StringtoFirmaProductie();
        productionService.init("FirmeProductie",proc3);
        StringToFirmaScanare proc4=new StringToFirmaScanare();
        scanService.init("FirmeScanare",proc4);
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
    public void sterge_locatie(){locationService.stergereLocatie();}
    public void sterge_client(){clientService.stergeClient();}
    public  void sterge_firma_scanare(){scanService.stergeFirmaScanare();}
    public void sterge_firma_productie(){productionService.stergeFirmaProductie();}

    public void sterge_locatie(int index){locationService.stergereLocatie(index);}
    public void sterge_client(int index){clientService.stergeClient(index);}
    public  void sterge_firma_scanare(int index){scanService.stergeFirmaScanare(index);}
    public void sterge_firma_productie(int index){productionService.stergeFirmaProductie(index);}

    public void schimba_locatie(int x,String oras,String tara){locationService.editeaza_locatie(x,oras,tara);}
    public void schimba_client(int x, String nume){clientService.editeaza_client(x,nume);}
    public void schimba_firma_productie(int x,String nume){productionService.schimba_firma_productie(x,nume);}
    public void schimba_firma_scanare(int x,String nume,int nrScanare){scanService.schimba_firma_scanare(x,nume,nrScanare);}

    public ArrayList<String> getLocationsStrings(){return  locationService.getStrings();}
    public ArrayList<String>getClientsStrings(){return clientService.getStrings();}
    public ArrayList<String>getProductionStrings(){return productionService.getStrings();}
    public ArrayList<String>getScanStrings(){return scanService.getStrings();}

    public void adauga_locatie(String tara,String oras){locationService.adauga_locatie(tara,oras);}
    public void adauga_client(String nume){clientService.adauga_client(nume);}
    public void adauga_firma_productie(String nume){productionService.adauga_firma_productie(nume);}
    public void adauga_firma_scanare(String nume,int nrScanere){scanService.adauga_firma_scanare(nume,nrScanere);}

}
