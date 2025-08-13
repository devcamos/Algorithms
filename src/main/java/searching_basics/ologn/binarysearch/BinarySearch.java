package searching_basics.ologn.binarysearch;

// Search algorithm to find a target value in a sorted array
public class BinarySearch {

  public static void main(String[] args) {

    // Requires array to be sorted to be O(logn) time or else O(n log n) on unsorted
    int[] array = new int[] {1, 2, 3, 4, 5};
    // Turn into logger with lombok
    System.out.println(binarySearch(array, 1));
  }

  public static int binarySearch(int[] arr, int target) {
    return findMe(arr, target);
  }

  private static int findMe(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = (right + left) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) { // Array search is now halved
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
