/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode a = headA;
        ListNode b = headB;
        
        while(a!=b){
            
            a = a==null?headB:a.next;
            b = b==null?headA:b.next;
            
        }
        
        return a;
        
           
        
//         if(headA==null||headB==null)
//             return null;
        
//         int headALen = length(headA);
//         int headBLen = length(headB);
        
//         while(!(headALen==headBLen)){
//             if(headALen>headBLen){
//                 headA = headA.next;
//                 headALen--;
//             }else{
//                 headB = headB.next;
//                 headBLen--;
//             }
//         }
        
//         while(headA!=null){
//             if(headA==headB){
//                 return headA;
//             }
//             headA = headA.next;
//             headB = headB.next;
//         }
        
//         return null;
        
        
        
        
        
        
        
//         if(headA==null||headB==null)
//             return null;
        
//         HashSet<ListNode> hs = new HashSet<>();
        
//         while(headA != null || headB !=null){
//             if(headA != null){
//                 if(!hs.contains(headA)){
//                     hs.add(headA);
//                     headA = headA.next;
//                 }else{
//                     return headA;
//                 }
//             }
//             if(headB != null){
//                 if(!hs.contains(headB)){
//                     hs.add(headB);
//                     headB = headB.next;
//                 }else{
//                     return headB;
//                 }
//             }
//         }
//         return null;
    }
    
    public static int length(ListNode node){
        int len = 0;
        while(node!=null){
            node = node.next;
            len++;
        }
        
        return len;
    }
    
}