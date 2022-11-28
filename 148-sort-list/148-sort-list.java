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
    
    public ListNode sortList(ListNode head){
        if(head==null || head.next == null){
            return head;
        }
        
        ListNode mid = findMid(head);
        
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        
        left = sortList(left);
        right = sortList(right);
        
        return merge(left,right);
        
    }
    public static ListNode merge(ListNode left, ListNode right){
        if(left==null)
            return right;
        
        if(right==null)
            return left;
        
        ListNode temp = new ListNode();
        ListNode ans = temp;
        
        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next = left;
                temp = left;
                left = left.next;
            }else{
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }
        
        if(left!=null){
            temp.next = left;
        }else{
            temp.next = right;
        }
        
        return ans.next;
    }
    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
//     public ListNode sortList(ListNode head) {
//         PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)->{return a.val-b.val;});
//         ListNode newH = head;
        
//         while(newH!=null){
//             q.add(newH);
//             newH = newH.next;
//         }
        
//         ListNode ans = new ListNode();
//         ListNode res = ans;
        
//         while(!q.isEmpty()){
//             ans.next = new ListNode(q.poll().val);
//             ans = ans.next;
//         }
        
//         return res.next;
//     }
    
}