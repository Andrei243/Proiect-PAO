package models.companies;

import models.companies.Firma;

public class FirmaProductie extends Firma {

    public FirmaProductie(String _nume){
        super(_nume);
    }

    @Override
    public String toString() {
        return nume;
    }
}
