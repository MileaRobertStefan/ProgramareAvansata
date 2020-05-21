package app;

import com.ClasaSmechea;

import java.io.IOException;
import java.util.Scanner;

public class LocaleExplore {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String comanda;
        ClasaSmechea clasaSmechea = new ClasaSmechea();
        do {
            System.out.println(clasaSmechea.getPromt());
            comanda = scanner.nextLine();
            switch (comanda) {
                default:
                    System.out.println(clasaSmechea.getInvalid());
                    break;
                case "Info":
                    clasaSmechea.info();
                    break;
                case "SetLocale":
                    clasaSmechea.setLocale(scanner.nextLine(),scanner.nextLine());
                    break;
                case "DisplayLocales":
                    clasaSmechea.displayLocales();
                    break;
                case "exit":
                    comanda = "exit";
                    break;
            }
        } while (!comanda.toLowerCase().equals("exit"));

    }

}
