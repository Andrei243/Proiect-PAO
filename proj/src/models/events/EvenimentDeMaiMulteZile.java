package models.events;

import models.AdaugareImposibila;
import models.Locatie;
import models.companies.FirmaProductie;
import models.companies.FirmaScanare;
import models.payments.PlataAbonament;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EvenimentDeMaiMulteZile extends Eveniment implements Serializable {

    private int nr_zile;

    public EvenimentDeMaiMulteZile(String _nume, int nr_maxim, int nr_scanere_necesare, PlataAbonament tip_plata, FirmaScanare _firmaScanare, FirmaProductie _firmaProductie, Date data_inceput, int nr_zile, Locatie _locatie) throws AdaugareImposibila {
        super(_nume,nr_maxim, nr_scanere_necesare,  tip_plata, _firmaScanare, _firmaProductie,data_inceput,_locatie);
        this.data_inceput = data_inceput;
        this.nr_zile = nr_zile;
    }

    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String date=dateFormat.format(data_inceput);
        return nume+" care se petrece pe "+date+" si tine "+nr_zile   +" zile, avand firma de productie "+firmaProductie.toString()+" si avand drept firma de scanare "+firmaScanare.toString();
    }

}
