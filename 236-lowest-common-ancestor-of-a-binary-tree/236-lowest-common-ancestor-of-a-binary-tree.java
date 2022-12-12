/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        
        if(root.val==p.val || root.val == q.val){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left==null){
            return right;
        }
        
        if(right==null){
            return left;
        }
        
        return root;
        
    }
    
    
    
    
    
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         ArrayList<TreeNode> l1 = new ArrayList<>();
//         ArrayList<TreeNode> l2 = new ArrayList<>();
        
//         isPresent(root,p.val,l1);
//         isPresent(root,q.val,l2);
        
//         int i = l1.size()-1;
//         int j = l2.size()-1;
        
//         while(i>=0 && j>=0 && l1.get(i)==l2.get(j)){
//             i--;
//             j--;
//         }
        
//         return l1.get(i+1);
//     }
    
//     static boolean isPresent(TreeNode root,int target,ArrayList<TreeNode> ans){
//         if(root==null){
//             return false;
//         }
//         if(root.val==target||isPresent(root.left,target,ans)
//                            ||isPresent(root.right,target,ans)){
    
//             ans.add(root);
//             return true;
//         }
        
//         return false;
//     }
    
}