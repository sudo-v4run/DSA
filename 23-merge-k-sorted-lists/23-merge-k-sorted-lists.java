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
        
        while(k > 1){
            
            int sz = k%2==0 ? k/2 : (k/2) + 1;
            
            ListNode temp[] = new ListNode[sz];
            int j = 0;
                
            for(int i = 0 ; i < k ; i+=2){
                
                ListNode l1 = lists[i];
                ListNode l2 = i+1>=k ? null : lists[i+1];
                
                temp[j++] = merge(l1,l2);

            }
            
            lists = temp.clone();
            
            k = lists.length;
            
        }
        
        return lists[0];
        
        
        
        
        
//         if(lists.length==0){
//             return null;
//         }
        
//         int k = lists.length;
//         ListNode ans = new ListNode();
//         ListNode ansHead = ans;
//         boolean notFinished = true;
        
//         while(notFinished){
//             int min = Integer.MAX_VALUE;
//             notFinished = false;
//             int minPtr = k+1;
            
//             for(int i = 0 ; i < k ; i++){
//                 if(lists[i] !=null && lists[i].val<min){
//                     min = lists[i].val;
//                     minPtr = i;
//                 }
//                 if(lists[i] !=null){
//                     notFinished = true;
//                 }
//             }
//             if(!notFinished){
//                 break;
//             }
            
//             lists[minPtr] = lists[minPtr].next;
            
//             ans.next = new ListNode(min);
//             ans = ans.next;
//         }
        
//         return ansHead.next;
        
        
        
        
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
    
    public static ListNode merge(ListNode l1 , ListNode l2){
        
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val<=l2.val){
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            dummy.next = l1;
        }else{
            dummy.next = l2;
        }
        
        return head.next;
    }
}