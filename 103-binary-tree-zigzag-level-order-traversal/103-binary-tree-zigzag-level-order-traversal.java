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
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root){
//         //RECURSIVE....
//         List<List<Integer>> ans = new ArrayList<>();
//         zigzag(root,ans,0);
//         return ans;
//     }
    
//     public static void zigzag(TreeNode root,List<List<Integer>> ans,int level){
//         if(root==null)
//             return;
//         if(ans.size()==level){
//             ArrayList<Integer> res = new ArrayList<>();
//             ans.add(res);
//         }
        
//         if(level%2==0){
//             ans.get(level).add(root.val);
//         }else{
//             ans.get(level).add(0,root.val);
//         }
        
//         zigzag(root.left,ans,level+1);
//         zigzag(root.right,ans,level+1);
//     }
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
if (root == null) return res;
Queue<TreeNode> queue = new LinkedList<>();
queue.add(root);
boolean zigzag = false;
while (!queue.isEmpty()) {
    List<Integer> level = new ArrayList<>();
    int cnt = queue.size();
    for (int i = 0; i < cnt; i++) {
        TreeNode node = queue.poll();
        if (zigzag) {
            level.add(0, node.val);
        }
        else {
            level.add(node.val);
        }
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
    res.add(level);
    zigzag = !zigzag;
}
return res;
    }
    
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        ITERATIVE.....
//         Stack<TreeNode> s1 = new Stack<>();
// 	    Stack<TreeNode> s2 = new Stack<>();
// 	    List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> res;
// 	    if(root==null){
//             return ans;
//         }
// 	    s1.push(root);
	    
// 	    while(!s1.isEmpty()||!s2.isEmpty()){
//             res = new ArrayList<>();
// 	        while(!s1.isEmpty()){
// 	            TreeNode pop = s1.pop();
// 	            res.add(pop.val);
// 	            if(pop.left!=null)
// 	                s2.push(pop.left);
// 	            if(pop.right!=null)
// 	                s2.push(pop.right);   
// 	        }
//             if(!res.isEmpty())
//                 ans.add(res);
            
//             res = new ArrayList<>();
// 	        while(!s2.isEmpty()){
// 	            TreeNode pop = s2.pop();
// 	            res.add(pop.val);
// 	            if(pop.right!=null)
// 	                s1.push(pop.right);
// 	            if(pop.left!=null)
// 	                s1.push(pop.left);
// 	        }
//             if(!res.isEmpty())
//                 ans.add(res);
// 	    }
	    
// 	    return ans;
//    }
}