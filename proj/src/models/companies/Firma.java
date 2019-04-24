package models.companies;

import java.io.Serializable;

abstract public class Firma implements Serializable {
    protected String nume;

    Firma(String _nume){
        nume=_nume;
    }

    abstract public String toString();
}
