package Week_8.Practice;

import java.util.Scanner;

abstract class Payment {
    protected String type;
    protected double amount;

    public Payment(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFinalAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super("CARD", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02; // 2% processing fee
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super("WALLET", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01; // 1% processing fee
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super("BANKTRANSFER", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount; // No processing fee
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Payment[] payments = new Payment[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } else if (type.equals("BANKTRANSFER")) {
                payments[i] = new BankTransferPayment(amount);
            }
        }

        double grandTotal = 0;
        for (Payment p : payments) {
            double finalAmt = p.calculateFinalAmount();
            grandTotal += finalAmt;
            System.out.printf("%s: %.2f\n", p.getType(), finalAmt);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}