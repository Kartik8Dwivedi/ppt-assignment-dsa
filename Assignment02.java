import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Assignment02 {

  public static void main(String[] args) {
    // Question01
    // int nums[] = {1,4,3,2};
    // System.out.println(question01(nums));

    // Question02
    // int nums[] = {1,1,2,2,3,3};
    // System.out.println(question02(nums));

    // Question03
    // int nums[] = {1,3,2,2,5,2,3,7};
    // System.out.println(question03(nums));

    // Question04
    // int nums[] = {1,0,0,0,1};
    // System.out.println(question04(nums,1));

    // Question05
    // int nums[] = {1,2,3};
    // System.out.println(question05(nums));

    // Question06
    // int nums[] = {-1,0,3,5,9,12};
    // System.out.println(question06(nums, 9));

    // Question07
    // int nums[] = {1,2,2,3};
    // System.out.println(question07(nums));

    // Question08
    // int nums[] = {1};
    // System.out.println(question08(nums, 0));
  }

  public static int question01(int[] nums) {
    Arrays.sort(nums);
    if (nums.length == 2) return nums[0];
    int res = 0;
    for (int i = 0; i < nums.length; i += 2) res += nums[i];
    return res;
  }

  public static int question02(int[] candyType) {
    HashSet<Integer> set = new HashSet<>();
    for (int i : candyType) {
      set.add(i);
    }
    int n = set.size();
    int m = candyType.length / 2;
    return (m > n) ? n : m;
  }

  public static int question03(int[] nums) {
    Map<Long, Integer> map = new HashMap<>();
    for (long num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int result = 0;
    for (long key : map.keySet()) {
      if (map.containsKey(key + 1)) {
        result = Math.max(result, map.get(key + 1) + map.get(key));
      }
    }
    return result;
  }

  public static boolean question04(int[] arr, int n) {
    if (n == 0) return true;
    if (arr.length == 1) {
      return (arr[0] == 0 && n == 1) ? true : false;
    }
    if (arr.length == 2) {
      return (arr[0] == 0 && arr[1] == 0 && n == 1) ? true : false;
    }
    if (arr[0] == 0 && arr[1] == 0 && n > 0) {
      arr[0] = 1;
      n--;
    }
    if (n == 0) return true;
    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i] == 0 && arr[i - 1] == 0 && arr[i + 1] == 0) {
        arr[i] = 1;
        n--;
        if (n == 0) return true;
      }
    }
    if (arr[arr.length - 1] == 0 && arr[arr.length - 2] == 0 && n > 0) {
      n--;
    }
    if (n == 0) return true;
    return false;
  }

  public static int question05(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    if (nums[0] >= 0) return nums[n - 1] * nums[n - 2] * nums[n - 3];
    if (nums[0] < 0 && nums[1] < 0) {
      return Math.max(
        (nums[0] * nums[1] * nums[n - 1]),
        (nums[n - 1] * nums[n - 2] * nums[n - 3])
      );
    }
    return 0;
  }

  public static int question06(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target > nums[mid]) start = mid + 1; else if (
        target < nums[mid]
      ) end = mid - 1; else return mid;
    }
    return -1;
  }

  public static boolean question07(int[] nums) {
    boolean one = inc(nums);
    boolean two = dec(nums);
    if (one || two) return true;
    return false;
  }

  public static boolean inc(int nums[]) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) return false;
    }
    return true;
  }

  public static boolean dec(int nums[]) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < nums[i + 1]) return false;
    }
    return true;
  }

  public static int question08(int[] nums, int k) {
    int max = nums[0];
    int min = nums[0];
    for (int i : nums) {
      max = Math.max(max, i);
      min = Math.min(min, i);
    }
    return Math.max(max - min - (2 * k), 0);
  }
}
