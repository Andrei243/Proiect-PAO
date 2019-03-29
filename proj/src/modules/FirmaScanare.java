package modules;

public class FirmaScanare extends Firma {
    protected int numar_scanere;

    public FirmaScanare(String _nume,int _numar_scanere){
        super(_nume);
        numar_scanere=_numar_scanere;
    }

    @Override
    public String toString() {
        return nume;
    }

    public int getNumar_scanere() {
        return numar_scanere;
    }
}
