
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int headASize = getSize(headA);
        int headBSize = getSize(headB);
        
        while(headASize > headBSize){
            headA = headA.next;
            headASize--;
        }
        
        while(headBSize > headASize){
            headB = headB.next;
            headBSize--;
        }
        
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    public static int getSize(ListNode head){
        if(head == null){
            return 0;
        }
        
        int sz = 0;
        
        while(head != null){
            sz++;
            head = head.next;
        }
        
        return sz;
    }
}