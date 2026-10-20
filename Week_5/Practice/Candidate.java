package Week_5.Practice;
import java.util.Arrays;

public class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Overloaded rule 1: Direct eligibility based on CGPA alone (e.g., CGPA >= 7.0)
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // Overloaded rule 2: Combined eligibility for borderline CGPA (e.g., CGPA >= 6.5 and codingScore >= 60)
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Composite score formula used for ranking (e.g., CGPA * 10 + Coding Score)
    public double getCompositeScore() {
        return (cgpa * 10.0) + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        // Sort descending by composite score
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        // Step 1: Count eligible candidates
        int count = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                count++;
            }
        }

        // Step 2: Store eligible candidates in a array
        Candidate[] shortlisted = new Candidate[count];
        int index = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted[index++] = c;
            }
        }

        // Step 3: Sort using Comparable implementation
        Arrays.sort(shortlisted);

        // Step 4: Format final display output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append(i + 1).append(". ").append(shortlisted[i].name)
              .append(" (").append(shortlisted[i].getCompositeScore()).append(")");

            if (i < shortlisted.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}