// https://leetcode.com/problems/odd-even-linked-list/
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
            count < 3, no need to change
		test: 
		    1->2->3->4->5->6->7->8->9->10
            
		algorithm:
            one pointer stays at end of all odd part
            other pointer inits at second element, iterates through 
		
        n: node count
		time complexity: O(n)
		space complexity: O(1)
	*/
	
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        
        ListNode endOfOdds = head, endOfEvens = head.next;
        while(endOfEvens != null && endOfEvens.next != null) {
            ListNode addToOdds = endOfEvens.next;
            endOfEvens.next = endOfEvens.next.next;
            addToOdds.next = endOfOdds.next;
            endOfOdds.next = addToOdds;
            
            endOfOdds = endOfOdds.next;
            endOfEvens = endOfEvens.next;
        }
        
        return head;
    }
}
