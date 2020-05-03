// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/

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
        n: num of nodes
        time: O(n)
        space: O(1)
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return null;
        
        ListNode fast = head;
        while(n-- > 0) fast = fast.next;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode slow = dummy;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
