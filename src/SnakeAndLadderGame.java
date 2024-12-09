import java.util.Random;

public class SnakeAndLadderGame {

    static final int WINNING_POSITION = 100;
    static final int NUM_PLAYERS = 2;

    public static int rollDie() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public static int checkOption() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public static void main(String[] args) {
        // Player positions and dice roll count
        int[] playerPositions = new int[NUM_PLAYERS];
        int[] rollCounts = new int[NUM_PLAYERS];

        for (int i = 0; i < NUM_PLAYERS; i++) {
            playerPositions[i] = 0;
            rollCounts[i] = 0;
        }

        while (true) {
            for (int player = 0; player < NUM_PLAYERS; player++) {
                System.out.println("Player " + (player + 1) + "'s turn:");

                int dieRoll = rollDie();
                rollCounts[player]++;
                System.out.println("Rolled a " + dieRoll);

                int option = checkOption();

                if (option == 0) {
                    System.out.println("No Play! Stay at the same position.");
                } else if (option == 1) {
                    playerPositions[player] += dieRoll;
                    System.out.println("Ladder! Move ahead by " + dieRoll);
                } else if (option == 2) {
                    playerPositions[player] -= dieRoll;
                    System.out.println("Snake! Move back by " + dieRoll);
                }

                if (playerPositions[player] < 0) {
                    playerPositions[player] = 0;
                    System.out.println("Player " + (player + 1) + " went below 0! Reset to 0.");
                }

                if (playerPositions[player] > WINNING_POSITION) {
                    playerPositions[player] -= dieRoll;
                    System.out.println("Player " + (player + 1) + " went above 100! Stay at the same position.");
                }

                System.out.println("Player " + (player + 1) + " is at position " + playerPositions[player]);

                if (playerPositions[player] == WINNING_POSITION) {
                    System.out.println("Player " + (player + 1) + " wins!");
                    System.out.println("Total dice rolls: " + rollCounts[player]);
                    System.out.println("Game Over!");
                    return;
                }
            }
        }
    }
}
