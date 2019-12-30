// https://leetcode.com/problems/palindrome-linked-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	/*
		clarifying questions & edge cases:
		test: 
            1->2->2->1
		
		algorithm:
            calculate length of array
            reverse the second half and compare
            (if odd length -- ignore the extra node)
		
        n: node count
		time complexity: O(n)
		space complexity: O(1)
	*/
    public boolean isPalindrome(ListNode head) {
        int len = calcLen(head);
        int forwardStepCount = len % 2 == 0 ? (len / 2) : (len / 2 + 1);
        
        ListNode secondHalf = head;
        while(forwardStepCount-- > 0) secondHalf = secondHalf.next;
        secondHalf = reverse(secondHalf);
        
        while(secondHalf != null) {
            if(head.val != secondHalf.val) return false;
            head = head.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = head, current = head.next;
        
        while(current != null) {
            ListNode toMoveFront = current;
            
            prev.next = current.next;
            current = current.next;
            
            toMoveFront.next = dummy.next;
            dummy.next = toMoveFront;
        }
        
        return dummy.next;
    }
    
    private int calcLen(ListNode head) {
        int len = 0;
        
        while(head != null) {
            len++;
            head = head.next;
        }
        
        return len;
    }
}
