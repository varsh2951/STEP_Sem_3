import java.util.Scanner;

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
            System.out.println("Deposited " + amount + " -> savings = " + this.savings);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > this.savings) {
            System.out.println("Withdrawal of " + amount + " rejected. Insufficient funds, savings stays " + this.savings);
        } else if (amount > 0) {
            this.savings -= amount;
            System.out.println("Withdrew " + amount + " -> savings = " + this.savings);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Piggy Bank ID: ");
        String id = scanner.nextLine();
        PiggyBank pb = new PiggyBank(id);

        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        pb.deposit(depositAmount);

        System.out.print("Enter withdrawal amount: ");
        double withdrawAmount = scanner.nextDouble();
        pb.withdraw(withdrawAmount);

        System.out.println("Final savings balance for " + pb.getId() + ": " + pb.getSavings());
        scanner.close();
    }
}