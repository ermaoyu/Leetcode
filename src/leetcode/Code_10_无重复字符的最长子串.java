package leetcode;

import java.util.HashMap;

/**
 * maomaoyu    2018/12/4_23:24
 **/
public class Code_10_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)return 0;
        int R = 0;
        int L = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (;R < s.length();R++){
            if (map.containsKey(s.charAt(R))){
                L = Math.max(L,map.get(s.charAt(R)));
            }
            map.put(s.charAt(R),R + 1);
            max = Math.max(max,R - L + 1);
        }
        return max;
    }
}
