package services;

import modules.*;

import java.util.*;

public class EventService {
    private Date creaza_data(int an,int luna,int zi)throws AdaugareImposibila{
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,an);
        if(luna > 12)throw new AdaugareImposibila("Ultima luna a anului este a 12-a");
        calendar.set(Calendar.MONTH,luna-1);
        calendar.set(Calendar.DAY_OF_MONTH,zi);
        return calendar.getTime();
    }

    private Date citeste_data()throws AdaugareImposibila{
        int zi,luna,an;

        System.out.print("ZI:");
        zi=Integer.parseInt( scanner.nextLine());
        System.out.print("Luna");
        luna=Integer.parseInt( scanner.nextLine());
        System.out.print("An:");
        an=Integer.parseInt( scanner.nextLine());


        return creaza_data(an,luna,zi);
    }
    private ArrayList<Eveniment> evenimente=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);

    public Eveniment citeste_eveniment(ProductionService productionService,ScanService scanService) throws AdaugareImposibila {
        String nume;
        System.out.println("Care e numele evenimentului?");
        nume=scanner.nextLine();
        System.out.println("Alege tipul de eveniment:");
        int nr_ales=0;
        do{
            System.out.println("1.De o singura zi\n2.De mai multe zile\n3.Renunta");
            nr_ales=Integer.parseInt( scanner.nextLine());
            if(nr_ales==1||nr_ales==2)break;
            if(nr_ales==3)throw new AdaugareImposibila("");
            System.out.println("Ai ales gresit");
        }while(true);

        int nr_maxim_persoane,nr_necesar_scannere;
        FirmaProductie firmaProductie=productionService.ret_firma_productie();
        FirmaScanare firmaScanare=scanService.ret_firma_scanare();
        System.out.println("Care e numarul maxim de participanti?");
        nr_maxim_persoane=Integer.parseInt( scanner.nextLine());
        System.out.println("Care e numarul necesar de scannere?");
        nr_necesar_scannere=Integer.parseInt( scanner.nextLine());
        System.out.println("Pe ce data incepe?");
        Date data;
        do {
            try {
                data = citeste_data();
                break;
            }
            catch(AdaugareImposibila adaugareImposibila){
                System.out.println(adaugareImposibila.getMessage());
            }

        }while(true);
        Eveniment eveniment;

        if(nr_ales==1){
            //De o zi
            System.out.println("Cat costa?");
            double pret_zi=Double.parseDouble( scanner.nextLine());
            PlataSingulara plataSingulara=new PlataSingulara(pret_zi,data);
            eveniment=new EvenimentDeOZi(nume,nr_maxim_persoane,nr_necesar_scannere,plataSingulara,firmaScanare,firmaProductie,data);

        }
        else{
            //De mai multe zile
            System.out.println("Cate zile tine?");
            int nr_zile=Integer.parseInt( scanner.nextLine());
            System.out.println("Cat costa intr-o zi?");
            double pret_zi=Double.parseDouble( scanner.nextLine());
            PlataAbonament plataAbonament=new PlataAbonament(data,nr_zile,pret_zi);
            eveniment=new EvenimentDeMaiMulteZile(nume,nr_maxim_persoane,nr_necesar_scannere,plataAbonament,firmaScanare,firmaProductie,data,nr_zile);



        }

        return eveniment;
    }

    public void adauga_eveniment(ProductionService productionService,ScanService scanService)throws AdaugareImposibila{
        Eveniment eveniment=citeste_eveniment(productionService,scanService);
        evenimente.add(eveniment);
        Collections.sort(evenimente);

    }

    public void afiseaza_evenimente(){
        for(int i=0;i<evenimente.size();i++){
            System.out.println((i+1)+"."+evenimente.get(i).toString());
        }

    }

    public Eveniment ret_eveniment(){
        do{
            System.out.println("Alege evenimentul indicand numarul");
            afiseaza_evenimente();
            int nr_ales=scanner.nextInt();
            if(nr_ales>0&&nr_ales<=evenimente.size()){
                return evenimente.get(nr_ales-1);
            }
        }while (true);

    }
}
