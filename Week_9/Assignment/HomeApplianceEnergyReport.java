package Week_9.Assignment;

import java.util.Scanner;

interface EnergySaver {}

abstract class Appliance {
    protected String name;
    protected double powerWatts;

    public Appliance(String name, double powerWatts) {
        this.name = name;
        this.powerWatts = powerWatts;
    }

    public String getName() {
        return name;
    }

    public double calculateUnits(double hours, boolean saverMode) {
        double units = (powerWatts * hours) / 1000.0;
        if (saverMode) {
            units *= 0.75;
        }
        return units;
    }
}

class Fridge extends Appliance {
    public Fridge() {
        super("FRIDGE", 150.0);
    }
}

class AirConditioner extends Appliance implements EnergySaver {
    public AirConditioner() {
        super("AC", 1500.0);
    }
}

class Television extends Appliance {
    public Television() {
        super("TV", 100.0);
    }
}

class WashingMachine extends Appliance implements EnergySaver {
    public WashingMachine() {
        super("WASHER", 500.0);
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean saverRequested = tokens.length > 2 && tokens[2].equals("SAVER");

            Appliance app = null;
            if (type.equals("FRIDGE")) {
                app = new Fridge();
            } else if (type.equals("AC")) {
                app = new AirConditioner();
            } else if (type.equals("TV")) {
                app = new Television();
            } else if (type.equals("WASHER")) {
                app = new WashingMachine();
            }

            if (saverRequested && !(app instanceof EnergySaver)) {
                System.out.println(app.getName() + ": saver mode not supported");
            } else {
                double units = app.calculateUnits(hours, saverRequested);
                double cost = units * 8.0;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", app.getName(), units, cost);
            }
        }

        System.out.printf("Total Cost: %.2f\n", totalCost);
        sc.close();
    }
}