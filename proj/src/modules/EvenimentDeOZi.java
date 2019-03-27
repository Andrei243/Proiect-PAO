package modules;

import java.util.Date;

public class EvenimentDeOZi extends Eveniment {
    private Date dataEveniment;

    public EvenimentDeOZi(int nr_maxim, int nr_scanere_necesare, int nr_instante, Plata tip_plata, Date dataEveniment,FirmaScanare _firmaScanare,FirmaProductie _firmaProductie)throws  AdaugareImposibila {
        super(nr_maxim, nr_scanere_necesare, nr_instante, tip_plata,_firmaScanare,_firmaProductie);
        this.dataEveniment = dataEveniment;
        if(nr_maxim>1000*nr_scanere_necesare)throw new AdaugareImposibila();
    }


    public InstantaPlata adauga_bilet() throws AdaugareImposibila{
        if(nr_instante==nr_maxim){
            throw new AdaugareImposibila();
        }
        nr_instante++;
        return tip_plata.getMoney();

    }
}
