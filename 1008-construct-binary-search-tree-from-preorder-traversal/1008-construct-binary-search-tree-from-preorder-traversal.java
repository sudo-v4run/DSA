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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderUtil(preorder,0,preorder.length-1);
    }
    public TreeNode bstFromPreorderUtil(int[] arr,int l,int r){
        if(l>r){
            return null;
        }
        
        TreeNode root = new TreeNode(arr[l]);
        int i = l;
        for( ; i <= r ; i++){
            if(arr[i]>arr[l]){
                break;
            }
        }
        
        root.left = bstFromPreorderUtil(arr,l+1,i-1);
        root.right = bstFromPreorderUtil(arr,i,r);
            
        return root;
    }
}