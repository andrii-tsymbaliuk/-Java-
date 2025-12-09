package Lab7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// =======================
//   КЛАСС Працівник
// =======================
class Employee {
    private String name;
    private String surname;
    private double salary;

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (salary = " + salary + ")";
    }
}

// =======================
//        Відділ
// =======================
class Department {
    private String name;
    private Employee chief;
    private List<Employee> employees = new ArrayList<>();

    public Department(String name, Employee chief) {
        this.name = name;
        this.chief = chief;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public Employee getChief() {
        return chief;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department: " + name;
    }
}

// =======================
//         Фірма
// =======================
class Firm {
    private String name;
    private Employee director;
    private List<Department> departments = new ArrayList<>();

    public Firm(String name, Employee director) {
        this.name = name;
        this.director = director;
    }

    public void addDepartment(Department d) {
        departments.add(d);
    }

    public Employee getDirector() {
        return director;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

// =======================
//         MAIN
// =======================
public class Main {

    // ---------------------------------------------------------
    // ЗАДАЧА 1 — foreach (типізований цикл) — варіант вимагає "c"
    // ---------------------------------------------------------
    public static double findMaxSalary(Firm firm) {
        double max = firm.getDirector().getSalary();

        for (Department d : firm.getDepartments()) {

            if (d.getChief().getSalary() > max)
                max = d.getChief().getSalary();

            for (Employee e : d.getEmployees()) {
                if (e.getSalary() > max)
                    max = e.getSalary();
            }
        }
        return max;
    }

    // ---------------------------------------------------------
    // ЗАДАЧА 2 — нетипізований Iterator — варіант вимагає "a"
    // ---------------------------------------------------------
    public static List<Department> findDepartmentsWhereEmployeeEarnsMore(Firm firm) {
        List<Department> result = new ArrayList<>();

        Iterator it = firm.getDepartments().iterator();  // нетипізований ітератор

        while (it.hasNext()) {
            Department d = (Department) it.next();
            double chiefSalary = d.getChief().getSalary();

            for (Object obj : d.getEmployees()) {
                Employee e = (Employee) obj;

                if (e.getSalary() > chiefSalary) {
                    result.add(d);
                    break;
                }
            }
        }

        return result;
    }

    // ---------------------------------------------------------
    // ЗАДАЧА 3 — типізований Iterator — варіант вимагає "b"
    // ---------------------------------------------------------
    public static List<Employee> listAllEmployees(Firm firm) {
        List<Employee> list = new ArrayList<>();

        list.add(firm.getDirector());

        Iterator<Department> it = firm.getDepartments().iterator(); // типізований

        while (it.hasNext()) {
            Department d = it.next();

            list.add(d.getChief());

            Iterator<Employee> it2 = d.getEmployees().iterator(); // типізований
            while (it2.hasNext()) {
                list.add(it2.next());
            }
        }

        return list;
    }

    // ===========================
    //     ТЕСТОВИЙ MAIN
    // ===========================
    public static void main(String[] args) {

        Employee director = new Employee("Ivan", "Ivanov", 30000);
        Firm firm = new Firm("TechCorp", director);

        Department d1 = new Department("IT", new Employee("Petro", "Petrov", 20000));
        d1.addEmployee(new Employee("Andriy", "Koval", 15000));
        d1.addEmployee(new Employee("Oleh", "Tymoshenko", 25000));

        Department d2 = new Department("HR", new Employee("Olena", "Shevchenko", 18000));
        d2.addEmployee(new Employee("Iryna", "Bondarenko", 17000));

        firm.addDepartment(d1);
        firm.addDepartment(d2);

        System.out.println("Max salary = " + findMaxSalary(firm));

        System.out.println("Departments where employee earns more than chief:");
        System.out.println(findDepartmentsWhereEmployeeEarnsMore(firm));

        System.out.println("All employees:");
        System.out.println(listAllEmployees(firm));
    }
}
