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
    static int ans = -1;
    static int k = -1;
    public int kthSmallest(TreeNode root, int K) {
        k = K;
        
        inOrder(root);
        
        return ans;
        
    }
    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        
        inOrder(root.left);
        
        k--;
        
        if(k==0){
            ans = root.val;
            return;
        }
        
        inOrder(root.right);
    }
}