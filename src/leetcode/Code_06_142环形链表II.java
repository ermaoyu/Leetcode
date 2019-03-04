package leetcode;

import java.util.List;

/**
 *      毛毛雨     2018/11/23
 *      给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *      说明：不允许修改给定的链表。
 * */
public class Code_06_142环形链表II {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)return null;
        ListNode low = head;
        ListNode fast = head.next;
        while(fast != null&& fast.next != null){
            low = low.next;
            fast = fast.next.next;
            if(fast == low)break;
        }
        if (fast == null || fast.next == null)return null;
        low = head;
        while(low != fast){
            low = low.next;
            fast = fast.next;
        }
        return low;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        System.out.println(detectCycle(node).val);
    }
}
