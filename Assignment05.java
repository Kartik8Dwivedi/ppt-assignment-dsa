import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Assignment05 {
    public static void main(String[] args) {
        // Question01 
        // int arr[] = {1,2,3,4};
        // int res[][] = question01(arr, 2, 2);
        // for(int i[] : res) {
        //     for(int j : i) System.out.print(j+" ");
        //     System.out.println();
        // }

        // Question02 
        // System.out.println(quesiton02(5));

        // Question03 
        // int arr[] = {-4,-1,0,3,10};
        // int res[] = question03(arr); 
        // for (int i : res) System.out.print(i+" ");

        // Question04 
        // int nums1[] = {1,2,3};
        // int nums2[] = {2,4,6};
        // System.out.println(question04(nums1, nums2));

        // Question05 
        // int nums1[] = {4,5,8};
        // int nums2[] = {10,9,1,8};
        // System.out.println(question05(nums1, nums2, 2));

        // Question06 
        // int nums[] = {4,3,2,7,8,2,3,1};
        // System.out.println(question06(nums));

        // Question07 
        // int nums[] = {3,4,5,1,2};
        // System.out.println(question07(nums));

        // Question08 
        // int nums[] = {1,3,4,2,6,8};
        // int res[] = question08(nums);
        // for(int i : res) System.out.print(i+" ");
    }
    public static int[][] question01(int[] original, int m, int n) {
        if(m*n>original.length) return new int[0][0];
        if(m*n<original.length) return new int[0][0];
                int res[][] = new int[m][n];
        for(int i=0; i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                res[i][j] = original[(i*n)+j];
            }
        }
        return res;
    }
    public static int quesiton02(int n) {
        // return (int)(Math.sqrt(2 * (long)n + 0.25) - (0.5));  ->O(1) solution
        // BS Approach   ->O(log n) solution
        long start=1;
        long end=n;
        while(start<=end){
            long mid=start+(end-start)/2;
            long sum=(mid*(mid+1))/2;
            if(sum==n)return (int)mid;
            else if(sum>n)end=mid-1;
            else start=mid+1;
        }
        return (int)end;
    }
    public static int[] question03(int[] nums) {
        // Brute force approach O(nlogn)
        // int res[] = new int[nums.length];
        // for(int i=0; i<nums.length; i++) res[i] = (int)Math.pow(nums[i],2);
        // Arrays.sort(res);
        // return res;

        // Two Pointer Approach O(n)
        int left=0;
        int right = nums.length-1;
        int res[] = new int[nums.length];
        int p = nums.length-1;
        while(left<=right){
            int a = (int)Math.pow(nums[left],2);
            int b = (int)Math.pow(nums[right],2);
            if(a>b){
                left++;
                res[p] = a;
                p--;
            }else{
                right--;
                res[p] = b;
                p--;
            }
        }
        return res;
    }
    public static List<List<Integer>> question04(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i:nums1) set1.add(i);
        for(int i:nums2) set2.add(i);

		List<List<Integer>> resultList = new ArrayList<>();
		resultList.add(new ArrayList<>());
		resultList.add(new ArrayList<>());

		for(int num : set1)
			if(!set2.contains(num))resultList.get(0).add(num);
		for(int num : set2)
			if(!set1.contains(num))resultList.get(1).add(num);
		return resultList;
    }
    public static int question05(int[] arr1, int[] arr2, int d) {
        int count = 0;
        boolean f = false;
        for(int i : arr1){
            f = true;
            for(int j: arr2){
                if(Math.abs(i-j) <= d) {
                    f = false;
                    break;
                };
            }
                if(f) count++;
        }
        return count;
    }
    public static List<Integer> question06(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            if(set.contains(i)) list.add(i);
            else set.add(i);
        }
        return list;
    }
    public static int question07(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<nums[right]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
    public static int[] question08(int[] changed) {
        int[] temp = new int[changed.length/2];
        Queue<Integer> x = new LinkedList<>();
        Arrays.sort(changed);
        int i = 0;
        for(int num : changed){
            if(!x.isEmpty() && x.peek()==num)
                temp[i++] = x.poll()/2;
            else x.add(num*2);
        }
        return x.size()>0 ? new int[]{}:temp;
    }
}