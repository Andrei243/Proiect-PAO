package modules;

import java.util.ArrayList;
import java.util.Date;

public class PlataSingulara implements Plata {
    private double pret;
    private Date zi;

    @Override
    public InstantaPlata getMoney(){
        ArrayList<Date>zile=new ArrayList<>();
        zile.add(zi);
        return new InstantaPlata("Plata Singulara",pret,zile);
    }



    PlataSingulara(double _pret,Date _zi){
        pret=_pret;
        zi=(Date)_zi.clone();
    }
}
