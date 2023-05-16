
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode ng = head;
        ListNode pg = dummy;
        
        while(true){
            ListNode kth = getKth(ng,k);
            
            if(kth == null){
                pg.next = ng;
                break;
            }
            
            ListNode curStart = ng;
            ng = kth.next;
            
            // reverse the linkedList
            
            ListNode prev = null;
            ListNode cur = curStart;
            
            while(cur != ng){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            
            // Linked PreviousGroup to the CurrentGroup..
            
            pg.next = kth;
            pg = curStart;  // updating pg for the k-group or next iteration...
        }
        
        return dummy.next;
    }
    public static ListNode getKth(ListNode node, int k){
        
        int cn = 1;
        
        while(node != null && cn < k){
            node = node.next;
            cn++;
        }
        
        return node;
    }
}