package Week_11.Assignment;

import java.util.Arrays;

public class LibraryBookShelf {

    public static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int currentBook = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > currentBook) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = currentBook;

            System.out.println("After placing " + currentBook + ": " + Arrays.toString(books));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        shelf(new int[]{30, 10, 40, 20});

        shelf(new int[]{25, 15, 5, 35, 20});
    }
}