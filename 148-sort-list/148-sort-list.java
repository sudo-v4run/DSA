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
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)->{return a.val-b.val;});
        ListNode newH = head;
        
        while(newH!=null){
            q.add(newH);
            newH = newH.next;
        }
        
        ListNode ans = new ListNode();
        ListNode res = ans;
        
        while(!q.isEmpty()){
            ans.next = new ListNode(q.poll().val);
            ans = ans.next;
        }
        
        return res.next;
    }
}