// https://leetcode.com/problems/palindrome-linked-list/
// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/

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
    /*
        n: num of nodes
        time: O(n)
        space: O(1)
    */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHalfReversed = reverse(slow);
        
        ListNode curr = head;
        while(curr != null && secondHalfReversed != null) {
            if(curr.val != secondHalfReversed.val) return false;
            curr = curr.next;
            secondHalfReversed = secondHalfReversed.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
