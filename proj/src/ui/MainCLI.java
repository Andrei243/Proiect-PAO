package ui;

import models.AdaugareImposibila;
import services.AppService;
//import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCLI {
    public static void main(String[] args){
        AppService userService=AppService.getInstance();
        Scanner scanner=new Scanner(System.in);
        boolean raspuns_ret=false;

        do{
            System.out.println("Ce actiune vrei sa faci?");
            System.out.println("1.Adaugi un eveniment");
            System.out.println("2.Afisezi toate evenimentele");
            System.out.println("3.Faci o comanda");
            System.out.println("4.Afisezi toate comenzile de pana acum");
            System.out.println("5.Inchizi programul");


            try {
                String alegere=scanner.nextLine();
                switch(alegere){
                    case "1":
                        userService.adauga_eveniment();
                        break;
                    case "2":
                        userService.afiseaza_evenimente();
                        break;
                    case "3":
                        userService.adauga_comanda();
                        break;
                    case "4":
                        userService.afiseaza_comenzi();
                        break;
                    case "5":
                        raspuns_ret=true;
                        break;
                        default:
                        throw new AdaugareImposibila("Nu ai ales un raspuns valid");



                }
            }
            catch (AdaugareImposibila adaugareImposibila){
                System.out.println(adaugareImposibila.getMessage());
            }

        }while(!raspuns_ret);


    }

}
