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
    public boolean isPalindrome(ListNode head) {
        
        // TC - O(N) and SC = O(1) while preserving the structure of input list..
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){             // for odd no.of Nodes...
            slow = slow.next;
        }
        
        ListNode prev = null;
        while(slow!=null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        ListNode nextNode = null;
        while(prev!=null){
            ListNode temp = prev.next;
            if(prev.val!=head.val)
                return false;
            prev.next = nextNode;
            nextNode = prev;
            prev = temp;
            head = head.next;
        }
        
        return true;
        
        
        
        
        
        
        // TC - O(N) and SC = O(1) while NOT preserving the structure of input list..
        
//         ListNode slow = head;
//         ListNode fast = head;
        
//         while(fast!=null && fast.next!=null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         if(fast!=null){             // for odd no.of Nodes...
//             slow = slow.next;
//         }
        
//         ListNode prev = null;
//         while(slow!=null){
//             ListNode temp = slow.next;
//             slow.next = prev;
//             prev = slow;
//             slow = temp;
//         }
        
//         while(prev!=null){
//             if(prev.val!=head.val)
//                 return false;
//             prev = prev.next;
//             head = head.next;
//         }
        
//         return true;
        
        
        
        
        
        
//         ArrayList<Integer> res = new ArrayList<>();
        
//         // String res = "";
        
//         while(head!=null){
//             res.add(head.val);
            
//             // res+=String.valueOf(head.val);
            
//             head = head.next;
//         }
        
//         int i = 0;
//         int j = res.size()-1;
        
//         while(i<=j){
//             if(res.get(i)!=res.get(j)){
//                 return false;
//             }
//             i++;
//             j--;
//         }
        
//         return true;
    }
}