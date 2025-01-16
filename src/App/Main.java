package App;

import jdk.jshell.execution.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = Utils.initData();
        Utils.printBanner("Panel administracyjny firmy " + company.getName());

        boolean done = false;
        while (!done) {

            System.out.println("Dostępne operacje:");
            System.out.println("1 - Wyświetl pracowników");
            System.out.println("2 - Dodaj pracownika");
            System.out.println("3 - Zwolnij pracownika");
            System.out.println("0 - Zakończ program");
            System.out.println();

            int choice = Utils.inputInt("Wybierz operację: ");

            switch (choice) {
                case 1:
                    company.displayEmployees(false);
                    break;
                case 2:
                    String name = Utils.inputString("Podaj imię: ");
                    String surname = Utils.inputString("Podaj nazwisko: ");
                    String city = Utils.inputString("Podaj miasto: ");
                    String street = Utils.inputString("Podaj ulicę: ");
                    company.addEmployee(name, surname, new Address(city, street));
                    Utils.printAnswer("Dodano pomyślnie pracownika: %s %s".formatted(name, surname));
                    break;
                case 3:
                    company.displayEmployees(true);

                    break;
                case 0:
                    Utils.printAnswer("Do zobaczenia");
                    done = true;
                    break;
                default:
                    Utils.printAnswer("Podano błędną wartość, spróbuj jeszcze raz");
            }
        }
    }
}
