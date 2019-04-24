package services;

import models.*;

import java.io.*;
import java.util.*;

public class LocationService {

    private ArrayList<Locatie>locatii=new ArrayList<>();

    private static Scanner scanner=new Scanner(System.in);
    ObjectOutputStream objectOutputStream;


    public void init(){
        ObjectInputStream objectInputStream;
        try{
            objectInputStream=new ObjectInputStream(new FileInputStream("locatii.info"));

            Locatie locatie;

            while((locatie=(Locatie)objectInputStream.readObject())!=null){
                locatii.add(locatie);
            }
        }

        catch(FileNotFoundException filenotfound){
            System.out.println("Inca nu exista fisierul, se creeaza acum");
            File fisier=new File("locatii.info");
            boolean exista_deja;
            try{
                exista_deja=fisier.createNewFile();
            }catch(Exception exc){
                System.out.println("Nu s-a putut crea");
            }        }
        catch (Exception e){

        }

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("locatii.info", true));
        }catch (Exception e){

        }


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
        Logger.getInstance().add("S-a adaugat locatia "+aux.toString()+"\n");


        try{
            objectOutputStream.writeObject(aux);

        }catch(Exception exc){
            System.out.println("CEVA A MERS FOARTE PROST");
        }
    }

    public void afiseaza_locatii(){
        for(int i=0;i<locatii.size();i++){
            System.out.println((i+1)+"."+locatii.get(i).toString());
        }

    }

    public Locatie ret_locatie(){
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
