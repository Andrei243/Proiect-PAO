package services;

import modules.*;

import java.util.*;

public class UserService {

    private ArrayList<Locatie>locatii=new ArrayList<>();

    private static Scanner scanner=new Scanner(System.in);

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
                return locatii.get(nr_ales);
            }
        }while (true);

    }

    private ArrayList<Client>clienti=new ArrayList<>();
    private Client citeste_client(){
        System.out.println("Care e numele clientului?");
        String nume=scanner.nextLine();
        return new Client(nume);
    }

    public void adauga_client(){
        Client client=citeste_client();
        clienti.add(client);
    }

    public void afiseaza_clienti(){
        for(int i=0;i<clienti.size();i++){
            System.out.println((i+1)+"."+clienti.get(i).getNume());
        }
    }

    private Client ret_client(){
        do{
            System.out.println("Alege locatia indicand numarul");
            afiseaza_clienti();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<=clienti.size()){
                return clienti.get(nr_ales);
            }
        }while (true);

    }

    private ArrayList<FirmaProductie> firmeProductie=new ArrayList<>();


    private ArrayList<FirmaScanare> firmeScanare=new ArrayList<>();
    private ArrayList<Eveniment> evenimente=new ArrayList<>();
    private Set<Comanda> comenzi=new TreeSet<>();

}
