import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Assignment04 {
    public static void main(String args[]) {
        // Question01
        // int arr1[] = {1,2,3,4,5};
        // int arr2[] = {1,2,5,7,9};
        // int arr3[] = {1,3,4,5,8};
        // System.out.println(question01(arr1, arr2, arr3));

        // Question02
        // int arr1[] = {1,2,3};
        // int arr2[] = {2,4,6};
        // System.out.println(question02(arr1, arr2));

        // Question03
        // int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        // int res[][] = question03(arr);
        // for(int i[] : res){
        //     for(int j : i)
        //     System.out.print(j+" ");
        //     System.out.println();
        // }

        // Question04
        // int arr[] = {1,4,3,2};
        // System.out.println(question04(arr));

        // Question05
        // System.out.println(question05(5));

        // Question06
        // int arr[] = {-4,-1,0,3,10};
        // int res[] = question06(arr);
        // for(int i : res) System.out.print(i+" ");

        // Question07
        // int ops[][] = {{2,2},{3,3}};
        // System.out.println(question07(3, 3, ops));

        // Question08
        // int arr[] = {2,5,1,3,4,7};
        // int res[] = question08(arr,3);
        // for(int i : res) System.out.print(i+" ");
    }

    public static List<Integer> question01(int ar1[], int ar2[], int ar3[]){
        int i = 0, j = 0, k = 0;
        List<Integer> list = new ArrayList<>();
        while (i < ar1.length && j < ar2.length && k < ar3.length) {
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                list.add(ar1[i]);
                i++;
                j++;
                k++;
            }
            else if (ar1[i] < ar2[j])
                i++;
            else if (ar2[j] < ar3[k])
                j++;
            else
                k++;
        }
        return list;
    }

    public static List<List<Integer>> question02(int[] nums1, int[] nums2) {
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

    public static int[][] question03(int[][] arr) {
        int res[][] = new int[arr[0].length][arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                res[j][i] = arr[i][j];
            }
        }
        return res;
    }

    public static int question04(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 2) return nums[0];
        int res = 0;
        for(int i=0; i<nums.length; i+=2)
            res += nums[i];
        return res;
    }

    public static int question05(int n) {
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
    public static int[] question06(int[] nums) {
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
    public static int question07(int m, int n, int[][] ops) {
        if(ops.length == 0) return m*n;
        int row = Integer.MAX_VALUE;
        int col = Integer.MAX_VALUE;
        for(int i[] : ops){
            row = Math.min(row,i[0]);
            col = Math.min(col,i[1]);
        }
        return row*col;
    }
    public static int[] question08(int[] nums, int n) {
        int res[]=new int[2*n];
        int k=0;
        for(int i=0; i<n; i++){
            res[k++]=nums[i];
            res[k++]=nums[i+n];
        }
        return res;
    }
}