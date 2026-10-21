package Week_6.Assignment;
public class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        // Step 1: Create original object
        HallTicket priya = new HallTicket("Priya", 0);

        // Step 2: Assign second variable to point to the same object
        HallTicket copy = priya;

        // Step 3: Change seat number through second variable
        copy.seatNumber = 45;

        // Step 4: Print value seen through first variable & check equality
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        // Step 5: Create a third separate object with identical values
        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}