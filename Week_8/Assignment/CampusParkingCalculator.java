package Week_8.Assignment;
import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        if (hours <= 0) return 0;
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0);
    }
}

public class CampusParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[n];
        String[] vehicleTypes = new String[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            vehicleTypes[i] = type;

            if (type.equals("BIKE")) {
                vehicles[i] = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicles[i] = new Car(hours);
            } else if (type.equals("TRUCK")) {
                vehicles[i] = new Truck(hours);
            }
        }

        System.out.println("\nParking Summary:\n");
        for (int i = 0; i < n; i++) {
            double charge = vehicles[i].calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f\n", vehicleTypes[i], charge);
        }

        System.out.printf("\nTotal: %.2f\n", grandTotal);
        sc.close();
    }
}