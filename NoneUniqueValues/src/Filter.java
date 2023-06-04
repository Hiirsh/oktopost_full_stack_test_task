import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Filter {
  /**
   * 
   * Vesion 1 - More memory, less time
   * 
   */
  public static int[] filterV1(int[] nums) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> counter = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (counter.containsKey(nums[i])) {
        result.add(nums[i]);
        counter.put(nums[i], counter.get(nums[i]) + 1);
        continue;
      }
      counter.put(nums[i], 1);
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  /**
   * 
   * Vesion 2 - Less memory, more time
   * 
   */
  public static int[] filterV2(int[] nums) {
    Map<Integer, Integer> counter = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (counter.containsKey(nums[i])) {
        counter.put(nums[i], counter.get(nums[i]) + 1);
        continue;
      }
      counter.put(nums[i], 1);
    }
    return counter.entrySet().stream()
        .filter(e -> e.getValue() > 1)
        .mapToInt(e -> Integer.valueOf(e.getKey()))
        .toArray();
  }
}
