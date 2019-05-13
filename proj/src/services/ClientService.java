package services;

import models.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientService extends GenericService<Client>{
    Scanner scanner=new Scanner(System.in);



    public Client citeste_client(){
        System.out.println("Care e numele clientului?");
        String nume=scanner.nextLine();
        return new Client(nume);
    }

    public void adauga_client(){
        Client client=citeste_client();
        Logger.getInstance().add("S-a adaugat clientul "+client.getNume()+"\n");

        ArrayList<String> element=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("\"");
        stringBuilder.append(client.getNume());
        stringBuilder.append("\"");
        element.add(stringBuilder.toString());
        adaugaElement("Clienti",element);
        elemente.add(client);


    }

    public void afiseaza_clienti(){
        for(int i = 0; i< elemente.size(); i++){
            System.out.println((i+1)+"."+ elemente.get(i).getNume());
        }
    }

    public Client ret_client(){
        do{
            System.out.println("Alege locatia indicand numarul");
            afiseaza_clienti();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<= elemente.size()){
                return elemente.get(nr_ales-1);
            }
        }while (true);

    }

    public void stergeClient(){
        Client client=ret_client();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(" nume ='");
        stringBuilder.append(client.getNume());
        stringBuilder.append("'");
        stergeElement("Clienti",stringBuilder.toString());
        elemente.remove(client);


    }

}


