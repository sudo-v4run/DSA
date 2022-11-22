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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int n = preorder.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            hm.put(inorder[i],i);
        }
        
        return f(preorder,inorder,0,n-1,0,n-1,hm);
        
    }
    public static TreeNode f(int[] pre,int[] in, int preS, int preE,
                             int inS, int inE, HashMap<Integer,Integer> hm){
        
        if(preS>preE)
            return null;
        
        TreeNode root = new TreeNode(pre[preS]);
        
        int inPos = hm.get(pre[preS]);
        int noOfElesOnLeft = inPos - inS;
        
        root.left = f(pre,in,preS+1,preS+noOfElesOnLeft,inS,inPos-1,hm);
        root.right = f(pre,in,preS+noOfElesOnLeft+1,preE,inPos+1,inE,hm);
        
        return root;
    }
}