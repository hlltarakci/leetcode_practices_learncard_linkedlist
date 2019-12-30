// https://leetcode.com/problems/linked-list-cycle/
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
		
		algorithm: two pointer technique:
            fast pointer takes double steps
            slow pointer takes one step at a timw
            if they meet, there is cycle
		
        n: node count
		time complexity: O(n)
		space complexity: O(1)
	*/
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        
        while( fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) return true;
        }
        
        return false;
    }
}
