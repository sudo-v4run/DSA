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
        
        if(lists.length==0){
            return null;
        }
        
        int k = lists.length;
        ListNode ans = new ListNode();
        ListNode ansHead = ans;
        boolean notFinished = true;
        
        while(notFinished){
            
            ListNode min = new ListNode(Integer.MAX_VALUE);
            notFinished = false;
            for(int i = 0 ; i < k ; i++){
                if(lists[i] !=null && lists[i].val!=(int)1e7
                                   && lists[i].val<min.val){
                    min = lists[i];
                }
                if(lists[i] !=null && lists[i].val!=(int)1e7){
                    notFinished = true;
                }
            }
            if(!notFinished){
                break;
            }
            ans.next = new ListNode(min.val);
            ans = ans.next;
            
            if(min.next!=null){
                remove(min);
            }else{
                min.val = (int)1e7;
            }
            
        }
        
        return ansHead.next;
        
        
        
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
        
//         int k = lists.length;
        
//         for(int i = 0 ; i < k ; i++){
//             ListNode listHead = lists[i];
//             while(listHead!=null){
//                 pq.add(listHead.val);
//                 listHead = listHead.next;
//             }
//         }
        
//         ListNode ansHead = new ListNode();
//         ListNode res = ansHead;
        
//         while(!pq.isEmpty()){
//             ansHead.next = new ListNode(pq.poll());
//             ansHead = ansHead.next;
//         }
        
//         return res.next;
    }
    public static void remove(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}