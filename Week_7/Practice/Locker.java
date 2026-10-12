import java.util.Scanner;

public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            System.out.println("Code changed successfully.");
            return true;
        } else {
            System.out.println("Rejected: Incorrect current code. Code stays the same.");
            return false;
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter locker number: ");
        int lockerNum = scanner.nextInt();
        scanner.nextLine(); // Consume remaining newline character

        System.out.print("Set initial code: ");
        String initialCode = scanner.nextLine();

        Locker locker = new Locker(lockerNum, initialCode);

        System.out.print("\nEnter current code to attempt change: ");
        String currentAttempt = scanner.nextLine();

        System.out.print("Enter new code: ");
        String newCode = scanner.nextLine();

        locker.changeCode(currentAttempt, newCode);

        scanner.close();
    }
}