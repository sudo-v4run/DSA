
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head==null||head.next==null) return true;
        
        ListNode start = head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        ListNode end = prev;
        
        // TC - O(N) and SC = O(1) while NOT preserving the structure of input list..
        
        while(end != null){
            if(start.val != end.val){
                return false;
            }
            start = start.next;
            end = end.next;
        }
        
        return true;
        
        // TC - O(N) and SC = O(1) while preserving the structure of input list..
        
//         boolean isPali = true;
//         ListNode nxt = null;
//         while(end != null){
//             ListNode temp = end.next;
//             if(start.val != end.val){
//                 isPali = false;
//             }
//             end.next = nxt;
//             nxt = end;
//             end = temp;
//             start = start.next;
//         }
        
//         return isPali;
    }
}