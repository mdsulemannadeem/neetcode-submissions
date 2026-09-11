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
    public ListNode reverseList(ListNode head) {
     ListNode current = head;
     ListNode prev = null;
     ListNode agla = null;
     while(current != null){
        agla = current.next;
        current.next = prev;
        prev = current;
        current = agla;
     }
     return prev;
    }
}
