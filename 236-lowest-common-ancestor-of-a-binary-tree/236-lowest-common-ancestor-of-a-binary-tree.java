class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        
        if((root.val == p.val) || (root.val == q.val)){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left != null && right != null){
            return root;
        }
        
        if(left != null){
            return left;
        }
        
        if(right != null){
            return right;
        }
        
        return null;
    }
    
    
    
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         ArrayList<TreeNode> pArr = new ArrayList<>();
//         ArrayList<TreeNode> qArr = new ArrayList<>();
        
//         findPath(root,p,pArr);
//         findPath(root,q,qArr);
        
//         int i = pArr.size()-1;
//         int j = qArr.size()-1;
        
//         while(i>=0 && j>=0 && pArr.get(i)==qArr.get(j)){
//             i--;
//             j--;
//         }
        
//         return pArr.get(i+1);
//     }
//     public static boolean findPath(TreeNode root, TreeNode x, 
//                                         ArrayList<TreeNode> arr){
        
//         if(root == null){
//             return false;
//         }
        
//         if(root.val == x.val){
//             arr.add(root);
//             return true;
//         }
        
//         boolean left = findPath(root.left,x,arr);
//         boolean right = findPath(root.right,x,arr);
        
//         if(left || right){
//             arr.add(root);
//             return true;
//         }
        
//         return false;
//     }
    
}