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
       if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode mid = middleNode(head);

        // Step 2: Reverse the second half of the list
        ListNode hs = reverseList(mid);
        ListNode hf = head;

        // Step 3: Rearrange the list
        while (hf != null && hs != null) {
            ListNode temp1 = hf.next;
            ListNode temp2 = hs.next;

            hf.next = hs;
            hs.next = temp1;

            hf = temp1;
            hs = temp2;
        }

        // Ensure the last node points to null
        if (hf != null) {
            hf.next = null;
        }
    }

    // Helper method to find the middle node of the list
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    } 
    
}
