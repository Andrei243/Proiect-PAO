package services;

import models.*;

import java.util.*;

public class LocationService extends GenericService<Locatie> {


    private static Scanner scanner=new Scanner(System.in);

    private Locatie citeste_locatie(){
        System.out.println("Scrie tara locatiei:");
        String tara=scanner.nextLine();
        System.out.println("Scrie orasul locatiei:");
        String oras=scanner.nextLine();
        return new Locatie(tara,oras);
    }

    public void adauga_locatie(){
        Locatie aux=citeste_locatie();
        elemente.add(aux);
        Collections.sort(elemente);
        ArrayList<String> element=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("\"");
        stringBuilder.append(aux.getTara());
        stringBuilder.append("\"");
        element.add(stringBuilder.toString());
        stringBuilder.setLength(0);
        stringBuilder.append("\"");
        stringBuilder.append(aux.getOras());
        stringBuilder.append("\"");
        element.add(stringBuilder.toString());
        adaugaElement("Locatii",element);

        Logger.getInstance().add("S-a adaugat locatia "+aux.toString()+"\n");

    }

    public void afiseaza_locatii(){
        for(int i = 0; i< elemente.size(); i++){
            System.out.println((i+1)+"."+ elemente.get(i).toString());
        }

    }

    public Locatie ret_locatie(){
        do{
            System.out.println("Alege locatia indicand numarul");
            afiseaza_locatii();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<= elemente.size()){
                return elemente.get(nr_ales-1);
            }
        }while (true);

    }

    public void stergereLocatie(){
        Locatie locatie=ret_locatie();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("tara = '");
        stringBuilder.append(locatie.getTara());
        stringBuilder.append("' and oras = '");
        stringBuilder.append(locatie.getOras());
        stringBuilder.append("'");
        stergeElement("Locatii",stringBuilder.toString());
        elemente.remove(locatie);

    }








}
