package Week_10.Practice;

public class EvenOddCounter {
    public static void main(String[] args) {
        int[] numbers = {3, 8, 12, 5, 7, 10};
        int evenCount = 0;
        int oddCount = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}