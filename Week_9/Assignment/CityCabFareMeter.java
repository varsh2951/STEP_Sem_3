package Week_9.Assignment;

import java.util.Scanner;

interface NightServiceCapable {}

abstract class Cab {
    protected String type;
    protected double ratePerKm;

    public Cab(String type, double ratePerKm) {
        this.type = type;
        this.ratePerKm = ratePerKm;
    }

    public String getType() {
        return type;
    }
    public double calculateBaseFare(double km) {
        return Math.max(km * ratePerKm, 100.0);
    }
}

class MiniCab extends Cab {
    public MiniCab() {
        super("MINI", 10.0);
    }
}

class SedanCab extends Cab implements NightServiceCapable {
    public SedanCab() {
        super("SEDAN", 14.0);
    }
}

class SuvCab extends Cab implements NightServiceCapable {
    public SuvCab() {
        super("SUV", 18.0);
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        double totalFare = 0;

        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;
            if (cabType.equals("MINI")) {
                cab = new MiniCab();
            } else if (cabType.equals("SEDAN")) {
                cab = new SedanCab();
            } else if (cabType.equals("SUV")) {
                cab = new SuvCab();
            }

            if (time.equals("NIGHT") && !(cab instanceof NightServiceCapable)) {
                System.out.println(cab.getType() + ": night service not available");
            } else {
                double fare = cab.calculateBaseFare(km);
                if (time.equals("NIGHT")) {
                    fare *= 1.20;
                }
                totalFare += fare;
                System.out.printf("%s: %.2f\n", cab.getType(), fare);
            }
        }

        System.out.printf("Total: %.2f\n", totalFare);
        sc.close();
    }
}