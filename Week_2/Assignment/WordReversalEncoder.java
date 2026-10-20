package Week_2.Assignment;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordSb = new StringBuilder(words[i]);
            result.append(wordSb.reverse());

            // Add space between words
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String sentence = "hello club";
        String reversed = reverseEachWord(sentence);
        System.out.println(reversed);
    }
}
