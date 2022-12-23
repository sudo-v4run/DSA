/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode orig = head;
        ListNode temp = head.next;
        ListNode even = head.next;
        
        while(temp!=null && temp.next!=null){
            head.next = temp.next;
            head = head.next;
            
            temp.next = head.next;
            temp = temp.next;
        }
        
        head.next = even;
        
        return orig;
    }
}