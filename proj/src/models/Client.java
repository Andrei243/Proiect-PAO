package models;

import java.io.Serializable;

public class Client implements Serializable {
    private String nume;
   public Client(String _nume){
       nume=_nume;
   }

   public String getNume(){
       return nume;
   }

}
