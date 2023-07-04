import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Assignment08 {
    public static void main(String[] args) {
        // Question01
        // System.out.println(question01("sea", "eat"));

        // Question02
        // System.out.println(question02("()"));

        // Question03
        // System.out.println(question03("sea", "eat"));

        // Question05
        // char arr[] = {'a','a','b','b','c','c','c'};
        // System.out.println(question05(arr));

        // Question06
        // System.out.println(question06("cbaebabacd", "abc"));

        // Question07
        // System.out.println(question07("3[a]2[bc]"));

        // Question08
        System.out.println(question08("ab", "ba"));
    }

    public static int question01(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    int a = 0;
                    for (int z = 1; z <= Math.max(j, i); z++) {
                        a += (i == 0 ? s2.charAt(z - 1) : s1.charAt(z - 1));
                    }
                    dp[i][j] = a;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j], s2.charAt(j - 1) + dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], s1.charAt(i - 1) + s2.charAt(j - 1) + dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static boolean question02(String s) {
        int cmin = 0, cmax = 0; 
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin--;
            } else if (c == '*') {
                cmax++; 
                cmin--; 
            }
            if (cmax < 0)
                return false; 
            cmin = Math.max(cmin, 0);
        }
        return cmin == 0;
    }

    public static int question03(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? dp[i - 1][j - 1] + 1
                            : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int val = dp[word1.length()][word2.length()];
        return word1.length() - val + word2.length() - val;
    }

    public static int question05(char[] chars) {
        int i = 0;
        int n = chars.length;
        int j = 0;
        if (n == 1)
            return 1;
        while (i < n) {
            int count = 1;
            char charac = chars[i];
            while (i + 1 < n && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            if (count == 1) {
                chars[j++] = charac;
            } else {
                if (count > 1) {
                    chars[j++] = charac;
                    String counterstring = count + "";
                    for (int r = 0; r < counterstring.length(); r++) {
                        chars[j++] = counterstring.charAt(r);
                    }
                }
            }
            i++;
        }
        return j;
    }

    public static List<Integer> question06(String s, String p) {
        int len1 = p.length(), len2 = s.length();
        ArrayList<Integer> list = new ArrayList<>();
        if (len1 > len2)
            return list;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[p.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }
        if (allZero(count))
            list.add(0);

        for (int i = len1; i < len2; i++) {
            count[s.charAt(i) - 'a']--;
            count[s.charAt(i - len1) - 'a']++;
            if (allZero(count))
                list.add(i - p.length() + 1);
        }

        return list;
    }

    private static boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }

    static int iiii = 0;

    public static String question07(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String tmp_string = "";

        while (iiii < s.length()) {
            char c = s.charAt(iiii);
            iiii++;

            if (c == '[') {
                tmp_string = question07(s); 
                for (int j = 0; j < count; j++) {
                    sb.append(tmp_string);
                }
                count = 0;
            } else if (c == ']') { 
                break;
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                count = count * 10 + c - '0';
            }
        }

        return sb.toString();
    }

    public static boolean question08(String s, String goal) {
        int n = s.length();
        if (s.equals(goal)) {
            Set<Character> temp = new HashSet<>();
            for (char c : s.toCharArray()) {
                temp.add(c);
            }
            return temp.size() < goal.length(); // Swapping same characters
        }

        int i = 0;
        int j = n - 1;

        while (i < j && s.charAt(i) == goal.charAt(i)) {
            i++;
        }

        while (j >= 0 && s.charAt(j) == goal.charAt(j)) {
            j--;
        }

        if (i < j) {
            char[] sArr = s.toCharArray();
            char temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            s = new String(sArr);
        }

        return s.equals(goal);
    }
}