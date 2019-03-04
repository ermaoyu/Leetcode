package leetcode;

/**
 * maomaoyu    2018/12/11_21:24
 **/
public class Code_12_5最长回文子串 {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0)return s;
        if(s.length() == 1)return s;
        char[] charArr = manacherString(s);
        String res = "";
        int[] pArr = new int[charArr.length];
        int pR = -1;
        int index = -1;
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < charArr.length; i++) {
            pArr[i] = pR > i?Math.min(pArr[2* index - i], pR - i) : 1;
            while(i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if(charArr[i + pArr[i]]==charArr[i - pArr[i]])
                    pArr[i]++;
                else
                    break;
            }
            if(i + pArr[i] >pR) {
                pR = i + pArr[i];
                index = i;
            }
            if (pArr[i]  > max){
                start = i;//回文中心
                max = pArr[i];
            }
        }
        System.out.println(max - 1);
        System.out.println(start);
        for(int i = start - max + 1  ;i < start + max;i++ ){
            if (charArr[i] != '#') {
                res += charArr[i];
            }
        }
        return res;
    }
    private static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[charArr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaacaadsdherq";
        System.out.println(longestPalindrome(s));
    }
}
