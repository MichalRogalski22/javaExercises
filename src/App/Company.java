package App;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private Address address;
    private final List<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.address = new Address("Miasto", "Ulica");
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(int index) {
        return employees.get(index);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void addEmployee(String name, String surname, Address address) {
        Person person = new Person(name, surname, address);
        Employee employee = new Employee(person, Departament.ADMINISTRATION);

        employees.add(employee);
    }

    public void displayEmployees(Boolean withNumeration) {
        int numeration = 1;

        List<Employee> employees = this.employees;
        for(Employee employee : employees) {
            String emplyeeString = employee.toString();
            if(withNumeration) {
                String numerationString = numeration + " - ";

                emplyeeString = numerationString + emplyeeString;
                numeration++;
            }
            System.out.println(emplyeeString);
        }
    }

}
