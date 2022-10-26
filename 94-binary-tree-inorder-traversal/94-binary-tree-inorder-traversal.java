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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<Integer>();
        
//         inOrder(root,res);
        
//         return res;
        
        
        
        
        // Iterative ... Using Stack ... 
        
//         Stack<TreeNode> s = new Stack<>();
        
//         TreeNode cur = root;
        
//         while(cur!=null || !s.isEmpty()){
//             if(cur!=null){
//                 s.push(cur);
//                 cur = cur.left;
//             }else{
//                 cur = s.pop();
//                 res.add(cur.val);
//                 cur = cur.right;
//             }
//         }
        
//         return res;
        
        
        
        // Morris .....
        
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode temp = cur.left;
                while(temp.right!=null && temp.right != cur){
                    temp = temp.right;
                }
                if(temp.right==cur){
                    temp.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }else{
                    temp.right = cur;
                    cur = cur.left;
                }
            }
            
        }
        
        return res;
        
    }
    public static void inOrder(TreeNode root,List<Integer> res){
        if(root == null)
            return;
        
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }
}