import java.util.Random;
import java.util.Scanner;

class EmployeePayroll {

    public static final int FULL_TIME = 1;
    public static final int PART_TIME = 2;
    public static final int ABSENT = 0;

    public static void computeEmployeeWage(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        int totalWage = 0;
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        Random random = new Random();

        while (totalWorkingDays < maxWorkingDays && totalWorkingHours < maxWorkingHours) {
            totalWorkingDays++;
            int attendance = random.nextInt(3);  // 0 -> Absent, 1 -> Full-time, 2 -> Part-time
            int workingHours = 0;

            switch (attendance) {
                case FULL_TIME:
                    workingHours = 8;  // Full-time employee works 8 hours
                    break;
                case PART_TIME:
                    workingHours = 4;  // Part-time employee works 4 hours
                    break;
                case ABSENT:
                    workingHours = 0;  // Absent, no working hours
                    break;
            }

            totalWorkingHours += workingHours;
            totalWage += workingHours * wagePerHour;
            System.out.println("Day " + totalWorkingDays + " : Worked " + workingHours + " hours. Total wage so far: " + totalWage);
        }

        System.out.println("\nTotal wage for " + company + ": " + totalWage);
        System.out.println("Total days worked: " + totalWorkingDays);
        System.out.println("Total hours worked: " + totalWorkingHours);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Employee Wage Computation Program");

        System.out.print("Enter the number of companies: ");
        int numOfCompanies = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 0; i < numOfCompanies; i++) {
            System.out.println("\nEnter details for Company " + (i + 1));

            System.out.print("Enter company name: ");
            String company = scanner.nextLine();

            System.out.print("Enter wage per hour for " + company + ": ");
            int wagePerHour = scanner.nextInt();

            System.out.print("Enter max working days for " + company + ": ");
            int maxWorkingDays = scanner.nextInt();

            System.out.print("Enter max working hours per month for " + company + ": ");
            int maxWorkingHours = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            computeEmployeeWage(company, wagePerHour, maxWorkingDays, maxWorkingHours);
        }

        scanner.close();
    }
}
