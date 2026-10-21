package Week_8.Assignment;
import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class AcRoom extends Room {
    public AcRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Room[] rooms = new Room[n];
        String[] roomTypes = new String[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            roomTypes[i] = type;

            if (type.equals("SINGLE")) {
                int units = sc.nextInt();
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int units = sc.nextInt();
                int occupants = sc.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                int units = sc.nextInt();
                rooms[i] = new AcRoom(units);
            }
        }

        System.out.println("\nElectricity Bill Summary:\n");
        for (int i = 0; i < n; i++) {
            double bill = rooms[i].calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", roomTypes[i], bill);
        }

        System.out.printf("\nTotal: %.2f\n", grandTotal);
        sc.close();
    }
}