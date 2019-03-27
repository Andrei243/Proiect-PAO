package modules;

public class Locatie {
    String tara;
    String oras;
    Locatie(String _tara,String _oras){
        tara=_tara;
        oras=_oras;
    }

    String getTara(){
        return tara;
    }

    String getOras(){
        return oras;
    }
}
