package Week_5.Assignment;
import java.util.Arrays;

public class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Overloaded rule 1: Established player check by experience alone
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded rule 2: Combined experience and fitness check
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        // Sort descending by batting average
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public static String draftAndRank(Player[] players) {
        // Step 1: Count how many players qualify
        int draftableCount = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftableCount++;
            }
        }

        // Step 2: Collect draftable players into a new array
        Player[] draftable = new Player[draftableCount];
        int index = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable[index++] = p;
            }
        }

        // Step 3: Sort draftable players using Comparable implementation
        Arrays.sort(draftable);

        // Step 4: Build output string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            sb.append(i + 1).append(". ").append(draftable[i].name);
            if (i < draftable.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] lineup = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(lineup));
    }
}