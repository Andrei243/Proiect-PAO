package modules;

import java.util.Date;

public class EvenimentDeOZi extends Eveniment {


    public EvenimentDeOZi(int nr_maxim, int nr_scanere_necesare, PlataSingulara tip_plata, FirmaScanare _firmaScanare,FirmaProductie _firmaProductie,Date dataEveniment)throws  AdaugareImposibila {
        super(nr_maxim, nr_scanere_necesare, tip_plata,_firmaScanare,_firmaProductie,dataEveniment);
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
