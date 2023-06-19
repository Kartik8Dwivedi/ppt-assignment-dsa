import java.util.Arrays;
import java.util.HashMap;


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
        int digits[] = {9,9,9};
        int res[] = question04(digits);
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

        if(arr[arr.length-1]<9){
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

        return new int[0];
    }
}