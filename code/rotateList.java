// https://leetcode.com/problems/rotate-list/
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
            empty list
            k equals zero
            k equals len
		test: 
		
		algorithm:
            calculate length of list
            k = k % len
            go forward len-k steps
            make next node head of list, tie tail to head and cut the list at len-k
		
        n: node count
		time complexity: O(n)
		space complexity: O(1)
	*/
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        int len = calcLen(head);
        k = k % len;
        
        if(k == 0) return head;
        
        ListNode current = head;
        int forwardSteps = len - k - 1;
        while(forwardSteps-- > 0) current = current.next;
        
        ListNode newHead = current.next;
        current.next = null;
        
        current = newHead;
        while(current.next != null) current = current.next;
        current.next = head;
        
        return newHead;
    }
    
    private int calcLen(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
