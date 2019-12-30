// https://leetcode.com/problems/linked-list-cycle-ii/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	/*
		clarifying questions & edge cases:
		test: 
		
		algorithm: two pointer technique
            fast pointer: double steps
            slow pointer: single step
            once they meet, this means there is cycle
            at that point, take one of the pointers to head, move them one step at a time,
                they'll meet at cycle start point
		
        n: node count
		time complexity: O(n)
		space complexity: O(1)
	*/
	
    public ListNode detectCycle(ListNode head) {
        ListNode meetPoint = getMeetPoint(head);
        
        if(meetPoint != null) {
            ListNode current = head;
            while( meetPoint != current ) {
                meetPoint = meetPoint.next;
                current = current.next;
            } 
            
            return current;
        }
        
        return null;
    }
    
    private ListNode getMeetPoint(ListNode head) {
        ListNode fast = head, slow = head;
        
        boolean isCycle = false;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                isCycle = true;
                break;
            } 
        }
        
        return isCycle ? fast : null;
    }
}
