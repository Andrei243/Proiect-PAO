package modules;

import java.util.ArrayList;
import java.util.Date;

public class InstantaPlata {
    private String detalii;
    private double pret;
    private ArrayList<Date> zile;


    public InstantaPlata(String detalii, double pret, ArrayList<Date> zile) {
        this.detalii = detalii;
        this.pret = pret;
        this.zile = zile;
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
}
