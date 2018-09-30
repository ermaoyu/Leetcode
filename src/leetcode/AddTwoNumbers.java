package leetcode;

public class AddTwoNumbers {
    /**
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * */
     class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode tmp = new ListNode(0);
            int sum = 0;
            ListNode curr = tmp;
            ListNode p1 = l1,p2 = l2;
            while(p1 !=null || p2 != null){
                if (p1 != null){
                    sum += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null){
                    sum += p2.val;
                    p2 = p2.next;
                }
                curr.next = new ListNode(sum % 10);
                sum /= 10;
                curr = curr.next;
            }
            if (sum == 1){
                curr.next = new ListNode(sum);
            }
            return  tmp.next;
    }
}
