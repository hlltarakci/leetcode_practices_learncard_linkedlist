// https://leetcode.com/problems/design-linked-list/
class MyLinkedList {
    class Node {
        public int val;
        public Node prev, next;
        public Node(int val) {
            this.val = val;
        }
    }
    
    private Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(-1);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node current = this.head.next;
        while(index-- > 0) {
            if(current == null) return -1;
            current = current.next;
        }
        return current == null ? -1 : current.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head.next;
        if(this.head.next != null) this.head.next.prev = newNode;
        this.head.next = newNode;
        this.debug("addAtHead");
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.head.next == null) {
            addAtHead(val);
            return;
        }
        
        Node newNode = new Node(val);
        
        Node current = this.head.next;
        while(current.next != null) current = current.next;
        
        if(current != null) {
            current.next = newNode;
            newNode.prev = current;
        }
        
        this.debug("addAtTail");
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }
        
        Node newNode = new Node(val);
        
        Node current = this.head.next;
        while(--index > 0) {
            if(current == null) return;
            current = current.next;
        }
        
        if(current != null) {
            newNode.next = current.next;
            current.next = newNode;
            
            newNode.prev = current;
            if(newNode.next != null) newNode.next.prev = newNode;
        }
        
        this.debug("addAtIndex");
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == 0) {
            this.head.next = this.head.next.next;
            if(this.head.next != null) this.head.next.prev = null;
            return;
        }
        
        Node current = this.head.next;
        while(--index > 0) {
            if(current == null) return;
            current = current.next;
        }
        
        if(current != null && current.next != null) {
            current.next = current.next.next;
            if( current.next != null) current.next.prev = current;
        }
        
        this.debug("deleteAtIndex");
    }
    
    private void debug(String method) {
        StringBuilder list = new StringBuilder();
        list.append(method).append(": ");
        Node current = this.head.next;
        while(current != null) {
            list.append(current.val).append(" -> ");
            current = current.next;
        }
        // System.out.println(list.toString());
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
