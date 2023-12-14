
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode start = head;
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i = 1 ; i <= n ; i++){
            fast = fast.next;
        }
        
        if(fast == null){   // n = list.size(). i.e. remove head..
            return head.next;
        }
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return start;
        
        
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