// https://leetcode.com/problems/copy-list-with-random-pointer/ 
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
		clarifying questions & edge cases:
		test: 
		
		algorithm:
            approach #1: keep original-clone node mapping in a hastable
                in second pass, get randoms based on this
                will use space O(n)
            approach #2: to do in-place (so O(1) space)
                keep clones in between original nodes
                then rewire all
		
        n: node count
		time complexity: O(n)
		space complexity: O(1)
	*/
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        // create all clones in between original nodes
        Node current = head;
        while(current != null) {
            Node clone = new Node(current.val);
            clone.next = current.next;
            current.next = clone;
            current = current.next.next;
        }
        
        // set clones random
        current = head;
        while(current != null) {
            Node clone = current.next;
            Node cloneRandom = current.random != null ? current.random.next : null;
            clone.random = cloneRandom;
            
            current = current.next.next;
        }
        
        // separate original and clone list
        Node cloneHead = head.next, cloneCurrent = head.next;
        current = head;
        while(current != null) {
            if(current.next != null) current.next = current.next.next;
            else current.next = null;
            
            if(cloneCurrent.next != null) cloneCurrent.next = cloneCurrent.next.next;
            else cloneCurrent.next = null;
            
            current = current.next;
            cloneCurrent = cloneCurrent.next;
        }
        
        return cloneHead;
    }
}
