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
        // Create a dummy node to simplify the edge case when removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy, slow = dummy;
        
        // Move fast pointer n+1 steps ahead, so there's a gap of n nodes between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both fast and slow pointers until fast reaches the last node
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Delete the nth node from the end
        slow.next = slow.next.next;
        
        // Return the new head (dummy.next to handle edge case when head is removed)
        return dummy.next;
    }
}