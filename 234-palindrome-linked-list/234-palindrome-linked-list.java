
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode start = head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow;
        
        ListNode prev = null;
        ListNode cur = mid;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        ListNode end = prev;
        
        while(end != null){
            if(start.val != end.val){
                return false;
            }
            start = start.next;
            end = end.next;
        }
        
        return true;
    }
}