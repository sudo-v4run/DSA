
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        return f(head,null);
    }
    public TreeNode f(ListNode start, ListNode end){
        
        if(start == end){
            return null;
        }
        
        // Find mid of LL coz that will become the current Head...
        
        ListNode slow = start;
        ListNode fast = start;
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode curHead = new TreeNode(slow.val);
        
        curHead.left = f(start,slow);
        curHead.right = f(slow.next,end);
        
        return curHead;
    }
}