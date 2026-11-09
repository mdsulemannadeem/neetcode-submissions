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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeStart = dummy;

        for(int i = 0;i < left - 1;i++){
            beforeStart = beforeStart.next;
        }
        ListNode curr = beforeStart.next;
        ListNode original = curr;
        ListNode prev = null;

        for(int i = 0;i < right -left + 1;i++){
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
beforeStart.next = prev;
original.next = curr;
return dummy.next;
    }
}