package modules;

import java.util.Date;

abstract public class Eveniment implements Comparable<Eveniment>{
    protected int nr_maxim;
    protected int nr_scanere_necesare;
    protected int nr_instante=0;
    protected Date data_inceput;
    private FirmaScanare firmaScanare;
    private FirmaProductie firmaProductie;

    protected Plata tip_plata;

    public Eveniment(int nr_maxim, int nr_scanere_necesare, Plata tip_plata,FirmaScanare _firmaScanare,FirmaProductie _firmaProductie,Date _dataInceput)throws  AdaugareImposibila {
        this.nr_maxim = nr_maxim;
        this.nr_scanere_necesare = nr_scanere_necesare;
        this.tip_plata = tip_plata;
        firmaScanare=_firmaScanare;
        firmaProductie=_firmaProductie;
        data_inceput=_dataInceput;
        if(nr_scanere_necesare>firmaScanare.getNumar_scanere())throw new AdaugareImposibila();
    }

    abstract public InstantaPlata adauga_bilet() throws AdaugareImposibila;

    @Override
    public int compareTo(Eveniment o) {
        return data_inceput.compareTo(o.data_inceput);
    }
}
