package modules;

import java.util.*;

public class PlataAbonament implements Plata {
    private ArrayList<PlataSingulara> pretFiecareZi;



    @Override
    public InstantaPlata getMoney() {
        int nr_zile;
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("Cate zile vrei sa mergi ?");
            nr_zile=scanner.nextInt();

        }while (nr_zile<0 || nr_zile>pretFiecareZi.size());
        if(nr_zile==pretFiecareZi.size()){
            double suma=0;
            ArrayList<Date> zile=new ArrayList<>();
            for(Plata plata:pretFiecareZi){
                suma+=plata.getMoney().getPret();
                zile.add(plata.getMoney().getZile().get(0));
            }
            suma=suma*0.8;
            return new InstantaPlata("Abonament complet",suma,zile);
        }
        else {
            double suma=0;
            TreeSet<Integer>zile=new TreeSet<>();
            int nr_alese=0;
            do{
                Integer nr_prezent=scanner.nextInt();
                if(!zile.contains(nr_prezent)){
                    zile.add(nr_prezent);

                    nr_alese++;
                }
                else{
                    System.out.println("Numarul se regaseste deja");

                }


            }while(nr_alese!=nr_zile);
            ArrayList<Date> zile_act=new ArrayList<>();
            StringBuilder detalii=new StringBuilder();
            detalii.append("Abonament cumparat pentru zilele: ");
            for(int i:zile){
                suma+=pretFiecareZi.get(i).getMoney().getPret();
                detalii.append(i).append(" ");
                zile_act.add(pretFiecareZi.get(i).getMoney().getZile().get(0));
            }
            return new InstantaPlata(detalii.toString(),suma,zile_act);

        }

    }

    public PlataAbonament(Date data_inceput,int nr_zile,double pret_zi){
        pretFiecareZi=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(data_inceput);
        Date aux=calendar.getTime();
        for(int i=0;i<nr_zile;i++){
            pretFiecareZi.add(new PlataSingulara(pret_zi,aux));
            calendar.add(Calendar.DAY_OF_MONTH,1);

        }


    }
}
