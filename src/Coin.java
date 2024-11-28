import java.util.Random;
import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of times to flip the coin: ");
        int numFlips = scanner.nextInt();

        if (numFlips <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        int headsCount = 0;
        int tailsCount = 0;

        Random random = new Random();

        for (int i = 0; i < numFlips; i++) {
            double flip = random.nextDouble();

            if (flip < 0.5) {
                headsCount++;
            } else {
                tailsCount++;
            }
        }

        double headPercentage = (double) headsCount / numFlips * 100;
        double tailPercentage = (double) tailsCount / numFlips * 100;

        System.out.println("Heads: " + headsCount + " (" + headPercentage + "%)");
        System.out.println("Tails: " + tailsCount + " (" + tailPercentage + "%)");
    }
}
