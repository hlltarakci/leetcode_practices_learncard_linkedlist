// https://leetcode.com/problems/linked-list-cycle-ii/
// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/

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
        n: num of nodes
        time: O(n)
        space: O(1)
    */
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        
        // detect cycle
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) break;
        }
        
        if(fast == null || fast.next == null) return null;
        
        slow = head;
        
        while(true) {
            if(slow == fast) break;
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
