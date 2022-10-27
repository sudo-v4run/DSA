/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
//         if(head==null)
//             return false;
        
//         ListNode slow = head;
//         ListNode fast = head;
        
//         while(fast.next!=null && fast.next.next !=null){
//             slow = slow.next;
//             fast = fast.next.next;
            
//             if(slow==fast){
//                 return true;
//             }
//         }
        
//         return false;
        
        
        HashSet<ListNode> hs = new HashSet<>();
    
        if(head==null)
            return false;
        
        while(head!=null){
            if(!hs.contains(head)){
                hs.add(head);
                head = head.next;
            }else{
                return true;
            }
        }
        
        return false;
        
    }
}