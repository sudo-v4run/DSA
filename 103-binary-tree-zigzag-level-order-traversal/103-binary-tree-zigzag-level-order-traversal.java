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
        Stack<TreeNode> s1 = new Stack<>();
	    Stack<TreeNode> s2 = new Stack<>();
	    List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> res;
	    if(root==null){
            return ans;
        }
	    s1.push(root);
	    
	    while(!s1.isEmpty()||!s2.isEmpty()){
            res = new ArrayList<>();
	        while(!s1.isEmpty()){
	            TreeNode pop = s1.pop();
	            res.add(pop.val);
	            if(pop.left!=null)
	                s2.push(pop.left);
	            if(pop.right!=null)
	                s2.push(pop.right);   
	        }
            if(!res.isEmpty())
                ans.add(res);
            
            res = new ArrayList<>();
	        while(!s2.isEmpty()){
	            TreeNode pop = s2.pop();
	            res.add(pop.val);
	            if(pop.right!=null)
	                s1.push(pop.right);
	            if(pop.left!=null)
	                s1.push(pop.left);
	        }
            if(!res.isEmpty())
                ans.add(res);
	    }
	    
	    return ans;
    }
}