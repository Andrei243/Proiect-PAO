package ui;

import modules.AdaugareImposibila;
import services.UserService;

//import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        UserService userService=new UserService();
        Scanner scanner=new Scanner(System.in);
        boolean raspuns_ret=false;

        do{
            System.out.println("Ce actiune vrei sa faci?");
            System.out.println("1.Adaugi o locatie");
            System.out.println("2.Afisezi toate locatiile actuale");
            System.out.println("3.Adaugi un client");
            System.out.println("4.Afisezi toti clientii");
            System.out.println("5.Adaugi o firma de productie");
            System.out.println("6.Afisezi toate firmele de productie");
            System.out.println("7.Adaugi o firma de scanare");
            System.out.println("8.Afisezi toate firmele de scanare");
            System.out.println("9.Adaugi un eveniment");
            System.out.println("10.Afisezi toate evenimentele");
            System.out.println("11.Faci o comanda");
            System.out.println("12.Afisezi toate comenzile de pana acum");
            System.out.println("13.Inchizi programul");

            try {
                String alegere=scanner.nextLine();
                switch(alegere){
                    case "1":
                        userService.adauga_locatie();
                        break;
                    case "2":
                        userService.afiseaza_locatii();
                        break;
                    case "3":
                        userService.adauga_client();
                        break;
                    case "4":
                        userService.afiseaza_clienti();
                        break;
                    case "5":
                        userService.adauga_firma_productie();
                        break;
                    case "6":
                        userService.afiseaza_firme_productie();
                        break;
                    case "7":
                        userService.adauga_firma_scanare();
                        break;
                    case "8":
                        userService.afiseaza_firme_scanare();
                        break;
                    case "9":
                        userService.adauga_eveniment();
                        break;
                    case "10":
                        userService.afiseaza_evenimente();
                        break;
                    case "11":
                        userService.adauga_comanda();
                        break;
                    case "12":
                        userService.afiseaza_comenzi();
                        break;
                    case "13":
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
