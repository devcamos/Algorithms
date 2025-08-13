package org.example;

import java.util.Arrays;

public class MainMethod {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9))); // Output: [2, 7]
  }

  public static int[] twoSum(int[] nums, int target) {

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; i < nums.length; i++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {j, i};
        }
      }
    }

    return new int[] {}; // If no pair found
  }
}
