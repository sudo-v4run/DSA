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
        
        
        // 2 Stack....
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<Integer> ans;
        
        if(root==null)
            return res;
        
        s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            
            ans = new ArrayList<>();
        
            while(!s1.isEmpty()){
                    
                TreeNode pop = s1.pop();
                ans.add(pop.val);

                if(pop.left!=null){
                    s2.push(pop.left);
                }
                if(pop.right!=null){
                    s2.push(pop.right);
                }

            }
            
            if(!ans.isEmpty())
                res.add(ans);
            
            
            ans = new ArrayList<>();
            
            while(!s2.isEmpty()){
                    
                TreeNode pop = s2.pop();
                ans.add(pop.val);

                if(pop.right!=null){
                    s1.push(pop.right);
                }
                if(pop.left!=null){
                    s1.push(pop.left);
                }

            }
            
            if(!ans.isEmpty())
                res.add(ans);
            
        }
        
        return res;
        
        
        
        
        
        
        
        
//         // 2 Stack....
        
//         List<List<Integer>> res = new ArrayList<List<Integer>>();        
//         Stack<TreeNode> s1 = new Stack<>();
//         Stack<TreeNode> s2 = new Stack<>();
        
//         if(root==null)
//             return res;
        
//         boolean right = true;
        
//         s1.push(root);
        
//         while(!s1.isEmpty() || !s2.isEmpty()){
            
//             ArrayList<Integer> ans = new ArrayList<>();
        
//             if(right){
//                 while(!s1.isEmpty()){
                    
//                     TreeNode pop = s1.pop();
//                     ans.add(pop.val);
                    
//                     if(pop.left!=null){
//                         s2.push(pop.left);
//                     }
//                     if(pop.right!=null){
//                         s2.push(pop.right);
//                     }
                    
//                 }
//             }else{
//                 while(!s2.isEmpty()){
                    
//                     TreeNode pop = s2.pop();
//                     ans.add(pop.val);
                    
//                     if(pop.right!=null){
//                         s1.push(pop.right);
//                     }
//                     if(pop.left!=null){
//                         s1.push(pop.left);
//                     }
                    
//                 }
//             }
            
//             res.add(ans);
            
//             right = !right;
            
//         }
        
//         return res;
        
        
        
        
        
        
        
        
        
        
        
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         Queue<TreeNode> q = new LinkedList<>();
        
//         if(root==null)
//             return res;
        
//         q.add(root);
        
//         boolean right = true;
        
//         while(!q.isEmpty()){
//             ArrayList<Integer> ans = new ArrayList<>();
//             int sz = q.size();
            
//             for(int i = 0 ; i < sz ; i++){
                
//                 TreeNode pop = q.poll();
//                 ans.add(pop.val);
                
//                 if(pop.left!=null)
//                     q.add(pop.left);
                
//                 if(pop.right!=null)
//                     q.add(pop.right);
                
//             }
            
//             if(right){
//                 res.add(ans);
//             }
//             else{
//                 Collections.reverse(ans);
//                 res.add(ans);
//             }
//             right = !right;
//         }
        
//         return res;
    }
}