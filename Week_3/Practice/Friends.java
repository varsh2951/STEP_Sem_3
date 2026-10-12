import java.util.Scanner;

public class Friends {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of friends: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] school = new String[n];
        String[] college = new String[n];
        String[] nativeA = new String[n];

        int schoolCount = 0;
        int collegeCount = 0;
        int nativeACount = 0;

        for (int i = 0; i < n; i++) {

            System.out.print("Enter friend name and category: ");
            String input = sc.nextLine();

            if (input.endsWith("School")) {
                school[schoolCount] = input.replace(" School", "");
                schoolCount++;
            }
            else if (input.endsWith("College")) {
                college[collegeCount] = input.replace(" College", "");
                collegeCount++;
            }
            else if (input.endsWith("Native")) {
                nativeA[nativeACount] = input.replace(" Native", "");
                nativeACount++;
            }
            else {
                System.out.println("Invalid category!");
            }
        }

        System.out.println("\n--- School Friends ---");
        for (int i = 0; i < schoolCount; i++) {
            System.out.println(school[i]);
        }

        System.out.println("\n--- College Friends ---");
        for (int i = 0; i < collegeCount; i++) {
            System.out.println(college[i]);
        }

        System.out.println("\n--- Native Area Friends ---");
        for (int i = 0; i < nativeACount; i++) {
            System.out.println(nativeA  [i]);
        }
        sc.close();
    }
}