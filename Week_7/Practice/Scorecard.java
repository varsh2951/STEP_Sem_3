import java.util.Scanner;
public class Scorecard {
    private final boolean[] results;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < results.length) {
            results[recordedCount] = isCorrect;
            recordedCount++;
        } else {
            System.out.println("Cannot record more answers. Question limit reached.");
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total number of questions: ");
        int totalQuestions = scanner.nextInt();
        Scorecard scorecard = new Scorecard(totalQuestions);

        for (int i = 1; i <= totalQuestions; i++) {
            System.out.print("Was answer " + i + " correct? (true/false): ");
            boolean result = scanner.nextBoolean();
            scorecard.recordAnswer(result);
        }

        System.out.println("Final Score: " + scorecard.getScore() + " / " + totalQuestions);
        scanner.close();
    }
}