import java.util.Scanner;

public class NameTag {
    private final String nickname;

    public NameTag(String fullName) {
        String[] parts = fullName.trim().split(" ");
        String firstName = parts[0];
        String lastName = parts[1];
        this.nickname = firstName + " " + lastName.charAt(0) + ".";
    }

    public String getNickname() {
        return nickname;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter full name (First Last): ");
        String fullName = scanner.nextLine();

        NameTag tag = new NameTag(fullName);
        System.out.println("Generated Nickname: " + tag.getNickname());

        scanner.close();
    }
}