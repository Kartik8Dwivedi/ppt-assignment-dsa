import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Assignment06 {

    public static void main(String[] args) {

        // Question01
        // int res[] = question01("IDID");
        // for(int i : res) System.out.print(i+", ");

        // Question02
        // int res[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        // System.out.println(question02(res, 3));

        // Question03
        // int res[] = {2,1};
        // System.out.println(question03(res));

        // Question04
        // int res[] = {0,1};
        // System.out.println(question04(res));

        // Question05
        // int counter1[] = { 5, 3, 4, 2 };
        // int counter2[] = { 4, 2, 2, 5 };
        // System.out.println(question05(counter1, counter2));

        // Question06
        // int arr[] = {1,3,4,2,6,8};
        // int res[] = question06(arr);
        // for(int i : res) System.out.print(i+" ");

        // Question07
        // int res[][] = question07(3);
        // for(int i[] : res){
        //     for(int j : i) System.out.print(j+" ");
        //     System.out.println();
        // }
    
        // Question08
        // int arr1[][] =  {{1,0,0},{-1,0,3}};
        // int arr2[][] =  {{7,0,0},{0,0,0},{0,0,1}};
        // int res[][] = question08(arr1, arr2);
        // for(int i[] : res){
        //     for(int j : i)
        //         System.out.print(j+" ");
        //     System.out.println();
        // }
    }

    public static int[] question01(String S) {
        int n = S.length(), left = 0, right = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; ++i)
            res[i] = S.charAt(i) == 'I' ? left++ : right--;
        res[n] = left;
        return res;
    }

    public static boolean question02(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) left = mid+1;
            else right = mid - 1;
        }
        return false;
    }

    public static boolean question03(int[] arr) {
        int pointer = 0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                pointer = i;
                break;
            }
            else if(arr[i] == arr[i+1]) return false;
        }
        if(pointer == 0) return false;

        for(int i=pointer; i< arr.length - 1; i++){
            if(arr[i]<arr[i+1]) return false;
            else if(arr[i] == arr[i+1]) return false;
        }

        return true;
    }

    public static int question04(int[] nums) {
        for(int i=0; i<nums.length; i++)
            if(nums[i] == 0) nums[i] = -1;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum == 0) res = Math.max(res,i+1);

            if(map.containsKey(sum)){
                res = Math.max(res,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        } 
        return res;
    }

    public static int question05(int[] nums1, int[] nums2) {
        int ans = 0;
        Arrays.sort(nums1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums2) {
            pq.add(i);
        }
        int i = 0;

        while (i < nums1.length && !pq.isEmpty()) {
            ans += nums1[i] * pq.poll();
            i++;
        }
        return ans;
    }

    public static int[] question06(int[] changed) {
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

    public static int[][] question07(int n) {
        int m = n, k=1, f=0;
        int up = 0,  down = n - 1;
        int left = 0, right = m - 1;
        int res[][] = new int[n][n];
        while (f < n*n) {
            for (int j = left; j <= right && f < n*n; j++){
                res[up][j] = k++;
                f++;
            }
            
            for (int i = up + 1; i <= down - 1 && f < n*n; i++){
                res[i][right] = k++;
                f++;
            }
                     
            for (int j = right; j >= left && f < n*n; j--){
                res[down][j] = k++;
                f++;
            }
                        
            for (int i = down - 1; i >= up + 1 && f < n*n; i--){
                res[i][left] = k++;
                f++;
            } 
                
            left++; right--; up++; down--; 
        }
        return res;
    }

    public static int[][] question08(int arr1[][], int arr2[][]) {
        int r1 = arr1.length, c1 = arr1[0].length, c2 = arr2[0].length;
        int[][] res = new int[r1][c2];
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < r1; ++i) {
            for (int j = 0; j < c1; ++j) {
                if (arr1[i][j] != 0) {
                    mp.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        for (int i = 0; i < r1; ++i) {
            for (int j = 0; j < c2; ++j) {
                if (mp.containsKey(i)) {
                    for (int k : mp.get(i)) {
                        res[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }
        }
        return res;
    }
}
