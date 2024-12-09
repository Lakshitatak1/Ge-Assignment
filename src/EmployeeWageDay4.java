import java.util.Random;

public class EmployeeWageDay4 {

    static final int IS_PRESENT = 1;
    static final int IS_ABSENT = 0;
    static final int FULL_TIME_HOUR = 8;
    static final int PART_TIME_HOUR = 4;
    final int PAY_PER_HOUR = 20;
    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HOURS = 100;

    String employeeName;
    int totalWages;
    int totalWorkingHours;
    int totalWorkingDays;

    public EmployeeWageDay4(String employeeName) {
        this.employeeName = employeeName;
        this.totalWages = 0;
        this.totalWorkingHours = 0;
        this.totalWorkingDays = 0;
    }

    public int checkAttendance() {
        Random rand = new Random();
        return rand.nextInt(2);
    }

    public void calculateDailyWage(int attendance) {
        int dailyHours = 0;
        String attendanceStatus = "";

        switch (attendance) {
            case IS_PRESENT:
                int workType = new Random().nextInt(2);
                if (workType == 0) {
                    dailyHours = FULL_TIME_HOUR;
                    attendanceStatus = "Full-time";
                } else {
                    dailyHours = PART_TIME_HOUR;
                    attendanceStatus = "Part-time";
                }
                break;
            case IS_ABSENT:
                dailyHours = 0;
                attendanceStatus = "Absent";
                break;
            default:
                System.out.println("Invalid attendance value.");
                break;
        }

        int dailyWage = dailyHours * PAY_PER_HOUR;
        totalWages += dailyWage;
        totalWorkingHours += dailyHours;
        totalWorkingDays++;

        System.out.println("Day " + totalWorkingDays + ": " + attendanceStatus + " | Hours Worked: " + dailyHours + " | Daily Wage: " + dailyWage);
    }

    public void calculateMonthlyWage() {
        System.out.println("Calculating wages for " + employeeName + "...\n");

        while (totalWorkingHours < MAX_WORKING_HOURS && totalWorkingDays < MAX_WORKING_DAYS) {
            int attendance = checkAttendance();
            calculateDailyWage(attendance);
        }

        System.out.println("\nTotal Wages for " + employeeName + ": " + totalWages);
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
    }

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to Employee Wage Computation Program!");

        EmployeeWageDay4 employee1 = new EmployeeWageDay4("John Doe");

        employee1.calculateMonthlyWage();
    }
}
