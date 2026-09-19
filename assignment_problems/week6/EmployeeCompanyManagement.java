package week6;
class Employeee {

    // Instance fields
    String empName;
    double salary;

    // Static fields
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    Employeee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        // Increase count whenever an object is created
        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyManagement {

    public static void main(String[] args) {

        // Create three Employee objects
        Employee employee1 =
                new Employee("Arjun", "50000");

        Employee employee2 =
                new Employee("Ravi", "60000)");

        Employee employee3 =
                new Employee("Priya", "55000");

        System.out.println("3 Employee objects created");
        System.out.println();

        // Call static method using class name
        Employeee.printCompanyInfo();
    }
}