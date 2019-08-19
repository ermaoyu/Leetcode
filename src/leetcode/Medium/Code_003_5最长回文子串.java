package leetcode.Medium;

import java.util.Map;

/**
 * maomaoyu    2019/7/22_19:30
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 **/
public class Code_003_5最长回文子串 {
    /**
     *  manacher算法
     * */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0)return "";
        if (s.length() == 1) return s;
        char[] cArr = manacherString(s);
        int C = -1 , R = -1,start = 0;
        int max = Integer.MIN_VALUE;
        int[] pArr = new int[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            pArr[i] = R > i ?Math.min(pArr[2*C-i],R-i) : 1;
            while (i + pArr[i] < cArr.length && i - pArr[i] > -1 ){
                if (cArr[i + pArr[i]] == cArr[i - pArr[i]])
                    pArr[i]++;
                else
                    break;
            }
            if (pArr[i] + i > R){
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > max){
                start = i;//回文中心
                max = pArr[i];
            }
        }

    }

    private char[] manacherString(String str){
        char[] cArr = str.toCharArray();
        char[] rs = new char[cArr.length * 2 + 1];
        int index = 0 ;
        for (int i = 0; i < rs.length ; i++) {
            rs[i] = (i & 1) == 0 ? '#' : cArr[index++];
        }
        return rs;
    }
}
