/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode();
        ListNode ans = head;
        
        while(l1!=null || l2!=null){
            int sum = l1!=null && l2==null?l1.val: l1==null && l2!=null ? l2.val : l1==null && l2==null? 0 :l1.val+l2.val; 
            sum+=carry;
            head.next = new ListNode((sum%10));
            carry = (sum/10);
            head = head.next;
            l1 = l1==null?l1:l1.next;
            l2 = l2==null?l2:l2.next;
        }
    
        if(carry!=0){
            head.next = new ListNode(carry);
        }
        
        return ans.next;
    }
}