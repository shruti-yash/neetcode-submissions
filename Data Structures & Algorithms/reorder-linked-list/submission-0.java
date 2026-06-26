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
    public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode curr = head;
        while (curr != null && curr.next != null) {

            ListNode temp = curr;

            while (temp.next.next != null) {
                temp = temp.next;
            }

            ListNode ele = temp.next;
            temp.next = null;
            ele.next = curr.next;
            curr.next = ele;
            curr = curr.next.next;
             
        }
        
    }
}
