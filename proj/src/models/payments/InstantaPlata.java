package models.payments;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class InstantaPlata implements Serializable {
    private String detalii;
    private double pret;
    private ArrayList<Date> zile;


    public InstantaPlata(String detalii, double pret, ArrayList<Date> zile) {
        this.detalii = detalii;
        this.pret = pret;
        this.zile = zile;
        Collections.sort(this.zile);
    }

    public String getDetalii() {
        return detalii;
    }

    public double getPret() {
        return pret;
    }

    public ArrayList<Date> getZile() {
        return zile;
    }

    @Override
    public String toString(){
        return detalii+ " avand pretul de "+pret+" lei";

    }
}
