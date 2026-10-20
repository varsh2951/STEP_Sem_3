public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        // Iterate through each character in the string
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            boolean isRepeating = false;

            // Compare currentChar with every other character in the string
            for (int j = 0; j < text.length(); j++) {
                if (i != j && currentChar == text.charAt(j)) {
                    isRepeating = true;
                    break; // Duplicate found, stop checking this character
                }
            }

            // If no match was found elsewhere, this is the first non-repeating character
            if (!isRepeating) {
                return currentChar;
            }
        }

        return '\0'; // Return null character if no non-repeating character exists
    }

    public static void test(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("Input: \"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("Input: \"" + text + "\" -> No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        test("swiss");
        test("aabbcc");
    }
}