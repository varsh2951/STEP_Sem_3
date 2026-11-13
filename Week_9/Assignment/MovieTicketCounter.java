package Week_9.Assignment;

import java.util.Scanner;

abstract class Ticket {
    protected String seatType;
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    public abstract double getTicketPrice();

    public double calculateTotal() {
        return count * (getTicketPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getTicketPrice() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getTicketPrice() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getTicketPrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Ticket[] bookings = new Ticket[n];
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            if (seat.equals("REGULAR")) {
                bookings[i] = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                bookings[i] = new PremiumTicket(count);
            } else if (seat.equals("RECLINER")) {
                bookings[i] = new ReclinerTicket(count);
            }
        }

        double grandTotal = 0;
        for (Ticket t : bookings) {
            double amount = t.calculateTotal();
            grandTotal += amount;
            System.out.printf("%s: %.2f\n", t.getSeatType(), amount);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}