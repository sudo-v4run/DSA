
class Solution {
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        if(head == null){
            return true;
        }
        
        if(root == null){
            return false;
        }
        
        return f(root,head) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }
    public boolean f(TreeNode root, ListNode llhead){
        
        if(llhead == null){
            return true;
        }
        
        if(root == null){
            return false;
        }
        
        if(root.val == llhead.val){
            
            if(f(root.left,llhead.next)  || f(root.right,llhead.next)){
                return true;
            }
        }
        
        return false;
    }
}