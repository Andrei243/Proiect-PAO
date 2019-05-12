package services;

import stringsToObject.StringToObject;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

class CititorDinBD<T> extends SwingWorker<Integer,ArrayList<String>>{
    protected StringToObject<T> procesator;
    protected String numeTabel;
    protected ArrayList<T> elemente;
    CititorDinBD(String _numeTabel,ArrayList<T> _elemente,StringToObject<T> _procesator ){
        numeTabel=_numeTabel;
        elemente=_elemente;
        procesator=_procesator;
    }

    protected Integer doInBackground(){
String qrySQL="SELECT * FROM "+numeTabel;

try(  Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProiectPAO?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root","Andrei243");
      Statement stmt=conn.createStatement();
      ResultSet rs=stmt.executeQuery(qrySQL);
        ) {
    ResultSetMetaData metaData=rs.getMetaData();
    int nr_coloane=metaData.getColumnCount();
    while(rs.next()) {
        ArrayList<String> campuri = new ArrayList<>();
        for (int i = 1; i <= nr_coloane; i++) {
            campuri.add(rs.getString(i));
        }
        publish(campuri);
    }

}

catch(Exception e){
    e.printStackTrace();
}
        return 1;
    }

    protected void process(List<ArrayList<String>> vectori){
        for(ArrayList<String> rand : vectori){
            elemente.add(procesator.proceseazaStringuri(rand));
        }
    }

}

abstract public class GenericService<T> {

    protected ArrayList<T>elemente =new ArrayList<>();
    private ObjectOutputStream objectOutputStream;
    protected void init(String numeTabel,StringToObject<T> procesator){
        CititorDinBD<T> cititor=new CititorDinBD<T>(numeTabel,elemente,procesator);
        cititor.execute();

//        ObjectInputStream objectInputStream;
//        try{
//            objectInputStream=new ObjectInputStream(new FileInputStream(path));
//            T element;
//
//
//            while(true){
//                try{
//                    element=(T)objectInputStream.readObject();
//                    elemente.add(element);
//                }catch(EOFException e){
//                    break;
//                }
//
//            }
//            objectInputStream.close();
//        }
//
//        catch(FileNotFoundException filenotfound){
//            System.out.println("Nu exista inca fisierul, se creeaza acum");
//            File fisier=new File(path);
//            boolean exista_deja;
//            try{
//                exista_deja=fisier.createNewFile();
//            }catch(Exception exc){
//                System.out.println("Nu s-a putut crea");
//            }        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//
//
//
//        try {
//            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
//        }catch (Exception e){
//            System.out.println("Nu s-a deschis cum trebuie scrierea");
//        }
//

    }

}
