// https://leetcode.com/problems/remove-linked-list-elements/
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
            if val is head value -- dummy node will work
            if all is value -- dummy node
            if val is last node
		test: 
		
		algorithm:
            iterate through
            if next value equals to val, delete it
		
        n: node count
		time complexity: O(n)
		space complexity: O(1)
	*/
	
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy, current = head;
        while(current != null) {
            if(current.val == val) prev.next = current.next;
            else prev = current;
            current = current.next;
        }
        
        return dummy.next;
    }
}
