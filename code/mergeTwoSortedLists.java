// https://leetcode.com/problems/merge-two-sorted-lists/
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
		
		algorithm:
            iterate through both, add smaller one to result and go forward
		
        a: l1 node count
        b: l2 node count
		time complexity: O(a+b) 
		space complexity: O(1) 
	*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        
        ListNode current = dummy;
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                current.next = l1;
                l1 = l1.next;
            } else if (l2 != null) {
                current.next = l2;
                l2 = l2.next;
            }
            
            current = current.next;
        }
        
        return dummy.next;
    }
}
