
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class Assignment03 {
    public static void main(String[] args) {
        // Question01
        // int arr[] ={-1,2,1,-4};
        // System.out.println(question01(arr,1));

        // Question02
        // int arr[] = {1,0,-1,0,-2,2};
        // System.out.println(question02(arr, 0));

        // Question03
        // int arr[] = {1,2,3};
        // question03(arr);
        // for (int i : arr) {
        //     System.out.print(i+" ");
        // }

        // Question04
        // int nums[] = {1,3,5,6};
        // System.out.println(question04(nums, 5));

        // Question05
        // int arr[] = {1,2,3};
        // question05(arr);
        // for (int i : arr) {
        //     System.out.print(i+" ");
        // }

        // Question06
        // int arr[] = {2,2,1};
        // System.out.println(question06(arr));

        // Question07
        // int nums[] = {0,1,3,50,75};
        // System.out.println(question07(nums));

        // Question08
        int nums[][] = {{0,30},{5,10},{15,20}};
        System.out.println(question08(nums));

    }
    public static int question01(int[] nums, int target) {
        Arrays.sort(nums);
        var closest = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return target;
                else if(sum < target) j++;
                else if(sum > target) k--;
                int diff = Math.abs(target-sum);
                if(diff < minDiff){
                    minDiff = diff;
                    closest = sum;
                }
            }
        }
        return closest;
    }
    public static List<List<Integer>> question02(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        s.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        output.addAll(s);
        return output;
    }
    public static void question03(int[] nums) {
        int n = nums.length;
        // store the breaking point
        int idx = -1;

        for(int i = n-2 ; i>=0 ; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }
        
        // base case - no breakpoint found
        if(idx == -1) {
            Arrays.sort(nums, 0, n);
            return;
        }


        // finding the greater but closest num
        for(int i=n-1 ; i>idx ; i--) {
            if(nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        // Reversing the remaining array.
        Arrays.sort(nums, idx+1, n);
    }
    public static int question04(int[] nums, int target) {
        if(target>nums[nums.length-1]) return nums.length;
        if(target<nums[0]) return 0;
        int left = 0, right = nums.length-1, mid=0;
        while(left<=right){
            mid = left + (right-left)/2;
            if(target>nums[mid]){
                left = mid+1;
            }else if(target<nums[mid]){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return left;
    }
    public static int[] question05(int[] arr) {
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] <9){
                arr[i] += 1;
                break;
            }else arr[i] = 0;
        }
        if(arr[0] == 0){
            int res [] = new int[arr.length+1];
            res[0] = 1;
            return res;
        }
        return arr;
    }
    public static int question06(int[] nums) {
        int res = 0;
        for(int i=0; i<nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
    public static List<String> question07(int[] nums) {
        List<String> al = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int start=nums[i];
            while(i+1<nums.length && nums[i]+1==nums[i+1])
                i++;
            
            if(start!=nums[i]){
                al.add(""+start+"->"+nums[i]);
            }
            else{
                al.add(""+start);
            }
        }
        return al;
    }
    public static boolean question08(int[][] intervals) {
        if(intervals == null || intervals.length== 0) return true;
        Arrays.sort(intervals, (a, b)-> a[1]-b[1]);
        int k =0, count =1, n = intervals.length;
        for(int i =1; i < n ; i++){
            if (intervals[i][0] >= intervals[k][1]){
                k = i;
                count++;
            }
        }
        if(count>1) return false;
        return true;
    }
}