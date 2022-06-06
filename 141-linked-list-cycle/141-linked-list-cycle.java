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
        // if(pos == -1)
        //     return false;
        // if(head.next == null && pos != 0)
        //     return false;
        // ListNode slow = head;
        // ListNode cur = head;
        // while(slow.next!=null && fast.next!=null){
        //     slow = slow.next;
        //     fast = fast.next.next;
        //     if(slow)
        // }
        
        HashSet<ListNode> hs = new HashSet<>();
        
        if(head==null )
            return false;
        
        while(head!=null){
            if(!hs.contains(head)){
                hs.add(head);
                
                head=head.next;
            }
            if(hs.contains(head)){
                return true;
            }
        }
        
        return false;
    }
}