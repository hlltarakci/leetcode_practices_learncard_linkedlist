// https://leetcode.com/problems/intersection-of-two-linked-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
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
		
		algorithm:
            calculate length of a and b
            travel longer one until their lengths equal
            go one by one comparing the nodes
            they should match at the start point
            
		a: node count of list A
        b: node count of list B
		time complexity: O(a + b)
		space complexity: O(1)
	*/
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = count(headA);
        int countB = count(headB);
        
        ListNode longer = countA > countB ? headA : headB;
        ListNode shorter = countA > countB ? headB : headA;
        
        int diff = Math.abs(countA-countB);
        while(diff-- > 0) longer = longer.next;
        
        while(longer != null) {
            if(longer == shorter) return longer;
            longer = longer.next;
            shorter = shorter.next;
        }
        
        return null;
    }
    
    private int count(ListNode head) {
        int result = 0;
        while( head != null) {
            result++;
            head = head.next;
        }
        return result;
    }
}
