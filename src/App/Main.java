package App;

import jdk.jshell.execution.Util;

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
                    Utils.printAnswer(company.getEmployees().toString());
                    break;
                case 2:
                    String name = Utils.inputString("Podaj imię: ");
                    String surname = Utils.inputString("Podaj nazwisko: ");
                    company.addEmployee(name, surname);
                    Utils.printAnswer("Dodano pomyślnie pracownika: %s %s".formatted(name, surname));
                    break;
                case 3:
                    //code here...
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
