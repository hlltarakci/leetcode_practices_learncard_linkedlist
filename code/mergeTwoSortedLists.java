// https://leetcode.com/problems/merge-two-sorted-lists/
// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
        n, m: num of nodes
        time: O(n+m)
        space: O(1) 
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if(l1 != null) curr.next = l1;
        if(l2 != null) curr.next = l2;
        
        return dummy.next;
    }
}
