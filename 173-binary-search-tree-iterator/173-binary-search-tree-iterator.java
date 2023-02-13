
class BSTIterator {
    
    static Stack<TreeNode> s;
    
    // TC -> O(1) and SC -> O(H)...Use Morris Traversal for SC -> O(1)...

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        
        TreeNode cur = root;
        
        while(cur != null){
            s.add(cur);
            cur = cur.left;
        }
        
    }
    
    public int next() {
        int ans = s.peek().val;
        
        TreeNode temp = s.pop().right;
        
        while(temp != null){
            s.add(temp);
            temp = temp.left;
        }
        
        return ans;
    }
    
    public boolean hasNext() {
        
        return !s.isEmpty();
    }
}