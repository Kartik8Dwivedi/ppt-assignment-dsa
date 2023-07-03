import java.util.HashMap;

class Assignment07 {
    public static void main(String[] args) {
        // Question01
        // System.out.println(question01("egg", "add"));

        // Question02
        // System.out.println(question02("69"));
    
        // Question03
        // System.out.println(question03("11", "123"));

        // Question04
        // System.out.println(question04("Let's take LeetCode contest"));

        // Question05
        // System.out.println(question05("abcdefg", 2));

        // Question06
        // System.out.println(question06("abcde", "cdeab"));

        // Question07
        // System.out.println(question07("ab#c", "ad#c"));

        // Question08
        int arr[][] = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(question08(arr));
    }

    public static boolean question01(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for (int idx = 0; idx < s.length(); idx++) {
            if (map1[s.charAt(idx)] != map2[t.charAt(idx)])
                return false;
            map1[s.charAt(idx)] = idx + 1;
            map2[t.charAt(idx)] = idx + 1;
        }
        return true;
    }

    public static boolean question02(String n) {
        if (n == null || n.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        int left = 0;
        int right = n.length() - 1;
        while (left <= right) {
            if (!map.containsKey(n.charAt(right)) || n.charAt(left) != map.get(n.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static String question03(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
    public static String question04(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = 0;
        for (;j<c.length;j++) {
            if (c[j] == ' ') {
                reverseWord(c, i, j-1);
                i = j+1;
            } 
        }
        reverseWord(c, i, j-1);
        return new String(c);
    }
    
    private static void reverseWord(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }
    }
    public static String question05(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int i = 0;
        while(i<n){
            int j = Math.min(i+k-1, n-1);
            reverse(sb,i,j);
            i += 2*k;
        }
        return sb.toString();
    }
    public static void reverse(StringBuilder sb, int i, int j){
        while(i < j){
            char ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, ch);
            i++;
            j--;
        }
    }
    public static boolean question06(String s, String goal) {
        return s.length()==goal.length() && (s+s).indexOf(goal) != -1;
    }
    public static boolean question07(String s, String t) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for(int k=0; k<s.length(); k++){
            char i = s.charAt(k);
            if(i == '#') {
                if(str1.length() == 0) continue;
                str1 = str1.deleteCharAt(str1.length()-1);
            }else{
                str1.append(i);
            }
        }
        for(int k = 0; k < t.length(); k++){
            char i = t.charAt(k);
            if(i == '#') {
                if(str2.length() == 0) continue;
                str2 = str2.deleteCharAt(str2.length()-1);
            }else{
                str2.append(i);
            }
        }
        String ss = str1.toString();
        String tt = str2.toString();
        return ss.equals(tt);
    }
    public static boolean question08(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1], 
            x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}