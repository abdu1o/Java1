import java.util.*;

public class ArrayCalculator {
    public static void processCustomArray() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the array creation method:");
        System.out.println("1) Random generator");
        System.out.println("2) Input manually [1,3,4,5...]");
        int choice = scanner.nextInt();

        int[][] array;
        if (choice == 1) {
            array = setRandomArray(scanner);
        } else if (choice == 2) {
            array = setArrayManually(scanner);
        } else {
            System.out.println("Error choice");
            return;
        }

        System.out.println("\n2D array:");
        print2DArray(array);

        double[] ratios = calculateZeros(array);

        System.out.println("\nResulting 1D array of ratios:");
        System.out.println(Arrays.toString(ratios));
    }

    public static int[][] setRandomArray(Scanner scanner) {
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the max number of elements in each row: ");
        int cols = scanner.nextInt();
        System.out.print("Enter the range for random numbers: ");
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        Random random = new Random();
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return array;
    }

    public static int[][] setArrayManually(Scanner scanner) {
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        scanner.nextLine();
        int[][] array = new int[rows][];
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter row [1,2,3,4...]");

            String[] parts = scanner.nextLine().split(",");
            array[i] = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                array[i][j] = Integer.parseInt(parts[j].trim());
            }
        }
        return array;
    }

    public static double[] calculateZeros(int[][] array) {
        double[] ratios = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            int zeroCount = 0;
            int nonZeroCount = 0;
            for (int num : array[i]) {
                if (num == 0) {
                    zeroCount++;
                }
                else {
                    nonZeroCount++;
                }
            }
            ratios[i] = (nonZeroCount == 0) ? 0 : (double) zeroCount / nonZeroCount;
        }
        return ratios;
    }

    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }


    public static void processRandomArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        System.out.print("Enter range for random numbers: ");
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        int[] array = generateRandomArray(size, min, max);
        System.out.println("Original array: " + Arrays.toString(array));

        int[][] result = create2DArrayFrom1D(array);

        System.out.println("\n2D array:");
        print2DArray(result);
    }

    private static int[] generateRandomArray(int size, int min, int max) {

        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    private static int[][] create2DArrayFrom1D(int[] array) {

        int evenCount = 0, oddCount = 0, negativeCount = 0, positiveCount = 0;
        for (int num : array) {
            if (num % 2 == 0) evenCount++;
            else oddCount++;

            if (num < 0) negativeCount++;
            else if (num > 0) positiveCount++;
        }

        int[] evens = new int[evenCount];
        int[] odds = new int[oddCount];
        int[] negatives = new int[negativeCount];
        int[] positives = new int[positiveCount];

        evenCount = oddCount = negativeCount = positiveCount = 0;
        for (int num : array) {
            if (num % 2 == 0) evens[evenCount++] = num;
            else odds[oddCount++] = num;

            if (num < 0) negatives[negativeCount++] = num;
            else if (num > 0) positives[positiveCount++] = num;
        }

        return new int[][]{evens, odds, negatives, positives};
    }
}
