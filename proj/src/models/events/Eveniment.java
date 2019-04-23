package models.events;

import models.*;
import models.companies.FirmaProductie;
import models.companies.FirmaScanare;
import models.payments.InstantaPlata;
import models.payments.Plata;

import java.util.Date;

abstract public class Eveniment implements Comparable<Eveniment>{
    protected String nume;
    protected int nr_maxim;
    protected int nr_scanere_necesare;
    protected int nr_instante=0;
    protected Date data_inceput;
    protected FirmaScanare firmaScanare;
    protected FirmaProductie firmaProductie;

    protected Plata tip_plata;

    public Eveniment(String _nume,int nr_maxim, int nr_scanere_necesare, Plata tip_plata,FirmaScanare _firmaScanare,FirmaProductie _firmaProductie,Date _dataInceput)throws AdaugareImposibila {
        nume=_nume;
        this.nr_maxim = nr_maxim;
        this.nr_scanere_necesare = nr_scanere_necesare;
        this.tip_plata = tip_plata;
        firmaScanare=_firmaScanare;
        firmaProductie=_firmaProductie;
        data_inceput=_dataInceput;
        if(nr_scanere_necesare>firmaScanare.getNumar_scanere())throw new AdaugareImposibila("Nu sunt destule scannere");
    }


    public InstantaPlata adauga_bilet() throws AdaugareImposibila{
        if(nr_instante==nr_maxim){
            throw new AdaugareImposibila("Nu pot sa fie mai multi participanti");
        }
        nr_instante++;
        return tip_plata.getMoney();

    }

    @Override
    public int compareTo(Eveniment o) {
        return data_inceput.compareTo(o.data_inceput);
    }

    abstract public String toString();
}
