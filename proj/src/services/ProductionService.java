package services;

import models.companies.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductionService extends GenericService<FirmaProductie> {
    Scanner scanner=new Scanner(System.in);

    public FirmaProductie citeste_firma_productie(){
        System.out.println("Care e numele firmei de productie?");

        String nume=scanner.nextLine();
        return new FirmaProductie(nume);
    }

    public void adauga_firma_productie(){
        FirmaProductie firmaProductie=citeste_firma_productie();
        elemente.add(firmaProductie);
        ArrayList<String>element=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("\"");
        stringBuilder.append(firmaProductie.getNume());
        stringBuilder.append("\"");
        element.add(stringBuilder.toString());
        adaugaElement("FirmeProductie",element);
        Logger.getInstance().add("S-a adaugat firma de productie "+firmaProductie.toString()+"\n");

    }

    public void afiseaza_firme_productie(){
        for(int i = 0; i< elemente.size(); i++){
            System.out.println((i+1)+"."+ elemente.get(i).toString());
        }
    }

    public FirmaProductie ret_firma_productie(){
        do{
            System.out.println("Alege firma de productie indicand numarul");
            afiseaza_firme_productie();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<= elemente.size()){
                return elemente.get(nr_ales-1);
            }
        }while (true);

    }

    public void stergeFirmaProductie(){
        FirmaProductie firmaProductie=ret_firma_productie();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(" nume = '");
        stringBuilder.append(firmaProductie.getNume());
        stringBuilder.append("'");
        stergeElement("FirmeProductie",stringBuilder.toString());
        elemente.remove(firmaProductie);

    }

}
