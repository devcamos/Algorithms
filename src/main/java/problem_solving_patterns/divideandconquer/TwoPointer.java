package problem_solving_patterns.divideandconquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoPointer {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(array(new int[] {2, 7, 11, 15}, 9)));
  }

  // Find pair in String
  public static int[] array(int[] array, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      int complement = target - array[i]; // If complement exists in map, we found a solution
      if (numMap.containsKey(complement)) {
        return new int[] {(numMap.get(complement)), i};
      }
      numMap.put(array[i], i);
    }
    return new int[] {};
  }
}
