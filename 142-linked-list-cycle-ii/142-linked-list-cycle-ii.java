
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        do{
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }while(fast != null && slow != fast);
        
        if(fast == null){
            return null;
        }
        
        ListNode slow2 = head;
        
        while(slow != slow2){
            slow = slow.next;
            slow2 = slow2.next;
        }
        
        return slow;
    }
}