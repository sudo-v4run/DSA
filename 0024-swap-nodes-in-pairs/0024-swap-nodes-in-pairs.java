class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
            
        ListNode ans = head.next;
        ListNode cur = head;
        
        while(true){
            
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            
            if(temp == null){
                cur.next = null;
                break;
            }

            if(temp.next == null){
                cur.next = temp;
                break;
            }
            
            ListNode tempNext = temp.next;
            cur.next = tempNext;
            cur = temp;
        }
        
        return ans;
    }
}