import java.util.Random;

public class EmployeeWageComputation {

    static final int FULL_TIME_HOURS = 8;
    static final int PART_TIME_HOURS = 8;
    static final int WAGE_PER_HOUR = 20;
    static final int MAX_WORKING_HOURS = 100;
    static final int MAX_WORKING_DAYS = 20;

    public static void main(String[] args) {
        int totalWorkingHours = 0;
        int totalWorkingDays = 0;
        int totalWage = 0;

        Random random = new Random();

        while (totalWorkingHours < MAX_WORKING_HOURS && totalWorkingDays < MAX_WORKING_DAYS) {
            totalWorkingDays++;

            int attendance = random.nextInt(3);
            int dailyHours = 0;

            switch (attendance) {
                case 1:
                    dailyHours = FULL_TIME_HOURS;
                    System.out.println("Day " + totalWorkingDays + ": Employee is present (Full Time)");
                    break;
                case 2:
                    dailyHours = PART_TIME_HOURS;
                    System.out.println("Day " + totalWorkingDays + ": Employee is present (Part Time)");
                    break;
                default:
                    System.out.println("Day " + totalWorkingDays + ": Employee is absent");
                    continue;
            }

            totalWorkingHours += dailyHours;
            int dailyWage = dailyHours * WAGE_PER_HOUR;
            totalWage += dailyWage;
            System.out.println("Daily wage: $" + dailyWage);
        }

        System.out.println("\nTotal working hours: " + totalWorkingHours);
        System.out.println("Total working days: " + totalWorkingDays);
        System.out.println("Total monthly wage: $" + totalWage);
    }
}
