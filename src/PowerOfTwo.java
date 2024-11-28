public class PowerOfTwo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a single command-line argument (0 <= N < 31).");
            return;
        }
        int N = Integer.parseInt(args[0]);

        if (N < 0 || N >= 31) {
            System.out.println("The value of N must be between 0 and 30 (inclusive).");
            return;
        }

        System.out.println("Power of 2 Table:");
        for (int i = 0; i <= N; i++) {
            System.out.println("2^" + i + " = " + (int) Math.pow(2, i));
        }
    }
}
