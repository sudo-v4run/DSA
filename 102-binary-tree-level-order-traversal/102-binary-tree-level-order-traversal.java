class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root==null)
            return res;
        
        q.add(root);
        
        while(!q.isEmpty()){
            ArrayList<Integer> ans = new ArrayList<>();
            int sz = q.size();
            
            for(int i = 0 ; i < sz ; i++){
                
                TreeNode pop = q.poll();
                ans.add(pop.val);
                
                if(pop.left!=null)
                    q.add(pop.left);
                
                if(pop.right!=null)
                    q.add(pop.right);
                
            }
            res.add(ans);
        }
        
        return res;
        
    }
}