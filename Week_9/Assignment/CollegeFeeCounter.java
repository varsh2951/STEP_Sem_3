package Week_9.Assignment;

import java.util.Scanner;

interface BusUser {}

abstract class CollegeStudent {
    protected String name;
    protected static final double TRANSPORT_FEE = 12000.0;

    public CollegeStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBaseFee();

    public double getTotalFee() {
        double fee = calculateBaseFee();
        if (this instanceof BusUser) {
            fee += TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholar extends CollegeStudent implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0;
    }
}

class Hosteller extends CollegeStudent {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends CollegeStudent implements BusUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 20000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        CollegeStudent[] students = new CollegeStudent[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else if (type.equals("SCHOLAR")) {
                students[i] = new ScholarshipStudent(name);
            }
        }

        double totalCollected = 0;
        for (CollegeStudent s : students) {
            double fee = s.getTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", s.getName(), fee);
        }

        System.out.printf("Total Collected: %.2f\n", totalCollected);
        sc.close();
    }
}