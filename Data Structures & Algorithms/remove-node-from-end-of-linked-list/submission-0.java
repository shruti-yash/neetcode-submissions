/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;

        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        System.out.println("length is ::"  + len);

        int index = len-n;
        temp = head;

        if (index == 0) return head.next;

        System.out.println("index is ::"  + index);
        while (index != 1) {
            temp = temp.next;
            index--;
        }

        temp.next = temp.next.next;
        return head;

    }
}
