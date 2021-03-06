package models;

import java.io.Serializable;

public class Locatie implements Comparable<Locatie>, Serializable {
    String tara;
    String oras;
    public Locatie(String _tara,String _oras){
        tara=_tara;
        oras=_oras;
    }

    public String getTara(){
        return tara;
    }

    public String getOras(){
        return oras;
    }

    @Override
    public int compareTo(Locatie o){
        if(!tara.equals(o.tara)){
            return tara.compareTo(o.tara);
        }
        else return oras.compareTo(o.oras);


    }

    @Override
    public String toString(){
        return tara+" "+oras;
    }

}
