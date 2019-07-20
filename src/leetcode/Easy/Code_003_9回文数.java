package leetcode.Easy;

/**
 * maomaoyu    2019/7/20_22:55
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 * */
public class Code_003_9回文数 {

    /**
     *  解法一:转换为String字符串
     * */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        char[] c = String.valueOf(x).toCharArray();
        int i = 0;
        int j = c.length - 1;
        while (i <= j){
            if (i == j)return true;
            if (c[i] == c[j]){
                i++;
                j--;
            }else {
                return false;
            }
        }
        if (c[i] == c[j]){
            return true;
        }
        return false;
    }

    /**
     *  解法二:反转一半的数字,不会造成溢出
     * */
    public boolean isPalindrome_2(int x) {
        if (x < 0 || (x%10 == 0 && x != 0)) return false;
        int rev = 0;
        while (x > rev){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return x == rev || x == rev / 10;
    }
}
