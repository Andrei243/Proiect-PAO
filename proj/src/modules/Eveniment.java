package modules;

abstract public class Eveniment {
    protected int nr_maxim;
    protected int nr_scanere_necesare;
    protected int nr_instante;
    private FirmaScanare firmaScanare;
    private FirmaProductie firmaProductie;

    protected Plata tip_plata;

    public Eveniment(int nr_maxim, int nr_scanere_necesare, int nr_instante, Plata tip_plata,FirmaScanare _firmaScanare,FirmaProductie _firmaProductie)throws  AdaugareImposibila {
        this.nr_maxim = nr_maxim;
        this.nr_scanere_necesare = nr_scanere_necesare;
        this.nr_instante = nr_instante;
        this.tip_plata = tip_plata;
        firmaScanare=_firmaScanare;
        firmaProductie=_firmaProductie;
        if(nr_scanere_necesare>firmaScanare.getNumar_scanere())throw new AdaugareImposibila();
    }

    abstract public InstantaPlata adauga_bilet() throws AdaugareImposibila;

}
