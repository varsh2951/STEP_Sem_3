import java.util.Scanner;

public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxCapacity) {
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    public void markPresent(String studentName) {
        if (isPresent(studentName)) {
            System.out.println(studentName + " is already marked present.");
            return;
        }
        if (count < presentStudents.length) {
            presentStudents[count] = studentName;
            count++;
            System.out.println(studentName + " marked present.");
        } else {
            System.out.println("Class capacity reached.");
        }
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter maximum class capacity: ");
        int capacity = scanner.nextInt();

        AttendanceSheet sheet = new AttendanceSheet(capacity);

        System.out.print("How many entries do you want to add? ");
        int entriesCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= entriesCount; i++) {
            System.out.print("Enter student name #" + i + ": ");
            String name = scanner.nextLine();
            sheet.markPresent(name);
        }

        System.out.println("\nTotal students present: " + sheet.getPresentCount());

        System.out.print("Enter name to check attendance: ");
        String searchName = scanner.nextLine();
        
        if (sheet.isPresent(searchName)) {
            System.out.println(searchName + " is present.");
        } else {
            System.out.println(searchName + " is absent.");
        }

        scanner.close();
    }
}