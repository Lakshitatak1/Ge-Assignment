import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Maximum<T extends Comparable<T>> {

    private T first;
    private T second;
    private T third;

    public Maximum(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T testMaximum() {
        return Maximum.testMaximum(first, second, third);
    }

    public static <T extends Comparable<T>> T testMaximum(T first, T second, T third) {
        T max = first;
        if (second.compareTo(max) > 0) {
            max = second;
        }
        if (third.compareTo(max) > 0) {
            max = third;
        }
        return max;
    }

    public static <T extends Comparable<T>> T testMaximum(T... values) {
        List<T> valueList = Arrays.asList(values);
        Collections.sort(valueList);
        return valueList.get(valueList.size() - 1);  // Return the largest element
    }

    public void printMax() {
        System.out.println("Maximum value is: " + testMaximum(first, second, third));
    }

    public static <T extends Comparable<T>> void printMax(T... values) {
        T max = testMaximum(values);
        System.out.println("Maximum value is: " + max);
    }
}

public class MaximumTest {
    public static void main(String[] args) {
        // Test case with Integers
        System.out.println("Testing with Integers:");
        Maximum<Integer> intMax = new Maximum<>(5, 10, 3);
        System.out.println("Maximum of 5, 10, 3: " + intMax.testMaximum());
        Maximum.printMax(5, 10, 3, 9, 1);

        // Test case with Floats
        System.out.println("\nTesting with Floats:");
        Maximum<Float> floatMax = new Maximum<>(2.5f, 3.5f, 1.5f);
        System.out.println("Maximum of 2.5f, 3.5f, 1.5f: " + floatMax.testMaximum());
        Maximum.printMax(2.5f, 3.5f, 1.5f, 4.5f);

        // Test case with Strings
        System.out.println("\nTesting with Strings:");
        Maximum<String> stringMax = new Maximum<>("Apple", "Peach", "Banana");
        System.out.println("Maximum of Apple, Peach, Banana: " + stringMax.testMaximum());
        Maximum.printMax("Apple", "Peach", "Banana", "Grape");

        // Testing with multiple values
        System.out.println("\nTesting with Multiple Values:");
        Maximum.printMax(1, 2, 3, 4, 5, 6, 7);
    }
}
