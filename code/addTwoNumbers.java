// https://leetcode.com/problems/add-two-numbers/
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
            loop through, add
		
        a: node count of l1
        b: node count of l2
		time complexity: O(max(a,b))
		space complexity: O(1) -- excluding result
            result will use O(max(a,b)) space
	*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        
        ListNode current = result;
        int carry = 0, base = 10;
        while(l1 != null || l2 != null || carry > 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            
            int val = (val1 + val2 + carry) % base;
            carry = (val1 + val2 + carry) / base;
            
            ListNode element = new ListNode(val);
            current.next = element;
            current = current.next;
        }
        
        return result.next;
    }
}
