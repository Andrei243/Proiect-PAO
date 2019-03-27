package modules;

public class FirmaProductie extends Firma {

    FirmaProductie(String _nume){
        super(_nume);
    }

    @Override
    public String toString() {
        return nume;
    }
}
