// https://leetcode.com/problems/rotate-list/
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
        n: num of nodes
        time: O(n)
        space: O(1)
    */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 1;
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            count++;
            curr = curr.next;
        }
        curr.next = head;
        
        k %= count;
        int diff = count - k -1;
        
        curr = head;
        while(diff-- > 0) curr = curr.next;
        ListNode newHead = curr.next;
        curr.next = null;
        
        return newHead;
    }
}
