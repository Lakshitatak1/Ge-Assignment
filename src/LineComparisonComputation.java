import java.lang.Math;

class Line implements Comparable<Line> {
    private double x1, y1, x2, y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double length() {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Line otherLine = (Line) obj;

        return Double.compare(this.length(), otherLine.length()) == 0;
    }

    @Override
    public int compareTo(Line otherLine) {
        return Double.compare(this.length(), otherLine.length());
    }

    public void displayLineDetails() {
        System.out.println("Line from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
        System.out.println("Length of the line: " + length());
    }
}

public class LineComparisonComputation {
    public static void main(String[] args) {

        System.out.println("Welcome to Line Comparison Computation Program on Master Branch");

        Line line1 = new Line(1, 1, 4, 5); // Line 1: from (1,1) to (4,5)
        Line line2 = new Line(2, 2, 5, 6); // Line 2: from (2,2) to (5,6)

        line1.displayLineDetails();
        line2.displayLineDetails();

        if (line1.equals(line2)) {
            System.out.println("The two lines are equal.");
        } else {
            System.out.println("The two lines are not equal.");
        }

        int comparisonResult = line1.compareTo(line2);
        if (comparisonResult < 0) {
            System.out.println("Line 1 is shorter than Line 2.");
        } else if (comparisonResult > 0) {
            System.out.println("Line 1 is longer than Line 2.");
        } else {
            System.out.println("Line 1 is equal to Line 2.");
        }
    }
}
