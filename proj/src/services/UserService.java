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
    private FirmaProductie citeste_firma_productie(){
        System.out.println("Care e numele firmei de productie?");
        String nume=scanner.nextLine();
        return new FirmaProductie(nume);
    }

    public void adauga_firma_productie(){
        FirmaProductie firmaProductie=citeste_firma_productie();
        firmeProductie.add(firmaProductie);
    }

    public void afiseaza_firme_productie(){
        for(int i=0;i<firmeProductie.size();i++){
            System.out.println((i+1)+"."+firmeProductie.get(i).toString());
        }
    }

    private FirmaProductie ret_firma_productie(){
        do{
            System.out.println("Alege firma de productie indicand numarul");
            afiseaza_firme_productie();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<=firmeProductie.size()){
                return firmeProductie.get(nr_ales);
            }
        }while (true);

    }


    private ArrayList<FirmaScanare> firmeScanare=new ArrayList<>();

    private FirmaScanare citeste_firma_scanare(){
        System.out.println("Care e numele firmei de scanare?");
        String nume=scanner.nextLine();
        System.out.println("Cate scannere poate sustine simultan?");
        int nr_scannere=scanner.nextInt();
        return new FirmaScanare(nume,nr_scannere);
    }

    public void adauga_firma_scanare(){
        FirmaScanare firmaScanare=citeste_firma_scanare();
        firmeScanare.add(firmaScanare);
    }

    public void afiseaza_firme_scanare(){
        for(int i=0;i<firmeScanare.size();i++){
            System.out.println((i+1)+"."+firmeScanare.get(i).toString());
        }
    }

    private FirmaScanare ret_firma_scanare(){
        do{
            System.out.println("Alege firma de scanare indicand numarul");
            afiseaza_firme_scanare();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<=firmeScanare.size()){
                return firmeScanare.get(nr_ales);
            }
        }while (true);

    }

    private ArrayList<Eveniment> evenimente=new ArrayList<>();
    private Set<Comanda> comenzi=new TreeSet<>();

}
