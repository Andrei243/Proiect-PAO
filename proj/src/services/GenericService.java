package services;

import java.io.*;
import java.util.ArrayList;

abstract public class GenericService<T> {
    protected ArrayList<T>elemente =new ArrayList<>();
    private ObjectOutputStream objectOutputStream;
    protected void init(String path){
        ObjectInputStream objectInputStream;
        try{
            objectInputStream=new ObjectInputStream(new FileInputStream(path));
            T element;


            while(true){
                try{
                    element=(T)objectInputStream.readObject();
                    elemente.add(element);
                }catch(EOFException e){
                    break;
                }

            }
            objectInputStream.close();
        }

        catch(FileNotFoundException filenotfound){
            System.out.println("Nu exista inca fisierul, se creeaza acum");
            File fisier=new File(path);
            boolean exista_deja;
            try{
                exista_deja=fisier.createNewFile();
            }catch(Exception exc){
                System.out.println("Nu s-a putut crea");
            }        }
        catch(Exception e){
            e.printStackTrace();
        }



        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        }catch (Exception e){
            System.out.println("Nu s-a deschis cum trebuie scrierea");
        }


    }

    protected void inchidere(){
        try {
            for (T element : elemente) {
                objectOutputStream.writeObject(element);
            }
        }
        catch(IOException e){
            System.out.println( "Nu s-a putut scrie" );
        }
        try{
    objectOutputStream.close();
    }
    catch(IOException e){
        System.out.println("Nu s-a putut inchide fisierul");
    }
    }
}
