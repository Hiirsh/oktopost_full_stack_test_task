import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class FilterTest {

  @Test
  public void test_findItems_ArrayWithDuplicatesPassed_DuplicateItemsReturned() {

    int[] subject = { 1, 0, 2, 9, -6, 1, -6, 0, 19, 5, 2 };
    int[] expected = { 1, 0, 2, -6 };
    int[] resultV1 = Filter.filterV1(subject);
    int[] resultV2 = Filter.filterV2(subject);
    Arrays.sort(expected);
    Arrays.sort(resultV1);
    Arrays.sort(resultV2);
    assertArrayEquals(expected, resultV1);
    assertArrayEquals(expected, resultV2);
  }
}
