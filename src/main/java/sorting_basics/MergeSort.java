package sorting_basics;

import java.util.Arrays;
import java.util.Random;

// Slightly faster than quicksort
// Uses divide and conquer recursively
public class MergeSort {

  public static void main(String[] args) {
    int average = 10000;
    int worstCase = 1000000;
    int[] numbers;
    Random rand = new Random();

    // Best case: already sorted array
    int[] bestCaseArray = {1, 2, 3, 4, 5};
    long startTimeBest;
    long endTimeBest;

    // Average case: random array
    numbers = new int[average];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(average);
    }

    long startTimeAverage;
    long endTimeAverage;

    // Worst case: reverse sorted array
    int[] worstCaseArray = new int[worstCase];
    for (int i = 0; i < worstCaseArray.length; i++) {
      worstCaseArray[i] = worstCase - i;
    }

    long startTimeWorst;
    long endTimeWorst;

    // Sort and measure execution time for each case
    startTimeBest = System.currentTimeMillis();
    mergeSort(bestCaseArray);
    endTimeBest = System.currentTimeMillis();

    startTimeAverage = System.currentTimeMillis();
    mergeSort(numbers);
    endTimeAverage = System.currentTimeMillis();

    startTimeWorst = System.currentTimeMillis();
    mergeSort(worstCaseArray);
    endTimeWorst = System.currentTimeMillis();

    System.out.println(
        "\nBest case execution time: " + (endTimeBest - startTimeBest) + " milliseconds");
    System.out.println(
        "Average case execution time: " + (endTimeAverage - startTimeAverage) + " milliseconds");
    System.out.println(
        "Worst case execution time: " + (endTimeWorst - startTimeWorst) + " milliseconds");
  }

  private static void mergeSort(int[] inputArray) {
    // Get the length of the input array.
    int inputLength = inputArray.length;

    // If the array has less than 2 elements, there's nothing to split.
    if (inputLength < 2) {
      return;
    }

    // Compute the middle index.
    int midIndex = inputLength / 2;

    // Copy the first part (up to midIndex) into leftHalf.
    int[] leftHalf = Arrays.copyOf(inputArray, midIndex);

    // Create an empty right array for the remaining elements.
    int[] rightHalf = new int[inputLength - midIndex];

    mergeSort(leftHalf);
    mergeSort(rightHalf);

    merge(inputArray, leftHalf, rightHalf);
  }

  private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;

    // Compare each element and add lower to the new merged array
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < leftSize && j < rightSize) {
      if (leftHalf[i] <= rightHalf[j]) {
        inputArray[k] = leftHalf[i];
        i++;
      } else {
        inputArray[k] = rightHalf[j];
        j++;
      }
      k++;
    }
    while (i < leftSize) {
      inputArray[k] = leftHalf[i];
      i++;
      k++;
    }
  }
}
