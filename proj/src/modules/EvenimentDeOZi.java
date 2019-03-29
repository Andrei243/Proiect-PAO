package modules;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EvenimentDeOZi extends Eveniment {


    public EvenimentDeOZi(String _nume,int nr_maxim, int nr_scanere_necesare, PlataSingulara tip_plata, FirmaScanare _firmaScanare,FirmaProductie _firmaProductie,Date dataEveniment)throws  AdaugareImposibila {
        super(_nume,nr_maxim, nr_scanere_necesare, tip_plata,_firmaScanare,_firmaProductie,dataEveniment);
        if(nr_maxim>1000*nr_scanere_necesare)throw new AdaugareImposibila("Nu sunt destule scannere");
    }

    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String date=dateFormat.format(data_inceput);
        return nume+" care se petrece pe "+date+" avand firma de productie "+firmaProductie.toString()+" si avand drept firma de scanare "+firmaScanare.toString();
    }


}
