package services;

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

    public void adauga_firma_scanare(){
        FirmaScanare firmaScanare=citeste_firma_scanare();
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
}
