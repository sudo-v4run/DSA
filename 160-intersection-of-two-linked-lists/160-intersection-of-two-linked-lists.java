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
        
        if(headA==null||headB==null)
            return null;
        
        HashSet<ListNode> hs = new HashSet<>();
        
        while(headA != null || headB !=null){
            if(headA != null){
                if(!hs.contains(headA)){
                    hs.add(headA);
                    headA = headA.next;
                }else{
                    return headA;
                }
            }
            if(headB != null){
                if(!hs.contains(headB)){
                    hs.add(headB);
                    headB = headB.next;
                }else{
                    return headB;
                }
            }
        }
        return null;
    }
}