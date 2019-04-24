package models.companies;


import java.io.Serializable;

public class FirmaProductie extends Firma implements Serializable {

    public FirmaProductie(String _nume){
        super(_nume);
    }

    @Override
    public String toString() {
        return nume;
    }
}
