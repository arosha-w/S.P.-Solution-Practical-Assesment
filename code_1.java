public class problem_1 {
    // Method 1: Using for loop
    public static int sumFor(int[] numbers) {
        int total = 0;

        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }

        return total;
    }
    // Method 2: Using while loop
    public static int sumWhile(int[] numbers) {
        int total = 0;
        int i = 0;

        while (i < numbers.length) {
            total += numbers[i];
            i++;
        }

        return total;
    }
    // Method 3: Using recursion
    public static int sumRecursive(int[] numbers, int index) {

        if (index == numbers.length) {
            return 0;
        }

        return numbers[index] + sumRecursive(numbers, index + 1);
    }

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Using For Loop: " + sumFor(numbers));

        System.out.println("Using While Loop: " + sumWhile(numbers));

        System.out.println("Using Recursion: " + sumRecursive(numbers, 0));
    }
}
