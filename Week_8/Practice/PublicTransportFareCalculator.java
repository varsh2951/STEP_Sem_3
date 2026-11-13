package Week_8.Practice;

import java.util.Scanner;

abstract class Transport {
    protected String type;
    protected double distance;

    public Transport(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFare();
}

class Bus extends Transport {
    public Bus(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
}

class Train extends Transport {
    public Train(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Transport[] journeys = new Transport[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            if (type.equals("BUS")) {
                journeys[i] = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new Train(distance);
            } else if (type.equals("METRO")) {
                double peakFactor = sc.nextDouble();
                journeys[i] = new Metro(distance, peakFactor);
            }
        }

        double grandTotal = 0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f\n", t.getType(), fare);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}