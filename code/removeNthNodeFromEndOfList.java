// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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
            list size n -- remove head
            n is zero -- remove last node
		test: 
		    1->2->3->4->5, and n = 2
            
		algorithm: two pointer technique
            fast pointer moves n+1 nodes ahead
            slow pointer starts when fast pointer is n+1 nodes ahead
            when fast pointer is done with list, delete what slow pointer points to
            
		n: node count
		time complexity: O(n) -- one pass
		space complexity: O(1)
	*/
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        while(n-- > 0) fast = fast.next;
        
        while(fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        if(fast == null) head = head.next;
        else if(slow.next != null) slow.next = slow.next.next;
        
        return head;
    }
}
