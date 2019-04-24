package services;

import models.companies.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ScanService {
    private ArrayList<FirmaScanare> firmeScanare=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);
    ObjectOutputStream objectOutputStream;


    public void init(){
        ObjectInputStream objectInputStream;
        try{
            objectInputStream=new ObjectInputStream(new FileInputStream("firmeScanare.info"));

            FirmaScanare firmaScanare;

            while((firmaScanare=(FirmaScanare) objectInputStream.readObject())!=null){
                firmeScanare.add(firmaScanare);
            }
        }

        catch(FileNotFoundException filenotfound){
            System.out.println("Inca nu exista fisierul, se creeaza acum");
            File fisier=new File("firmeScanare.info");
            boolean exista_deja;
            try{
                exista_deja=fisier.createNewFile();
            }catch(Exception exc){
                System.out.println("Nu s-a putut crea");
            }
        }
        catch (Exception eof){
        }


try{
    objectOutputStream=new ObjectOutputStream(new FileOutputStream("firmeScanare.info",true));

}catch (Exception e){

}

    }

    public FirmaScanare citeste_firma_scanare(){
        System.out.println("Care e numele firmei de scanare?");
        String nume=scanner.nextLine();
        System.out.println("Cate scannere poate sustine simultan?");
        int nr_scannere=Integer.parseInt( scanner.nextLine());
        return new FirmaScanare(nume,nr_scannere);
    }

    public void adauga_firma_scanare(){
        FirmaScanare firmaScanare=citeste_firma_scanare();
        firmeScanare.add(firmaScanare);
        Logger.getInstance().add("S-a adaugat firma de scanare "+firmaScanare.toString()+"\n");


        try{
            objectOutputStream.writeObject(firmaScanare);

        }catch(Exception exc){
            System.out.println("CEVA A MERS FOARTE PROST");
        }
    }

    public void afiseaza_firme_scanare(){
        for(int i=0;i<firmeScanare.size();i++){
            System.out.println((i+1)+"."+firmeScanare.get(i).toString());
        }
    }

    public FirmaScanare ret_firma_scanare(){
        do{
            System.out.println("Alege firma de scanare indicand numarul");
            afiseaza_firme_scanare();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<=firmeScanare.size()){
                return firmeScanare.get(nr_ales-1);
            }
        }while (true);

    }
}
