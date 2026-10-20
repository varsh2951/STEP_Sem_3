import java.util.Random;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"}; // Predefined list for demo
        Random random = new Random();

        int wins = 0, losses = 0, draws = 0;
        int N = 5;

        String[][] roundsData = new String[N][4];

        for (int i = 0; i < N; i++) {
            String pMove = playerMoves[i];
            String cMove = moves[random.nextInt(3)];
            String result = playRound(pMove, cMove);

            roundsData[i][0] = String.valueOf(i + 1);
            roundsData[i][1] = pMove;
            roundsData[i][2] = cMove;
            roundsData[i][3] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Round " + (i + 1) + " - Player: " + pMove + ", Computer: " + cMove + " -> " + result);
        }

        // Output Summary Table
        System.out.println("\n--- Round Table ---");
        System.out.printf("%-7s | %-11s | %-13s | %-13s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < N; i++) {
            System.out.printf("%-7s | %-11s | %-13s | %-13s\n", 
                    roundsData[i][0], roundsData[i][1], roundsData[i][2], roundsData[i][3]);
        }

        double winPercentage = ((double) wins / N) * 100;
        System.out.printf("\nFinal Summary (after %d rounds)\n", N);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }
}