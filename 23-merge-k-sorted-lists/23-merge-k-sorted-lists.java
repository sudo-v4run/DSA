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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int k = lists.length;
        
        for(int i = 0 ; i < k ; i++){
            ListNode listHead = lists[i];
            while(listHead!=null){
                pq.add(listHead.val);
                listHead = listHead.next;
            }
        }
        
        ListNode ansHead = new ListNode();
        ListNode ans = ansHead;
        
        while(!pq.isEmpty()){
            ansHead.next = new ListNode(pq.poll());
            ansHead = ansHead.next;
        }
        
        return ans.next;
    }
}