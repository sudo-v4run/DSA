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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        rightSideView(root,0,res);
        return res;
    }
    void rightSideView(TreeNode root,int level,ArrayList<Integer> res ){
        if(root==null){
            return;
        }
        
        if(res.size()==level){
            res.add(root.val);
        }
        rightSideView(root.right,level+1,res);
        rightSideView(root.left,level+1,res);
    }
}