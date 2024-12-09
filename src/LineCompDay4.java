import java.util.Scanner;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class LineCompDay4 implements Comparable<LineCompDay4> {
    Point point1, point2;

    LineCompDay4(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double calculateLength() {
        return Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LineCompDay4 other = (LineCompDay4) obj;
        return this.calculateLength() == other.calculateLength();
    }

    @Override
    public int compareTo(LineCompDay4 other) {
        if (this.calculateLength() > other.calculateLength()) return 1;
        if (this.calculateLength() < other.calculateLength()) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Line Comparison Computation Program");

        System.out.println("Enter coordinates for point 1 of line 1 (x1 y1): ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        Point point1Line1 = new Point(x1, y1);

        System.out.println("Enter coordinates for point 2 of line 1 (x2 y2): ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        Point point2Line1 = new Point(x2, y2);

        System.out.println("Enter coordinates for point 1 of line 2 (x1 y1): ");
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        Point point1Line2 = new Point(x3, y3);

        System.out.println("Enter coordinates for point 2 of line 2 (x2 y2): ");
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();
        Point point2Line2 = new Point(x4, y4);

        LineCompDay4 line1 = new LineCompDay4(point1Line1, point2Line1);
        LineCompDay4 line2 = new LineCompDay4(point1Line2, point2Line2);

        System.out.println("Length of Line 1: " + line1.calculateLength());
        System.out.println("Length of Line 2: " + line2.calculateLength());

        if (line1.equals(line2)) {
            System.out.println("Both lines are equal.");
        } else {
            System.out.println("Both lines are not equal.");
        }

        int comparison = line1.compareTo(line2);
        if (comparison > 0) {
            System.out.println("Line 1 is greater than Line 2.");
        } else if (comparison < 0) {
            System.out.println("Line 1 is less than Line 2.");
        } else {
            System.out.println("Both lines are equal.");
        }

        scanner.close();
    }
}
