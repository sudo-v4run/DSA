
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        ListNode cur = head;
        int size = 0;
        
        while(cur != null){
            cur = cur.next;
            size++;
        }
        
        k = k%size;
        if(k == 0){
            return head;
        }
        
        cur = head;
        ListNode prev = null;
        
        
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            size++;
        }
        
        cur = prev;
        ListNode s = cur;
        ListNode prev1 = null;
        int i = 0;
        
        while(i < k){
            ListNode temp = cur.next;
            cur.next = prev1;
            prev1 = cur;
            cur = temp;
            i++;
        }
        
        ListNode prev2 = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev2;
            prev2 = cur;
            cur = temp;
        }
        
        s.next = prev2;
        
        return prev1;
    }
}