package leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    /**
     *
     给定一个字符串，找出不含有重复字符的最长子串的长度。

     示例 1:

     输入: "abcabcbb"
     输出: 3
     解释: 无重复字符的最长子串是 "abc"，其长度为 3。
     * */
    public int lengthOfLongestSubstring(String s) {
            if(s == null ||s.length() == 0){
                return 0;
            }
            int rs = 0;
            HashMap<Character,Integer> map = new HashMap<>();
            for (int i =0,j = 0;i<s.length();i++ ){
                if (map.containsKey(s.charAt(i))){
                    j = Math.max(j,map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i),i);
                rs = Math.max(rs,i - j +1);
            }

            return rs;
    }
}
