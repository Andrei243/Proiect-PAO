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

    private void adauga_comun(FirmaProductie firmaProductie){
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

    public void adauga_firma_productie(){
        FirmaProductie firmaProductie=citeste_firma_productie();
       adauga_comun(firmaProductie);
    }
    public void adauga_firma_productie(String nume){
        FirmaProductie firmaProductie=new FirmaProductie(nume);
        adauga_comun(firmaProductie);
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

    private void stergere_comuna(FirmaProductie firmaProductie){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(" nume = '");
        stringBuilder.append(firmaProductie.getNume());
        stringBuilder.append("'");
        stergeElement("FirmeProductie",stringBuilder.toString());
        elemente.remove(firmaProductie);
    }

    public void stergeFirmaProductie(){
        FirmaProductie firmaProductie=ret_firma_productie();
        stergere_comuna(firmaProductie);
    }

    public void stergeFirmaProductie(int index){
        FirmaProductie firmaProductie=elemente.get(index);
        stergere_comuna(firmaProductie);

    }

    public void schimba_firma_productie(int x,String nume){
        FirmaProductie fost=elemente.get(x);
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(" Where nume='");
        stringBuilder.append(fost.getNume());
        stringBuilder.append("'");
        String conditie=stringBuilder.toString();

        FirmaProductie nou=new FirmaProductie(nume);
        stringBuilder.setLength(0);
        stringBuilder.append(" Set nume='");
        stringBuilder.append(nou.getNume());
        stringBuilder.append("'");
        String update=stringBuilder.toString();

        String cerere=update + conditie;
        schimbaElement("FirmeProductie",cerere);

    }

}
