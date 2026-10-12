public class Employee {
    private int id=0;
    private String name;
    private int salary=0;
    public Employee() {
        id = 0;
        name = "Unknown";
        salary = 0;
    }
    public Employee(String name) {
        id = 0;
        this.name = name;
        salary = 0;
    }
    public Employee(String name, int salary) {
        id = 0;
        this.name = name;
        this.salary = salary;
    }
    int calc() {
        return salary * 12;
    }
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Annual: " +calc());
        System.out.println();
    }

    public static void main(String[] args) {

        Employee e1 = new Employee();
        Employee e2 = new Employee("Anita");
        Employee e3 = new Employee("Ravi", 50000);

        e1.display();
        e2.display();
        e3.display();
    }
}