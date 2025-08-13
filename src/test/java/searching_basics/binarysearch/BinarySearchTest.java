package searching_basics.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import searching_basics.ologn.binarysearch.BinarySearch;

class BinarySearchTest {

  @Test
  @SneakyThrows
  void elementFoundInBinarySearch() {
    int[] array = {1, 2, 3, 4, 5};
    int target = 3;
    int expectedIndex = 2;

    int actualIndex = BinarySearch.binarySearch(array, target);

    assertEquals(expectedIndex, actualIndex);
  }

  @Test
  @SneakyThrows
  void elementNotFoundInBinarySearch() {
    int[] array = {1, 2, 3, 4, 5};
    int target = 6;
    int expectedIndex = -1;

    int actualIndex = BinarySearch.binarySearch(array, target);

    assertEquals(expectedIndex, actualIndex);
  }
}
