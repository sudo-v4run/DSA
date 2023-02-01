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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        findParent(root,parent);
        
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> vis = new HashSet();
        
        q.add(target);
        vis.add(target);
        
        while(true){
            
            if(k--==0){
                break;
            }
            
            int sz = q.size();
            
            for(int i = 0 ; i < sz ; i++){
                TreeNode pop = q.poll();
                
                TreeNode parentOfPop = parent.get(pop);
                if(parent.containsKey(pop) && !vis.contains(parentOfPop)){
                    q.add(parentOfPop);
                    vis.add(parentOfPop);
                }
                
                if(pop.left != null && !vis.contains(pop.left)){
                    q.add(pop.left);
                    vis.add(pop.left);
                }
                if(pop.right != null && !vis.contains(pop.right)){
                    q.add(pop.right);
                    vis.add(pop.right);
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        
        return res;
    }
    public static void findParent(TreeNode root, 
                                  HashMap<TreeNode,TreeNode> parent){
        
        if(root == null){
            return;
        }
        
        if(root.left != null){
            parent.put(root.left,root);
        }
        if(root.right != null){
            parent.put(root.right,root);
        }
        
        findParent(root.left,parent);
        findParent(root.right,parent);
    }
}