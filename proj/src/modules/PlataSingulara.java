package modules;

public class PlataSingulara implements Plata {
    private double pret;

    @Override
    public double getMoney(){
        return pret;
    }

    PlataSingulara(double _pret){
        pret=_pret;
    }
}
