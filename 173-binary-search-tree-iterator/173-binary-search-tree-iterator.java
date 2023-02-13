
class BSTIterator {
    
//     static Stack<TreeNode> s;
    
//     // TC -> O(1) and SC -> O(H)...

//     public BSTIterator(TreeNode root) {
//         s = new Stack<>();
        
//         TreeNode cur = root;
        
//         while(cur != null){
//             s.add(cur);
//             cur = cur.left;
//         }
        
//     }
    
//     public int next() {
//         int ans = s.peek().val;
        
//         TreeNode temp = s.pop().right;
        
//         while(temp != null){
//             s.add(temp);
//             temp = temp.left;
//         }
        
//         return ans;
//     }
    
//     public boolean hasNext() {
        
//         return !s.isEmpty();
//     }
    
    
    
    // Morris Traversal... SC -> O(1)...
    
    TreeNode cur;
    
    public BSTIterator(TreeNode root) {
        cur = root;    
    }
    
    public int next() {
        int ans = -1;
        
        while(cur != null){
            if(cur.left == null){
                ans = cur.val;
                cur = cur.right;
                break;
            }else{
                TreeNode temp = cur.left;
                
                while(temp.right != null && temp.right != cur){
                    temp = temp.right;
                }

                if(temp.right == null){
                    temp.right = cur;
                    cur = cur.left;
                }else{
                    ans = cur.val;
                    temp.right = null;
                    cur = cur.right;
                    break;
                }
            }
        }
        
        return ans;
    }
    
    public boolean hasNext() {
        
        return cur != null;
    }
    
}