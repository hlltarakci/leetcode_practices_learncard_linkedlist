// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1226/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null) {
            node.next = node;
            return node;
        }
        
        Node prev=head, curr=head.next;
        
        while(true) {
            if(prev.val <= node.val && (curr.val > node.val || curr.val < prev.val)) {
                prev.next = node;
                node.next = curr;
                break;
            }
            
            if(prev.val > node.val &&  curr.val < prev.val && curr.val > node.val) {
                prev.next = node;
                node.next = curr;
                head = node;
                break;
            }
            
            if(curr == head) {
                prev.next = node;
                node.next = curr;
                break;
            }
            
            prev = curr;
            curr = curr.next;
        }
       
        return head;
    }
}
