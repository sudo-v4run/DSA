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
        if(head==null){
            return null;
        }
        Node cur = head;
        while(cur!=null){
            Node temp = cur.next;
            Node newNode = new Node(cur.val);
            cur.next = newNode;
            newNode.next = temp;
            cur=temp;
        }
        cur = head;
        
        while(cur!=null){
            if(cur.random!=null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        Node ori = head;
        cur = ori.next;
        Node ans = cur;
        while(ori!=null&&cur!=null){
            ori.next = ori.next.next;
            if(cur.next!=null)
                cur.next = cur.next.next;
            ori=ori.next;
            cur = cur.next;
        }
        
         return ans;
    }
}