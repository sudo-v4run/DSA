
class Solution {
    public ListNode doubleIt(ListNode head) {
        
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        ListNode res = addTwoNumbers(prev,prev);
        
        prev = null;
        cur = res;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev;
    }
    public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        
        ListNode l1 = h1;
        ListNode l2 = h2;
        
        ListNode head = new ListNode();
        ListNode cur = head;
        boolean carry = false;
        
        while(l1!= null || l2 != null || carry){
            int n1 = 0, n2 = 0;
            
            if(l1 != null){
                n1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                n2 = l2.val;
                l2 = l2.next;
            }
            
            int sum = n1+n2;
            if(carry){
                sum++;
            }
            
            if(sum/10 != 0){
                carry = true;
            }else{
                carry = false;
            }
            
            cur.next = new ListNode(sum%10);
            cur = cur.next;
        }
        
        return head.next;
    }
}