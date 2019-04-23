package services;

import modules.*;

import java.util.*;

public class LocationService {

    private ArrayList<Locatie>locatii=new ArrayList<>();

    private static Scanner scanner=new Scanner(System.in);

    private Date creaza_data(int an,int luna,int zi)throws AdaugareImposibila{
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,an);
        if(luna > 12)throw new AdaugareImposibila("Ultima luna a anului este a 12-a");
        calendar.set(Calendar.MONTH,luna-1);
        calendar.set(Calendar.DAY_OF_MONTH,zi);
        return calendar.getTime();
    }

    private Date citeste_data()throws AdaugareImposibila{
        int zi,luna,an;

        System.out.print("ZI:");
        zi=Integer.parseInt( scanner.nextLine());
        System.out.print("Luna");
        luna=Integer.parseInt( scanner.nextLine());
        System.out.print("An:");
        an=Integer.parseInt( scanner.nextLine());


        return creaza_data(an,luna,zi);
    }

    private Locatie citeste_locatie(){
        System.out.println("Scrie tara locatiei:");
        String tara=scanner.nextLine();
        System.out.println("Scrie orasul locatiei:");
        String oras=scanner.nextLine();
        return new Locatie(tara,oras);
    }

    public void adauga_locatie(){
        Locatie aux=citeste_locatie();
        locatii.add(aux);
        Collections.sort(locatii);
    }

    public void afiseaza_locatii(){
        for(int i=0;i<locatii.size();i++){
            System.out.println((i+1)+"."+locatii.get(i).toString());
        }

    }

    private Locatie ret_locatie(){
        do{
            System.out.println("Alege locatia indicand numarul");
            afiseaza_locatii();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<=locatii.size()){
                return locatii.get(nr_ales-1);
            }
        }while (true);

    }












}
