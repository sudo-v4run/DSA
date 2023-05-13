
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        
        return false;
        
        

    
//         if(head == null)
//             return false;
        
//         HashSet<ListNode> hs = new HashSet<>();
        
//         while(head != null){
//             if(!hs.contains(head)){
//                 hs.add(head);
//                 head = head.next;
//             }else{
//                 return true;
//             }
//         }
        
//         return false;
    }
}