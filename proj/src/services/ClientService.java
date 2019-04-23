package services;

import models.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientService {
    private ArrayList<Client> clienti=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);
    public Client citeste_client(){
        System.out.println("Care e numele clientului?");
        String nume=scanner.nextLine();
        return new Client(nume);
    }

    public void adauga_client(){
        Client client=citeste_client();
        Logger.getInstance().add("S-a adaugat clientul "+client.getNume()+"\n");

        clienti.add(client);
    }

    public void afiseaza_clienti(){
        for(int i=0;i<clienti.size();i++){
            System.out.println((i+1)+"."+clienti.get(i).getNume());
        }
    }

    public Client ret_client(){
        do{
            System.out.println("Alege locatia indicand numarul");
            afiseaza_clienti();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<=clienti.size()){
                return clienti.get(nr_ales-1);
            }
        }while (true);

    }
}
