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
    public ListNode modifiedList(int[] arr, ListNode head) {
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int x : arr){
            hs.add(x);
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        
        while(cur != null){
            ListNode temp = cur.next;
            while(temp != null && hs.contains(temp.val)){
                temp = temp.next;
            }
            cur.next = temp;
            cur = cur.next;
        }
        
        return dummy.next;
    }
}