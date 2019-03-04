package leetcode;

import java.util.List;

/**
 * maomaoyu    2019/2/26_17:47
 **/
public class Code_06_141环形链表 {
    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
     * 进阶：
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     * 解法一：hsahser,遍历每个节点，hsahset查重；
     * 解法二：双指针
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
