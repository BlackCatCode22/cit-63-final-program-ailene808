// SearchComplexity.java
// Starter code for final programming assignment in CIT-63 Java Programming Spring 2024


import java.util.Arrays;
import java.util.Scanner;

public class SearchComplexity {

    // Linear Search Method
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;  // Returns index of found element
            }
        }
        return -1;  // Target not found
    }

    // Binary Search Method
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int iterations = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            iterations++;

            if (array[mid] == target) {
                System.out.println("Binary search iterations: " + iterations);
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Binary search iterations: " + iterations);
        return -1;  // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements in array:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter target number to search:");
        int target = scanner.nextInt();

        // Linear Search
        int linearResult = linearSearch(array, target);
        System.out.println((linearResult == -1) ? "Target not found by linear search." :
                "Target found by linear search at index: " + linearResult);

        // Binary Search (Array must be sorted)
        Arrays.sort(array);
        int binaryResult = binarySearch(array, target);
        System.out.println((binaryResult == -1) ? "Target not found by binary search." :
                "Target found by binary search at index: " + binaryResult);

        scanner.close();
    }
}


