package services;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import models.companies.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ScanService extends GenericService<FirmaScanare>{
    Scanner scanner=new Scanner(System.in);



    public FirmaScanare citeste_firma_scanare(){
        System.out.println("Care e numele firmei de scanare?");
        String nume=scanner.nextLine();
        System.out.println("Cate scannere poate sustine simultan?");
        int nr_scannere=Integer.parseInt( scanner.nextLine());
        return new FirmaScanare(nume,nr_scannere);
    }

    private void comun_adaug(FirmaScanare firmaScanare){
        elemente.add(firmaScanare);
        ArrayList<String>element=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("\"");
        stringBuilder.append(firmaScanare.getNume());
        stringBuilder.append("\"");
        element.add(stringBuilder.toString());
        element.add(((Integer)firmaScanare.getNumar_scanere()).toString());
        adaugaElement("FirmeScanare",element);

        Logger.getInstance().add("S-a adaugat firma de scanare "+firmaScanare.toString()+"\n");
    }

    public void adauga_firma_scanare(){
        FirmaScanare firmaScanare=citeste_firma_scanare();
       comun_adaug(firmaScanare);
    }

    public void adauga_firma_scanare(String nume,int nrScanere){
        FirmaScanare firmaScanare=new FirmaScanare(nume,nrScanere);
        comun_adaug(firmaScanare);
    }

    public void afiseaza_firme_scanare(){
        for(int i = 0; i< elemente.size(); i++){
            System.out.println((i+1)+"."+ elemente.get(i).toString());
        }
    }

    public FirmaScanare ret_firma_scanare(){
        do{
            System.out.println("Alege firma de scanare indicand numarul");
            afiseaza_firme_scanare();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<= elemente.size()){
                return elemente.get(nr_ales-1);
            }
        }while (true);

    }

    private void stergere_comuna(FirmaScanare firmaScanare){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(" nume = '");
        stringBuilder.append(firmaScanare.getNume());
        stringBuilder.append("' and nrScanare = ");
        stringBuilder.append(((Integer)firmaScanare.getNumar_scanere()).toString());
        stergeElement("FirmeScanare",stringBuilder.toString());
        elemente.remove(firmaScanare);
    }


    public void stergeFirmaScanare(){
        FirmaScanare firmaScanare=ret_firma_scanare();
        stergere_comuna(firmaScanare);
    }

    public void stergeFirmaScanare(int index){
        FirmaScanare firmaScanare=elemente.get(index);
        stergere_comuna(firmaScanare);
    }

    public void schimba_firma_scanare(int x,String nume,Integer nr_scanere){
        FirmaScanare fost=elemente.get(x);
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(" Where nume='");
        stringBuilder.append(fost.getNume());
        stringBuilder.append("' and nrScanere=");
        stringBuilder.append(((Integer)fost.getNumar_scanere()).toString());
        String conditie=stringBuilder.toString();

        FirmaScanare nou=new FirmaScanare(nume,nr_scanere);
        stringBuilder.setLength(0);
        stringBuilder.append(" Set nume='");
        stringBuilder.append(nou.getNume());
        stringBuilder.append("', nrScanere=");
        stringBuilder.append(nr_scanere.toString());
        String update=stringBuilder.toString();

        String cerere=update+conditie;
        schimbaElement("FirmeScanare",cerere);

    }

}
