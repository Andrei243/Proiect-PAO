package modules;

import java.util.Date;

public class EvenimentDeMaiMulteZile extends Eveniment {
    private Date data_inceput;
    private int nr_zile;

    public EvenimentDeMaiMulteZile(int nr_maxim, int nr_scanere_necesare, int nr_instante, Plata tip_plata, FirmaScanare _firmaScanare, FirmaProductie _firmaProductie, Date data_inceput, int nr_zile) throws AdaugareImposibila {
        super(nr_maxim, nr_scanere_necesare, nr_instante, tip_plata, _firmaScanare, _firmaProductie);
        this.data_inceput = data_inceput;
        this.nr_zile = nr_zile;
    }

    public InstantaPlata adauga_bilet() throws AdaugareImposibila{
        if(nr_instante==nr_maxim){
            throw new AdaugareImposibila();
        }
        nr_instante++;
        return tip_plata.getMoney();

    }
}
