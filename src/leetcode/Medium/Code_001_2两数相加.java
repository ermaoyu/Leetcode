package leetcode.Medium;

import leetcode.ListNode;

import java.util.List;

/**
 * maomaoyu    2019/7/21_20:58
 * 给出两个空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Code_001_2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(0);
        ListNode q = l1,p = l2,cur = resNode;
        int carry = 0;
        while (p != null || q != null){
            int x = (p != null ? p.val : 0);
            int y = (q != null ? q.val : 0);
            int sum = x + y + carry;
            carry = sum /10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0){
            cur.next = new ListNode(carry);
        }
        return resNode.next;
    }

}
