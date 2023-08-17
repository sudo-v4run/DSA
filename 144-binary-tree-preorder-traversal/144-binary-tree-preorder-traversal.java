
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        // Morris Traversal...
        
        List<Integer> res = new ArrayList<>();
        
        TreeNode cur = root;
        
        while(cur != null){
            
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode temp = cur.left;
                while(temp.right != null && temp.right != cur){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                }else{
                    temp.right = null;
                    cur = cur.right;
                }
                
            }
        }
        
        return res;
    }
}