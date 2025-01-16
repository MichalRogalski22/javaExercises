package App;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utils {
    static Company initData() {
        Person firstPerson = new Person("Jan", "Testowy");
        Person secondPerson = new Person("Kazimierz", "Przykładowy");
        Person thirdPerson = new Person("Maria", "Demo");

        Employee firstEmployee = new Employee(firstPerson, Departament.SALES);
        Employee secondEmployee = new Employee(secondPerson, Departament.ADMINISTRATION);
        Employee thirdEmployee = new Employee(thirdPerson, Departament.FINANCE);

        Company company = new Company("Super Firma");

        List<Employee> employees = company.getEmployees();
        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(thirdEmployee);

        return company;
    }

    static void printBanner(String text) {
        String border = "+" + "-".repeat(text.length() + 2) + "+";
        System.out.println(border);
        System.out.println("| " + text + " |");
        System.out.println(border);
    }

    static void printAnswer(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    static int inputInt(String message) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print(message);
            return input.nextInt();
        } catch (InputMismatchException e) {
            printAnswer("Podano błędną wartość, spróbuj jeszcze raz");
            return inputInt(message);
        }
    }

    static String inputString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }
}
