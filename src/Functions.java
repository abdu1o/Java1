import java.util.Scanner;
import java.util.Random;

public class Functions {
    public static void processArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.println("Error: array must be > 1");
            return;
        }

        int[] array = new int[n];
        System.out.println("Enter array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }

        int start = Math.min(minIndex, maxIndex);
        int end = Math.max(minIndex, maxIndex);

        for (int i = start + 1; i < end; i++) {
            array[i] *= 2;
        }

        System.out.println("Modified array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    public static void combineNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        int num1 = scanner.nextInt();

        System.out.println("Enter the second number:");
        int num2 = scanner.nextInt();

        System.out.println("Enter the third number:");
        int num3 = scanner.nextInt();

        String combinedNumber= "" + num1 + num2 + num3;
        System.out.println("Combined number: " + combinedNumber);

        scanner.close();
    }

    public static void calculatePercentage() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter value:");
        float value = scanner.nextInt();

        System.out.println("Enter percentage:");
        float percentage = scanner.nextInt();

        float result = value * (percentage / 100);
        System.out.println("Percentage number: " + result);

        scanner.close();
    }

    public static void swapNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a six-digit number:");
        String input = scanner.nextLine();

        if (input.length() != 6 || !input.matches("\\d+")) {
            System.out.println("Error: enter a six-digit number");
        }
        else {
            char[] digits = input.toCharArray();

            char temp = digits[0];
            digits[0] = digits[5];
            digits[5] = temp;

            temp = digits[1];
            digits[1] = digits[4];
            digits[4] = temp;

            String swappedNumber = new String(digits);
            System.out.println("Swapped number: " + swappedNumber);
        }

        scanner.close();
    }

    public static void selectSeason() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter month number (1-12):");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Error: invalid month number");
        } else {
            String season = switch (month) {
                case 12, 1, 2 -> "Winter";
                case 3, 4, 5 -> "Spring";
                case 6, 7, 8 -> "Summer";
                case 9, 10, 11 -> "Autumn";
                default -> "";
            };
            System.out.println(season);
        }

        scanner.close();
    }

    public static void printOddNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter second number: ");
        int num2 = scanner.nextInt();

        int start = Math.min(num1, num2);
        int end = Math.max(num1, num2);

        System.out.println("Odd numbers: ");
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }

    public static void countArrayValues() {
        Random random = new Random();

        int n = 10;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(21) - 10;
        }

        int negativeCount = 0, positiveCount = 0, zeroCount = 0;
        for (int num : array) {
            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }
        }

        System.out.println("Generated array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\n\nNegative count: " + negativeCount);
        System.out.println("Positive count: " + positiveCount);
        System.out.println("Zeros count: " + zeroCount);
    }
}
