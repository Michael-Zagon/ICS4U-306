/**
 * The program for 306
 *
 * By: Michael Zagon
 * Version: 1.0
 * Since: 2024-05-12
 */

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuickSortProgram {

    // This is the recursive Quick Sort function.
    public static int[] quickSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        } else {
            int pivot = arr[0];
            int[] lessThanPivot = Arrays.stream(arr, 1, arr.length).filter(x -> x <= pivot).toArray();
            int[] greaterThanPivot = Arrays.stream(arr, 1, arr.length).filter(x -> x > pivot).toArray();
            int[] sortedLessThanPivot = quickSort(lessThanPivot);
            int[] sortedGreaterThanPivot = quickSort(greaterThanPivot);

            int[] sortedArray = new int[arr.length];
            System.arraycopy(sortedLessThanPivot, 0, sortedArray, 0, sortedLessThanPivot.length);
            sortedArray[sortedLessThanPivot.length] = pivot;
            System.arraycopy(sortedGreaterThanPivot, 0, sortedArray, sortedLessThanPivot.length + 1, sortedGreaterThanPivot.length);

            return sortedArray;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Asks for the user's input array
            System.out.println("This program sorts an array using Quick Sort");
            System.out.print("Enter your array (comma-separated values): ");
            String inputArrayString = scanner.nextLine();
            String[] inputArrayStringSplit = inputArrayString.split(",");
            int[] inputArray = Arrays.stream(inputArrayStringSplit).mapToInt(Integer::parseInt).toArray();

            // Shows the original array
            System.out.println("This is the Original Array: " + Arrays.toString(inputArray));

            // Sorts the array using Quick Sort
            int[] sortedArray = quickSort(inputArray);

            // Shows the sorted array
            System.out.println("The sorted array is: " + Arrays.toString(sortedArray));

        } catch (NumberFormatException e) {
            System.err.println("Invalid input: Please enter only comma-separated integers.");
        } catch (InputMismatchException e) {
            System.err.println("Input mismatch: Please ensure your input is formatted correctly.");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("\nDone.");
            scanner.close();
        }
    }
}

