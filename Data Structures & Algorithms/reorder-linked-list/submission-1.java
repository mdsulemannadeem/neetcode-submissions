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
       if(head == null && head.next == null){
return;
       }
       // Step 1: Find the middle of the list
        ListNode mid = middleNode(head);

        // Step 2: Reverse the second half of the list
        ListNode halfs = reverseList(mid);
        ListNode halff = head;

        // Step 3: Rearrange the list
        while (halfs != null && halff != null) {
            ListNode temp1 = halff.next;
            ListNode temp2 = halfs.next;

            halff.next = halfs;
            halfs.next = temp1;

            halff = temp1;
            halfs = temp2;
        }

        // Ensure the last node points to null
        if (halff != null) {
            halff.next = null;
        }
    }

     private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
     }

     private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
           ListNode agla = curr.next;
           curr.next = prev;
           prev = curr;
           curr = agla;

        }
        return prev;
     }
}
