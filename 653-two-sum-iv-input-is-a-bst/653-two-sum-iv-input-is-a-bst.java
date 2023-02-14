
class Solution {
    
    static Stack<TreeNode> nextSt = new Stack<>();
    static Stack<TreeNode> b4St = new Stack<>();
    
    public boolean findTarget(TreeNode root, int k) {
        
        pushAll(root,true);
        pushAll(root,false);
        
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
            pushAll(temp.right,true);
        }
        
        return temp.val;
    }
    public static int getBefore(){
        TreeNode temp = b4St.pop();
        
        if(temp.left != null){
            pushAll(temp.left,false);
        }
        
        return temp.val;
    }
    public static void pushAll(TreeNode root, boolean toLeft){
        TreeNode cur = root;
        
        while(cur != null){
            if(toLeft){
                nextSt.push(cur);
                cur = cur.left;
            }else{
                b4St.push(cur);
                cur = cur.right;
            }
        }
    }
}