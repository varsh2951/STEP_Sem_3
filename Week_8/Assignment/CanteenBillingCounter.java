package Week_8.Assignment;
import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10; // Full amount + 10 service charge
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Customer[] bills = new Customer[n];
        String[] customerTypes = new String[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            customerTypes[i] = type;

            if (type.equals("STUDENT")) {
                bills[i] = new StudentCustomer(amount);
            } else if (type.equals("STAFF")) {
                bills[i] = new StaffCustomer(amount);
            } else if (type.equals("GUEST")) {
                bills[i] = new GuestCustomer(amount);
            }
        }
        System.out.println("\nBill Summary:\n");
        // Polymorphic processing without explicit type checks
        for (int i = 0; i < n; i++) {
            double finalAmount = bills[i].calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", customerTypes[i], finalAmount);
        }

        System.out.printf("\nTotal: %.2f\n", grandTotal);
        sc.close();
    }
}