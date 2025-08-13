package searching_basics.on.linearsearch;

public class BruteForceApproach {

  public static void main(String[] args) {
    int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
    int target = 23;

    int index = binarySearch(arr, target);
    if (index != -1) {
      System.out.println("Element found at index: " + index);
    } else {
      System.out.println("Element not found in the array.");
    }
  }

  public static int binarySearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1; // Element not found
  }
}
