
class Solution {
    
    static Stack<TreeNode> nextSt = new Stack<>();
    static Stack<TreeNode> b4St = new Stack<>();
    
    public boolean findTarget(TreeNode root, int k) {
        
        pushAllLeft(root);
        pushAllRight(root);
        
        int i = getNext();
        int j = getBefore();
        
        while(i != j){
            
            int val = i+j;
            
            if(val == k){
                return true;
            }
            
            if(val < k){
                i = getNext();
            }else{
                j = getBefore();
            }
        }
        return false;
    }
    public static int getNext(){
        TreeNode temp = nextSt.pop();
        
        if(temp.right != null){
            pushAllLeft(temp.right);
        }
        
        return temp.val;
    }
    public static int getBefore(){
        TreeNode temp = b4St.pop();
        
        if(temp.left != null){
            pushAllRight(temp.left);
        }
        
        return temp.val;
    }
    public static void pushAllLeft(TreeNode root){
        TreeNode cur = root;
        
        while(cur != null){
            nextSt.push(cur);
            cur = cur.left;
        }
    }
    public static void pushAllRight(TreeNode root){
        TreeNode cur = root;
        
        while(cur != null){
            b4St.push(cur);
            cur = cur.right;
        }
    }
}