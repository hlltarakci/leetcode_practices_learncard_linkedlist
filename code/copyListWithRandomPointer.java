// https://leetcode.com/problems/copy-list-with-random-pointer/ 
// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /*
        n: num of nodes
        time: O(n)
        space: O(n) --> spaces clones take
    */
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node dummy = new Node(-1);
        
        // clone creation
        Node curr = head;
        while(curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            clone.random = curr.random;
                
            curr.next = clone;
            curr = curr.next.next;
        }
        dummy.next = head.next;
        
        // assign randoms of clones
        curr = head.next;
        while(curr != null) {
            if(curr.random != null) curr.random = curr.random.next;
            
            if(curr.next != null) curr = curr.next.next;
            else curr = null;
        }
        
        // interleave original and clone list
        curr = head;
        while(curr != null && curr.next != null) {
            Node next = curr.next;
            if(curr.next != null) curr.next = curr.next.next;
            curr = next;
        }
        
        
        return dummy.next;
    }
}
