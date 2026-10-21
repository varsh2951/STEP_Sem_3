package Week_6.Assignment;
public class CompanyEmployee {
    String empName;
    double salary;

    // Shared static fields
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increment count on every instantiation
    }

    // Static method referencing only static fields
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee emp1 = new CompanyEmployee("Alice", 50000);
        CompanyEmployee emp2 = new CompanyEmployee("Bob", 60000);
        CompanyEmployee emp3 = new CompanyEmployee("Charlie", 55000);

        // Called directly through class name
        CompanyEmployee.printCompanyInfo();
    }
}