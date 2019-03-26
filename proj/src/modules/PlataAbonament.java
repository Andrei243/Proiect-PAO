package modules;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class PlataAbonament implements Plata {
    private ArrayList<PlataSingulara> pretFiecareZi;

    @Override
    public double getMoney() {
        int nr_zile;
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("Cate zile vrei sa mergi ?");
            nr_zile=scanner.nextInt();

        }while (nr_zile<0 || nr_zile>pretFiecareZi.size());
        if(nr_zile==pretFiecareZi.size()){
            double suma=0;
            for(Plata plata:pretFiecareZi){
                suma+=plata.getMoney();
            }
            suma=suma*0.8;
            return suma;
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

            for(int i:zile){
                suma+=pretFiecareZi.get(i).getMoney();
            }
            return suma;

        }

    }

    PlataAbonament(ArrayList<PlataSingulara> _pret){
        pretFiecareZi=_pret;
    }
}
