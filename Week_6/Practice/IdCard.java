package Week_6.Practice;
public class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        // Step 1: Create original object
        IdCard ravi = new IdCard("Ravi", 0);

        // Step 2: Assign second variable to point at the same object
        IdCard duplicate = ravi;

        // Step 3: Change booksIssued through second variable
        duplicate.booksIssued = 3;

        // Step 4: Print field value via first variable and reference comparison
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Step 5: Create third separate object with identical values
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}