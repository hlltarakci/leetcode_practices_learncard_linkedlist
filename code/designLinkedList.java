// https://leetcode.com/problems/design-linked-list/
// https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/

class MyLinkedList {
    class Node {
        public int val;
        public Node next;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    Node head;
    int count;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= count) return -1;
        
        Node curr = head;
        while(index-- > 0) {
            curr = curr.next;
        }
        
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(count, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > count) return;
        
        Node node = new Node(val);
        Node dummy = new Node(-1);
        dummy.next = head;
        Node curr = dummy;
        while(index-->0) 
            curr = curr.next;
        
        node.next = curr.next;
        curr.next = node;
        head = dummy.next;
        count++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= count) return;
        
        Node dummy = new Node(-1);
        dummy.next = head;
        Node curr = dummy;
        while(index-->0)
            curr = curr.next;
        
        curr.next = curr.next.next;
        head = dummy.next;
        count--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
