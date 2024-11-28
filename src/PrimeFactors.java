import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to find its prime factors: ");
        int N = scanner.nextInt();

        if (N <= 1) {
            System.out.println("Prime factorization is not possible for numbers less than or equal to 1.");
            return;
        }

        System.out.print("Prime factors of " + N + " are: ");
        printPrimeFactors(N);
    }

    public static void printPrimeFactors(int N) {
        while (N % 2 == 0) {
            System.out.print(2 + " ");
            N /= 2;
        }

        for (int i = 3; i * i <= N; i += 2) {
            while (N % i == 0) {
                System.out.print(i + " ");
                N /= i;
            }
        }

        if (N > 2) {
            System.out.print(N + " ");
        }

        System.out.println();
    }
}
