package services;

import modules.*;

import java.util.*;

public class UserService {

    private ArrayList<Locatie>locatii=new ArrayList<>();

    private static Scanner scanner=new Scanner(System.in);

    private Date creaza_data(int an,int luna,int zi)throws AdaugareImposibila{
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,an);
        if(luna > 12)throw new AdaugareImposibila();
        calendar.set(Calendar.MONTH,luna-1);
        calendar.set(Calendar.DAY_OF_MONTH,zi);
        return calendar.getTime();
    }

    private Date citeste_data()throws AdaugareImposibila{
        int zi,luna,an;
        System.out.print("ZI:");
        zi=scanner.nextInt();
        System.out.print("Luna");
        luna=scanner.nextInt();
        System.out.print("An:");
        an=scanner.nextInt();
        return creaza_data(an,luna,zi);
    }

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

    private Eveniment citeste_eveniment() throws AdaugareImposibila{
        System.out.println("Alege tipul de eveniment:");
        int nr_ales=0;
        do{
            System.out.println("1.De o singura zi\n2.De mai multe zile\n3.Renunta");
            nr_ales=scanner.nextInt();
            if(nr_ales==1||nr_ales==2)break;
            if(nr_ales==3)throw new AdaugareImposibila();
            System.out.println("Ai ales gresit");
        }while(true);

        int nr_maxim_persoane,nr_necesar_scannere;
        FirmaProductie firmaProductie=ret_firma_productie();
        FirmaScanare firmaScanare=ret_firma_scanare();
        System.out.println("Care e numarul maxim de participanti?");
        nr_maxim_persoane=scanner.nextInt();
        System.out.println("Care e numarul necesar de scannere?");
        nr_necesar_scannere=scanner.nextInt();
        System.out.println("Pe ce data incepe?");
        Date data=citeste_data();
        Eveniment eveniment;

        if(nr_ales==1){
            //De o zi
            System.out.println("Cat costa?");
            double pret_zi=scanner.nextInt();
            PlataSingulara plataSingulara=new PlataSingulara(pret_zi,data);
            eveniment=new EvenimentDeOZi(nr_maxim_persoane,nr_necesar_scannere,plataSingulara,firmaScanare,firmaProductie,data);

        }
        else{
            //De mai multe zile
            System.out.println("Cate zile tine?");
            int nr_zile=scanner.nextInt();
            System.out.println("Cat costa intr-o zi?");
            double pret_zi=scanner.nextInt();
            PlataAbonament plataAbonament=new PlataAbonament(data,nr_zile,pret_zi);
            eveniment=new EvenimentDeMaiMulteZile(nr_maxim_persoane,nr_necesar_scannere,plataAbonament,firmaScanare,firmaProductie,data,nr_zile);



        }

        return eveniment;
    }

    public void adauga_eveniment()throws AdaugareImposibila{
        Eveniment eveniment=citeste_eveniment();
        evenimente.add(eveniment);

    }

    public void afiseaza_evenimente(){
        for(int i=0;i<evenimente.size();i++){
            System.out.println((i+1)+"."+evenimente.get(i).toString());
        }

    }

    private Eveniment ret_eveniment(){
        do{
            System.out.println("Alege evenimentul indicand numarul");
            afiseaza_evenimente();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<=evenimente.size()){
                return evenimente.get(nr_ales);
            }
        }while (true);

    }

    private Set<Comanda> comenzi=new TreeSet<>();

    private Comanda citeste_comanda()throws AdaugareImposibila{
        System.out.println("Cine cumpara acest bilet?");
        Client client=ret_client();
        System.out.println("La ce eveniment vrea?");
        Eveniment eveniment=ret_eveniment();
        Comanda comanda=new Comanda(client,eveniment);
        return comanda;

    }

    public void adauga_comanda()throws AdaugareImposibila{
        Comanda comanda=citeste_comanda();
        comenzi.add(comanda);
    }
    public void afiseaza_comanda(){
        Iterator<Comanda>iterator = comenzi.iterator();
        int i=1;
        while(iterator.hasNext()){
            System.out.println(i+"."+iterator.next().toString());
        }


    }

}
