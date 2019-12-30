// https://leetcode.com/problems/reverse-linked-list/
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
            null case
            one node case
		test: 
		    1->2->3->4->5->NULL
            
		algorithm:
            approach #1: iterative -- iterate through the list, move to head of list
            approach #2: recursive
		
        n: node count
		time complexity: O(n)
		space complexity: O(1) - iterative, O(n) - recursion stack
	*/
	
    public ListNode reverseList(ListNode head) {
        return reverseListIterative(head);
    }
    
    private ListNode reverseListIterative(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode current = head;
        while(current != null && current.next != null) {
            ListNode moveToFront = current.next;
            current.next = current.next.next;
            moveToFront.next = dummy.next;
            dummy.next = moveToFront;
        }
        
        return dummy.next;
    }
    
    private ListNode reverseListRecursive(ListNode head)  {
        
    }
}
