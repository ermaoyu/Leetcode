package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨      2018/11/7
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * */
public class day6_21_392判断子序列 {
    public boolean isSubsequence1(String s, String t) {
        if (t.length() < s.length()){
            return false;
        }
        if (s.length() == 0 && s.length() == 0){
            return true;
        }
        if (s.length() == 0 ){
            return true;
        }
        int i = 0;
        int index = 0;
        int res = 0;
        for (; i < s.length() ; i++) {
            for (int j = index; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)){
                    index++;
                    res++;
                    break;
                }else {
                    index++;
                }
            }
        }
        return res == s.length();
    }

    //动态规划
    //即如果 s.sub(0,i) 是 t.sub(0,j-1)的子序列，则肯定也是 t.sub(0,j)的子序列；否则，就需要看 s.sub(0,i-1) 是否为 t.sub(0,j-1)的子序列，如果是的话就只要比较 s(i)与 t(j)是否相等，相等则 s.sub(0,i) 是 t.sub(0,j)的子序列。
    //---------------------
    //原文：https://blog.csdn.net/OneDeveloper/article/details/79950575
    public static boolean isSubsequence2(String s, String t) {
        if (t.length() < s.length()){
            return false;
        }
        if (s.length() == 0 && s.length() == 0){
            return true;
        }
        if (s.length() == 0 ){
            return true;
        }

        boolean[][] dp = new boolean[s.length()][t.length()];
        dp[0][0] = s.charAt(0) == t.charAt(0);
        for (int i = 1; i < t.length(); i++) {
            dp[0][i] = dp[0][i - 1] || s.charAt(0) == t.charAt(i);
        }
        for (int i = 1; i < s.length(); i++) {
            dp[i][i] = dp[i-1][i -1] &&  (s.charAt(i) == t.charAt(i));
        }
        for (int i = 1; i < s.length() ; i++) {
            for (int j = i + 1; j < t.length(); j++) {
                if (dp[i][j - 1])dp[i][j] = true;
                else dp[i][j] = dp[i-1][j -1] &&  (s.charAt(i) == t.charAt(j));
                if (i == s.length() -1 && dp[i][j])return true;
            }
        }
        return dp[s.length() - 1][t.length() - 1];
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "adfcbc";
        System.out.println(isSubsequence2(s,t));
    }

}
