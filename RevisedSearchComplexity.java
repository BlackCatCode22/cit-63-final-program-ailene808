import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RevisedSearchComplexity {

    public static int linearSearch(int[] array, int target) {
        int iterationCount = 0; // Initialize iteration count

        // Loop through each element of the array
        for (int i = 0; i < array.length; i++) {
            iterationCount++; // Increment iteration count on each loop

            // If the current element is the target, return its index
            if (array[i] == target) {
                // Print iteration count
                System.out.println("Iterations: " + iterationCount);
                return i;
            }
        }

        // If the target was not found, print the total number of iterations and return -1
        System.out.println("Iterations: " + iterationCount);
        return -1;
    }

      public static int binarySearch(int[] array, int target) {
        // Start the binary search with the full range of the array
        return binarySearchRecursive(array, target, 0, array.length - 1, 0);
    }

    private static int binarySearchRecursive(int[] array, int target, int left, int right, int iterations) {
        // Base case: If the range is invalid, the target is not in the array.
        if (left > right) {
            System.out.println("Binary search iterations: " + iterations);
            return -1;
        }

        // Calculate the middle index of the current range
        int mid = left + (right - left) / 2;
        iterations++; // Increment the count of iterations each time this method is called.

        // If the middle element is the target, return its index
        if (array[mid] == target) {
            System.out.println("Binary search iterations: " + iterations);
            return mid;
        } else if (array[mid] < target) {
            // If the target is greater than the mid element, search the right half of the array
            return binarySearchRecursive(array, target, mid + 1, right, iterations);
        } else {
            // If the target is less than the mid element, search the left half of the array
            return binarySearchRecursive(array, target, left, mid - 1, iterations);
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object to read user input
        int n = 0; // Initialize the number of elements in the array
        System.out.println("Enter number of elements in array:");
        try {
            n = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid integer number of elements.");
            return;
        }

        // Validate that the array contains at least one element
        if (n <= 0) {
            System.out.println("Array must have at least one element.");
            return;
        }

        // Read the elements of the array from the user
        int[] array = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            try {
                array[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer for array elements.");
                return;
            }
        }

        // Define targets to search (first, middle, last elements)
        int[] targets = {array[0], array[n / 2], array[n - 1]};

        // Perform searches for each target and measure the time taken
        for (int target : targets) {
            // Time Linear Search
            long startTime = System.nanoTime();
            int linearResult = linearSearch(array, target);
            long endTime = System.nanoTime();
            System.out.println((linearResult == -1) ? "Target not found by linear search." : "Target found by linear search at index: " + linearResult);
            System.out.println("Linear search time: " + (endTime - startTime) + " nanoseconds.");

            // Ensure array is sorted for binary search
            Arrays.sort(array);
            // Time Binary Search
            startTime = System.nanoTime();
            int binaryResult = binarySearch(array, target);
            endTime = System.nanoTime();
            System.out.println((binaryResult == -1) ? "Target not found by binary search." : "Target found by binary search at index: " + binaryResult);
            System.out.println("Binary search time: " + (endTime - startTime) + " nanoseconds.\n");
        }

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}