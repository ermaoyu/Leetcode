package leetcode;

import javax.swing.*;

/**
 * maomaoyu    2019/2/26_21:35
 **/
public class Code_14_25k个一组翻转链表 {
    /**
     * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k){//找到第K+1个node
            cur = cur.next;
            count++;
        }

        if (count == k){
            cur = reverseKGroup(cur,k);
            while (count-- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}
