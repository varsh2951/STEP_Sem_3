package Week_11.Assignment;

import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int v : rolls) {
            count[v]++;
        }

        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + (v < 6 ? " " : ""));
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {

        int[] sorted1 = diceSort(new int[]{4, 1, 6, 4, 2, 1, 4});
        System.out.println("Sorted: " + Arrays.toString(sorted1) + "\n");

        int[] sorted2 = diceSort(new int[]{6, 5, 3, 5, 2, 6});
        System.out.println("Sorted: " + Arrays.toString(sorted2));
    }
}