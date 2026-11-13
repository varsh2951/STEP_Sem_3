package Week_8.Practice;

import java.util.Scanner;

abstract class Question {
    protected String type;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String type, String correctAnswer, String studentAnswer, int points) {
        this.type = type;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public abstract double grade();
}

class MCQQuestion extends Question {
    public MCQQuestion(String correctAnswer, String studentAnswer, int points) {
        super("MCQ", correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String correctAnswer, String studentAnswer, int points) {
        super("TF", correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String correctAnswer, String studentAnswer, int points) {
        super("ESSAY", correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        String lowerStudentAns = studentAnswer.toLowerCase();
        int matchCount = 0;

        for (String kw : keywords) {
            if (lowerStudentAns.contains(kw.trim().toLowerCase())) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class ExamQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Question[] questions = new Question[n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            int firstQuote = line.indexOf('"');
            String type = line.substring(0, firstQuote).trim();
            String[] parts = line.substring(firstQuote).split("\"");
            
            String correctAns = parts[3];
            String studentAns = parts[5];
            int points = Integer.parseInt(parts[6].trim());

            if (type.equals("MCQ")) {
                questions[i] = new MCQQuestion(correctAns, studentAns, points);
            } else if (type.equals("TF")) {
                questions[i] = new TFQuestion(correctAns, studentAns, points);
            } else if (type.equals("ESSAY")) {
                questions[i] = new EssayQuestion(correctAns, studentAns, points);
            }
        }

        double totalScore = 0;
        for (Question q : questions) {
            double score = q.grade();
            totalScore += score;
            System.out.printf("%s: %.2f\n", q.getType(), score);
        }

        System.out.printf("Total Score: %.2f\n", totalScore);
        sc.close();
    }
}