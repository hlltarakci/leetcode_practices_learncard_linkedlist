// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    /*
        n: num of nodes
        time: O(n)
        space: O(n) --> recursion stack at worst case - in case there is a chain of children
    */
    public Node flatten(Node head) {
        if(head == null) return null;
        
        Node curr = head;
        while(curr != null) {
            Node child = flatten(curr.child);
            if(child != null) {
                child.prev = curr;
                Node currChild = child;
                while(currChild != null && currChild.next != null) currChild = currChild.next;
                currChild.next = curr.next;
                if(currChild.next != null) currChild.next.prev = currChild;
                curr.next = child;
                curr.child = null;
            }
            curr = curr.next;
        }
        
        return head;
    }
}


---------------------------------

// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    /*
		clarifying questions & edge cases:
		test: 
		
		algorithm:
            recursion
		
        n: number of total nodes
		time complexity: O(n)
		space complexity: O(n) -- recursion depth 
            worst case: children form a chain and recursion depth goes up to O(n)
	*/
    public Node flatten(Node head) {
        Node current = head;
        while(current != null) {
            if(current.child != null) {
                Node flatChild = flatten(current.child);
                Node flatChildEnd = flatChild;
                while(flatChildEnd.next != null) flatChildEnd = flatChildEnd.next;
                flatChildEnd.next = current.next;
                if(current.next != null) current.next.prev = flatChildEnd;
                current.next = flatChild;
                flatChild.prev = current;
                current.child = null;
            }
            current = current.next;
        }
        
        return head;
    }
}
