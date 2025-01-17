package App;

public class Main {
    public static void main(String[] args) {
        Company company = Utils.initData();
        Utils.printBanner("Panel administracyjny firmy " + company.getName());

        boolean done = false;
        while (!done) {

            System.out.println("Dostępne operacje:");
            System.out.println("1 - Wyświetl firmę");
            System.out.println("2 - Wyświetl pracowników");
            System.out.println("3 - Dodaj pracownika");
            System.out.println("4 - Zwolnij pracownika");
            System.out.println("5 - Edycja pracownika");
            System.out.println("6 - Edycja firmy");
            System.out.println("0 - Zakończ program");
            System.out.println();

            int choice = Utils.inputInt("Wybierz operację: ");

            switch (choice) {
                case 1:
                    System.out.println(company);
                    System.out.println("\n");
                    break;
                case 2:
                    company.displayEmployees(false);
                    System.out.println("\n");
                    break;

                case 3:
                    String name = Utils.inputString("Podaj imię: ");
                    String surname = Utils.inputString("Podaj nazwisko: ");
                    Address address = Utils.addressInput();
                    company.addEmployee(name, surname, address);
                    Utils.printAnswer("Dodano pomyślnie pracownika: %s %s".formatted(name, surname));
                    break;

                case 4:
                    company.displayEmployees(true);
                    int employeeDeletionChoice = Utils.indexInput("Podaj id pracownika do usunięcia:", company.getEmployees().size(), true);
                    if (employeeDeletionChoice == 0) {
                        break;
                    }
                    company.removeEmployee(company.getEmployee(employeeDeletionChoice -1));
                    break;

                case 5:
                    company.displayEmployees(true);
                    int employeeModificationChoice = Utils.indexInput("Podaj id pracownika do zmiany:", company.getEmployees().size(), true);
                    if (employeeModificationChoice == 0) {
                        break;
                    }

                    Employee employeeToModify = company.getEmployee(employeeModificationChoice -1);
                    System.out.println("Dostępne operacje:");
                    System.out.println("1 - Zmień imię");
                    System.out.println("2 - Zmień nazwisko");
                    System.out.println("3 - Zmień adres");
                    System.out.println("4 - Zmień dział");
                    System.out.println();

                    int employeeModificationAction = Utils.inputInt("Wybierz operację: ");

                    switch (employeeModificationAction) {
                        case 1:
                            String newName = Utils.inputString("Podaj nowe imię: ");
                            employeeToModify.setName(newName);
                            break;
                        case 2:
                            String newSurname = Utils.inputString("Podaj nazwisko: ");
                            employeeToModify.setSurname(newSurname);
                            break;
                        case 3:
                            Address newAddress = Utils.addressInput();
                            employeeToModify.setAddress(newAddress);
                            break;
                        case 4:
                            System.out.println("Wybierz numer działu:");
                            Departament[] departamentList = Departament.values();
                            int numeration = 1;
                            for (Departament departament : departamentList) {
                                System.out.println(numeration + " - " + departament);
                                numeration++;
                            }
                            int departmentSelectionChoice = Utils.inputInt("Numer działu: ");
                            Departament selectedDepartment = departamentList[departmentSelectionChoice - 1];
                            employeeToModify.setDepartament(selectedDepartment);
                            break;
                        default:
                            Utils.printAnswer("Błędny wybór, powrót do menu głównego");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Dostępne operacje:");
                    System.out.println("1 - Zmień nazwę");
                    System.out.println("2 - Zmień adres");
                    int companyModificationChoice = Utils.inputInt("Wybierz operację: ");

                    if (companyModificationChoice == 1) {
                        String newCompanyName = Utils.inputString("Podaj nazwisko: ");
                        company.setName(newCompanyName);
                    } else if (companyModificationChoice == 2) {
                        Address newAddress = Utils.addressInput();
                        company.setAddress(newAddress);
                    } else {
                        Utils.printAnswer("Błędny wybór, powrót do menu głównego");
                    }
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
