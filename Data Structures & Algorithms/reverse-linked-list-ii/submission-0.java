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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeStart = dummy;
        for(int i = 0;i < left - 1;i++){
            beforeStart = beforeStart.next;
        }
        ListNode prev= null;
        ListNode curr = beforeStart.next;
        ListNode originStart = curr;

        for(int i = 0;i <right-left+1;i++){
            ListNode agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        beforeStart.next = prev;
        originStart.next = curr;
        return dummy.next;
    }
}