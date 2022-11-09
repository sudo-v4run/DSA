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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode start = new ListNode();
        start.next = head;
        
        ListNode fast = start;
        ListNode slow = start;
        
        for(int i = 1 ; i <= n ; i++){
            fast = fast.next;
        }
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return start.next;
        
        
        
        
        
        
//         TC : O(2N) ....
        
//         int sz = 0;
//         ListNode dumm = head;
//         ListNode ans = head;
        
//         while(dumm!=null){
//             dumm = dumm.next;
//             sz++;
//         }
        
//         int frmStrt = sz-n;
        
//         if(frmStrt==0){
//             return head.next;
//         }
        
//         while(ans!=null && frmStrt > 1){
//             ans = ans.next;
//             frmStrt--;
//         }
        
//         ans.next = ans.next.next!=null?ans.next.next:null;
        
//         return head;
        
    }
}