
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
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