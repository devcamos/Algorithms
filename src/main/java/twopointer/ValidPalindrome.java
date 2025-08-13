package twopointer;

import java.util.HashMap;
import java.util.Map;

public class ValidPalindrome {

  public static void main(String[] args) {
    Map<Integer, String> palindromeCount = new HashMap<>();
    String[] names = {"otto", "nota", "hannah", "dave"};

    // Should result in 2

    // How to loop an array using stream

    // How to loop an array using for
    int count = 0;
    for (String name : names) {
      if (isPalindrome(name)) {
        count++;
        palindromeCount.put(count, name);
      }
    }

    //  palindromeCount.forEach();

  }

  public static boolean isPalindrome(String s) {
    String str = cleanseString(s);
    int left = 0, right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left++) != str.charAt(right--)) return false;
    }
    return true;
  }

  static String cleanseString(String input) {
    return input.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
  }
}
