/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root==null)
            return res;
        
        q.add(root);
        
        boolean right = true;
        
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
            
            if(right){
                res.add(ans);
            }
            else{
                Collections.reverse(ans);
                res.add(ans);
            }
            right = !right;
        }
        
        return res;
    }
}