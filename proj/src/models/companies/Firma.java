package models.companies;

abstract public class Firma {
    protected String nume;

    Firma(String _nume){
        nume=_nume;
    }

    abstract public String toString();
}
