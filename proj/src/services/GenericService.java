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
String qrySQL="SELECT * FROM "+numeTabel + " ORDER BY 1";
String database="jdbc:mysql://localhost:3306/ProiectPAO?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

try(  Connection  conn=DriverManager.getConnection( database, "Andrei243","Andrei243");
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

class StergatorDinBD implements Runnable{
    private String conditie;
    private String tabel;
    StergatorDinBD(String _conditie,String _tabel){
        conditie=_conditie;
        tabel=_tabel;
    }
    @Override
    public void run(){
        String qrySQL="Delete from "+tabel+" where "+conditie;
        String database="jdbc:mysql://localhost:3306/ProiectPAO?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try(  Connection  conn=DriverManager.getConnection( database, "Andrei243","Andrei243");
              Statement stmt=conn.createStatement();
        ) {
            int nr=stmt.executeUpdate(qrySQL);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

}

class EditorInBD implements Runnable{
    String cerere;
    String tabel;
    EditorInBD(String _tabel,String _cerere){
        tabel=_tabel;
        cerere=_cerere;
    }

    @Override
    public void run(){
        StringBuilder qrybuilder=new StringBuilder();
        qrybuilder.append("Update ");
        qrybuilder.append(tabel);
        qrybuilder.append(" ");
        qrybuilder.append(cerere);
        String qrySQL=qrybuilder.toString();
        String database="jdbc:mysql://localhost:3306/ProiectPAO?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try(  Connection  conn=DriverManager.getConnection( database, "Andrei243","Andrei243");
              Statement stmt=conn.createStatement();
        ) {
            int nr=stmt.executeUpdate(qrySQL);


        }

        catch(Exception e){
            e.printStackTrace();
        }


    }

}


class AdaugatorInBD<T> implements Runnable{
    ArrayList<String> element;
    String tabel;

    AdaugatorInBD(ArrayList<String> _element,String _tabel){
        element=_element;
        tabel=_tabel;
    }

    @Override
    public void run(){
        StringBuilder qrybuilder=new StringBuilder();
        qrybuilder.append("Insert into " + tabel+" values(");
        qrybuilder.append(element.get(0));
        for(int i=1;i<element.size();i++){
            qrybuilder.append(","+element.get(i));
        }
        qrybuilder.append(")");
        String qrySQL=qrybuilder.toString();
        String database="jdbc:mysql://localhost:3306/ProiectPAO?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try(  Connection  conn=DriverManager.getConnection( database, "Andrei243","Andrei243");
              Statement stmt=conn.createStatement();
        ) {
            int nr=stmt.executeUpdate(qrySQL);


        }

        catch(Exception e){
            e.printStackTrace();
        }


    }

}

abstract public class GenericService<T> {
    public ArrayList<String> getStrings(){
        ArrayList<String> stringuri=new ArrayList<>();
        for(T element : elemente){
            stringuri.add(element.toString());
        }
        return stringuri;

    }

    protected ArrayList<T>elemente =new ArrayList<>();
    private ObjectOutputStream objectOutputStream;

    protected void stergeElement(String numetabel,String conditie){
        Thread thread=new Thread(new StergatorDinBD(conditie,numetabel));
        thread.run();
    }

    protected void adaugaElement(String numetabel,ArrayList<String> campuri){
        Thread thread=new Thread(new AdaugatorInBD<T>(campuri,numetabel));
        thread.run();
    }
    protected  void schimbaElement(String numetabel,String cerere){
        Thread thread=new Thread(new EditorInBD(numetabel,cerere));
        thread.run();
    }

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
