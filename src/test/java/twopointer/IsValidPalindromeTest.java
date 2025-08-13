package twopointer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IsValidPalindromeTest {

  @ParameterizedTest(name = "Input: \"{0}\" → Is Palindrome: {1}")
  @CsvSource({
    "'A man, a plan, a canal: Panama', true",
    "'race a car', false",
    "'No lemon, no melon', true",
    "'Was it a car or a cat I saw?', true",
    "'Hello, World!', false"
  })
  void testIsPalindrome(String input, boolean expectedResult) {
    boolean result = ValidPalindrome.isPalindrome(input);
    assertEquals(expectedResult, result);
  }

  @ParameterizedTest(name = "Cleanse: \"{0}\" → \"{1}\"")
  @CsvSource({
    "'A man, a plan, a canal: Panama', amanaplanacanalpanama",
    "'A B!C@1#2$3^', abc123",
    "'   ', ''",
    "'123ABCdef!!', 123abcdef",
    "'No$%NumbersHere!', nonumbershere",
    "'race a car', raceacar"
  })
  void testCleanseString(String input, String expectedCleaned) {
    String result = ValidPalindrome.cleanseString(input);
    assertEquals(expectedCleaned, result);
  }
}
