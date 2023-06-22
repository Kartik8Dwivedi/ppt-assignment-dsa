import java.util.HashMap;
import java.util.HashSet;


public class Main{
    public static void main(String args[]){
        // Question 01
        // int nums [] = {11,15,7,2};
        // int target = 9;
        // int res [] = question01(nums, target);
        // System.out.println(res[0]+" "+res[1]);

        // Question 02
        // int nums [] = {3,2,2,3,5,6,2,3,6,2,3,5,3,2};
        // int val = 3;
        // System.out.println(question02(nums, val));

        // Question 03
        // int nums [] = {1,3,5,6};
        // int target = 2;
        // System.out.println(question03(nums, target));

        // Question 04
        // int digits[] = {9,9,9};
        // int res[] = question04(digits);
        // for (int i : res) {
        //     System.out.print(i+" ");
        // }System.out.println();

        // Question 05
        // int nums1[] = {1,2,3,0,0,0,0};
        // int nums2[] = {2,4,5,6};
        // question05(nums1, nums2);
        // for (int i : nums1) {
        //     System.out.print(i+" ");
        // }


        // Question 06
        // int nums[] = {1,2,3,1};
        // System.out.println(question06(nums));

        // Question 07
        // int nums[] = {0,1,0,3,12,0,11,4,0,5,0,7};
        // question07(nums);
        // for (int i : nums) {
        //     System.out.print(i+" ");
        // }System.out.println();

        // Question 08
        int nums[] = {1,2,2,4};
        int res [] = question08(nums);
        for (int i : res) {
            System.out.print(i+" ");
        }System.out.println();

    }
    public static int [] question01 (int arr [], int target){

        int res [] = {0,0};

        // brute force - two pointer TC: O(n^2)  SC: O(1)
        /* 
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        */

        // optimized solution - using hashmap TC: O(n) SC: O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(target - arr[i], i);
            if(map.containsKey(arr[i])){
                res[0] = map.get(arr[i]);
                res[1] = i;
                return res;
            }
        }

        return res;
    }

    public static int question02 (int arr[], int val){
        int i = 0;
        for(int k=0; k<arr.length; k++){
            if(arr[k] != val){
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        // for(int j = 0; j<arr.length; j++){
        //     System.out.print(arr[j] + " ");
        // } 
        return i;
    }

    public static int question03 (int arr [], int target){
        int res = 0;

        // Since the array is sorted, we can use binary search algorithm
        int left = 0, right = arr.length -1;
        while(right > left){
            int mid = left - (left - right)/2;
            if(target > arr[mid]){
                left = mid + 1;
            }else if(target < arr[mid]){
                right = mid - 1;
            }else{
                return mid;
            }
            res = left;
        }

        return res;
    }

    public static int [] question04(int arr[]){

        // Method 01: converting array->string->number, incrementing it by 1 then converting its digits to form an array

        /* 

        if(arr[arr.length-1]<9 && arr.length < 2){
            arr[arr.length-1] += 1;
            return arr;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }
        String str = sb.toString();
        int num = Integer.parseInt(str);
        num += 1;
        String newStr = String.valueOf(num);
        int newArr [] = new int[newStr.length()];
        for(int i=0; i<newStr.length(); i++){
            newArr[i] = Character.getNumericValue(newStr.charAt(i));
        }
        return newArr;

        */

        // Method 02 - Mathematical way  TC: O(n)   SC: O(1)
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

    public static void question05(int nums1[], int nums2[]){
        // Brute force approach
        // merging 2 arrays then using sort function and then swapping values in the nums1 array
        // TC: O((m + n) log(m + n))   SC: O(n)
        /* 

        int nums3[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            nums3[i] = nums1[i];
        }
        for(int i=0; i<nums2.length; i++){
            nums3[nums1.length - nums2.length +i] = nums2[i];
        }
        Arrays.sort(nums3);
        for(int i=0; i<nums3.length; i++){
            nums1[i] = nums3[i];
        }

        */


        // Method 02 - Two Pointer
        // we can use two pointer approach for minimizing the Time and space complexity by comparing the values at 2 pointers and placing them from end of the nums1 array 
        // TC: O(n)  O(1)

        int pointer1 = nums1.length - nums2.length - 1;
        int pointer2 = nums2.length -1;
        for(int i= nums1.length-1; i>=0; i--){
            if(nums1[pointer1]> nums2[pointer2]){
                nums1[i] = nums1[pointer1];
                pointer1--;
                if(pointer1<0) break;
            }else{
                nums1[i] = nums2[pointer2];
                pointer2--;
                if(pointer2<0) break;
            }
        }
    }

    public static boolean question06(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            if(set.contains(arr[i])) return true;
            set.add(arr[i]);
        }
        return false;
    }

    public static void question07(int arr[]){
        // Method 01 : Brute force approach
        // in this approach, as we find '0', while iterating through the array, we will place it to the corresponding index and then shift all the other variable one step to left.

        // Method 02 : Two pointer approach
        // TC: O(n) SC: O(1)

        /* 
        
        int pointer1 = 0, pointer2 = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[pointer2] != 0){
                int temp = arr[pointer1];
                arr[pointer1] = arr[pointer2];
                arr[pointer2] = temp;
                pointer1++;
                pointer2++;
            }else{
                pointer2++;
            }
        }
        for(int i=pointer1; i<arr.length; i++){
            arr[i] = 0;
        }

        */

        // Method 03 : Counting approach
        // In this approach we can firstly count how many zeroes are there, followed by another loop which will place all the non zero elements at start of array and then the remaining places will be filled by zeroes.

        int count =0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0) count ++;
        }
        int k=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                arr[k] = arr[i];
                k++;
            }
        }
        while(k < arr.length){
            arr[k] = 0;
            k++;
        }
    }

    public static int [] question08(int arr[]){

        int res[] = {0,0};

        // Method 01 : Brute force, by using hashing

        /* 

        int count [] = new int[arr.length +1];

        for (int i : arr) count[i] += 1;

        for(int i=1; i<=arr.length; i++){
            if(count[i] == 2) res[0] = i;
            else if(count[i] == 0) res[1] = i;
        }
        

        */

        // Method 02 : Cyclic sort approach

        /* 

        int k=0;
        while(k < arr.length){
            if(!(arr[k] == arr[arr[k]-1])){
                int temp = arr[k];
                arr[k] = arr[arr[k]-1];
                arr[arr[k]-1] = temp;
            }
            else k++;
        }
        for(k=0; k<arr.length; k++){
            if(arr[k] != k+1){
                res[0] = arr[k];
                res[1] = k+1;
                break;
            }
        }

        */

        // Method 03 : Mathematical way
        int n = arr.length;
        int sn = (n*(n+1))/2;
        int s2n = (n*(n+1)*(2*n + 1))/6;
        int s = 0, s2 = 0;

        for(int i=0; i<arr.length; i++){
            s += arr[i];
            s2 += arr[i] * arr[i];
        }
        int val1 = s - sn;
        int val2 = s2 - s2n;

        val2 = val2/val1;

        int x = (val1 + val2)/2;
        int y = x - val1;
        res[0] = x;
        res[1] = y;
        
        return res;


    }
}
