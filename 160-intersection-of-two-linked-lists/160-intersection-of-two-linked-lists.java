
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode a = headA;
        ListNode b = headB;
        
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
        return a;
        
        
        
        
//         int headASize = getSize(headA);
//         int headBSize = getSize(headB);
        
//         while(headASize != headBSize){
//             if(headASize > headBSize){
//                 headA = headA.next;
//                 headASize--;
//             }else{
//                 headB = headB.next;
//                 headBSize--;
//             }
//         }
        
//         while(headA != null && headB != null){
//             if(headA == headB){
//                 return headA;
//             }
//             headA = headA.next;
//             headB = headB.next;
//         }
        
//         return null;
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