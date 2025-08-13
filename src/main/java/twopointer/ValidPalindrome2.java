package twopointer;

public class ValidPalindrome2 {

  public static void main(String[] args) {
    String[] arr = new String[] {"the ", "man", "hannah"};

    for (String s : arr) {
      System.out.println(isPalindrome(cleanseString(s)));
    }
  }

  // Return is a string a palindrome
  private static boolean isPalindrome(String s) {
    char[] chars = s.toCharArray();
    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      if (chars[i] != chars[j]) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  private static String cleanseString(String input) {
    return input.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
  }
}
