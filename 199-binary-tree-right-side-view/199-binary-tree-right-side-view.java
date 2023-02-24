class Solution {
    
    static ArrayList<Integer> res;
    
    public List<Integer> rightSideView(TreeNode root) {
        
        res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        f(root,0);
        
        return res;
    }
    public static void f(TreeNode root,int lvl){
        if(root == null){
            return;
        }
        
        if(res.size()==lvl){
            res.add(root.val);
        }
        
        f(root.right,lvl+1);
        f(root.left,lvl+1);
    }
}