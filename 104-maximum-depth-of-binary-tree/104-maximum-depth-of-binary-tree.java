
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return 1+Math.max(left,right);
        
        
        
        
        
        
        
        // Level Order Traversal....
        
//         if(root==null)
//             return 0;
        
//         Queue<TreeNode> q = new LinkedList<>();
        
//         q.add(root);
//         int maxD = 0;
        
//         while(!q.isEmpty()){
//             int sz = q.size();
//             for(int i = 0 ; i < sz ; i++){
//                 TreeNode cur = q.poll();
//                 if(cur.left!=null){
//                     q.add(cur.left);
//                 }
//                 if(cur.right!=null){
//                     q.add(cur.right);
//                 }
                
//             }
//             maxD++;
            
//         }
        
//         return maxD;
    }
}