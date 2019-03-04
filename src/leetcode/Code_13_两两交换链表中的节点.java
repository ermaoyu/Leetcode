package leetcode;

/**
 * maomaoyu    2019/2/25_9:48
 **/
public class Code_13_两两交换链表中的节点 {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public ListNode swapPairs_01(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        ListNode pnext = null;
        ListNode res = null;
        while(cur != null && cur.next != null){
            next = cur.next;
            pnext = cur.next.next;
            next.next = cur;
            cur.next = pnext;
            if (pre == null)
                res = next;
            else
                pre.next = next;
            pre = cur;
            cur = cur.next;
        }
        return res;
    }

    public ListNode swapPairs_02(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode n = head.next;
        head.next = swapPairs_02(head.next.next);
        n.next = head;
        return n;
    }
}
