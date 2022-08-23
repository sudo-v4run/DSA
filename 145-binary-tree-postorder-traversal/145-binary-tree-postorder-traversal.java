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
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
//         if(root==null)
//             return res;
//         postorderTraversal(root.left);
//         postorderTraversal(root.right);
//         res.add(root.val);
        
//         return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if(root==null){
            return res;
        }
        
        s1.push(root);
        
        while(!s1.isEmpty()){
            TreeNode pop = s1.pop();
            s2.push(pop);
            if(pop.left!=null){
                s1.push(pop.left);
            }
            if(pop.right!=null){
                s1.push(pop.right);
            }
        }
        
        while(!s2.isEmpty()){
            res.add(s2.pop().val);
        }
        
        return res;
        
    }
}