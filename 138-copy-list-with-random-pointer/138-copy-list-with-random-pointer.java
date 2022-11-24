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
    public Node copyRandomList(Node head) {
        
        if(head==null)
            return null;
        
        Node cur = head;
        while(cur != null){
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        
        cur = head;
        
        while(cur!=null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        cur = head;
        Node copy = cur.next;
        Node ans = copy;
        
        while(cur!=null){
            cur.next = cur.next.next;
            copy.next = copy.next!=null?copy.next.next:null;
            cur = cur.next;
            copy = copy.next;
        }
        
        return ans;
    }
}