
class Solution {
    
    static Stack<TreeNode> s1,s2;
    
    public boolean findTarget(TreeNode root, int k) {
    
        s1 = new Stack<>();
        s2 = new Stack<>();
        pushAll(root,true);
        pushAll(root,false);
        
        int i = next();
        int j = prev();
        
        while(i != j){
            
            if(i+j  == k){
                return true;
            }
            if(i+j < k){
                i = next();
            }else{
                j = prev();
            }
        }
        
        return false;
    }
    public int next(){
        int ans = -1;
        if(!s1.isEmpty()){
            TreeNode temp = s1.peek();
            ans = temp.val;
            s1.pop();
            if(temp.right != null){
                pushAll(temp.right,true);
            }
        }
        return ans;
    }
    public int prev(){
        int ans = -1;
        if(!s2.isEmpty()){
            TreeNode temp = s2.peek();
            ans = temp.val;
            s2.pop();
            if(temp.left != null){
                pushAll(temp.left,false);
            }
        }
        return ans;
    }
    public void pushAll(TreeNode root, boolean isLeft){
        TreeNode cur = root;
        while(cur != null){
            if(isLeft){
                s1.push(cur);
                cur = cur.left;
            }else{
                s2.push(cur);
                cur = cur.right;
            }
        }
    }
}