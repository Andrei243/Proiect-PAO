package services;

import models.Locatie;
import models.companies.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductionService {
    Scanner scanner=new Scanner(System.in);
    private ArrayList<FirmaProductie> firmeProductie=new ArrayList<>();
    ObjectOutputStream objectOutputStream;

    public FirmaProductie citeste_firma_productie(){
        System.out.println("Care e numele firmei de productie?");

        String nume=scanner.nextLine();
        return new FirmaProductie(nume);
    }
    public void init(){
        ObjectInputStream objectInputStream;
        try{
            objectInputStream=new ObjectInputStream(new FileInputStream("firmeProductie.info"));
             FirmaProductie firmaProductie;


            while((firmaProductie=(FirmaProductie) objectInputStream.readObject())!=null){
                firmeProductie.add(firmaProductie);
            }
        }

        catch(FileNotFoundException filenotfound){
            System.out.println("Nu exista inca fisierul, se creeaza acum");
            File fisier=new File("firmeProductie.info");
            boolean exista_deja;
            try{
                exista_deja=fisier.createNewFile();
            }catch(Exception exc){
                System.out.println("Nu s-a putut crea");
            }        }
        catch (Exception eof){
        }
try {
    objectOutputStream = new ObjectOutputStream(new FileOutputStream("firmeProductie.info", true));
}catch (Exception e){

}


    }

    public void adauga_firma_productie(){
        FirmaProductie firmaProductie=citeste_firma_productie();
        firmeProductie.add(firmaProductie);
        Logger.getInstance().add("S-a adaugat firma de productie "+firmaProductie.toString()+"\n");


        try{
            objectOutputStream.writeObject(firmaProductie);

        }catch(Exception exc){
            System.out.println("CEVA A MERS FOARTE PROST");
        }
    }

    public void afiseaza_firme_productie(){
        for(int i=0;i<firmeProductie.size();i++){
            System.out.println((i+1)+"."+firmeProductie.get(i).toString());
        }
    }

    public FirmaProductie ret_firma_productie(){
        do{
            System.out.println("Alege firma de productie indicand numarul");
            afiseaza_firme_productie();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<=firmeProductie.size()){
                return firmeProductie.get(nr_ales-1);
            }
        }while (true);

    }

}
