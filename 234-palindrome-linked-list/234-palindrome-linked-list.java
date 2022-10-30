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
        
        ArrayList<Integer> res = new ArrayList<>();
        
        // String res = "";
        
        while(head!=null){
            res.add(head.val);
            
            // res+=String.valueOf(head.val);
            
            head = head.next;
        }
        
        int i = 0;
        int j = res.size()-1;
        
        while(i<=j){
            if(res.get(i)!=res.get(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}