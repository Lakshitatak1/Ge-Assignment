import java.util.Scanner;

public class HarmonicNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a value for N: ");
        int N = scanner.nextInt();

        if (N == 0) {
            System.out.println("N cannot be zero.");
            return;
        }

        double harmonicValue = 0.0;
        for (int i = 1; i <= N; i++) {
            harmonicValue += 1.0 / i;
        }

        System.out.println("The " + N + "th Harmonic Value is: " + harmonicValue);
    }
}
