class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        f(root,res,0);
        
        return res;
        
        
        
        
        // 2 Stack....
        
//         List<List<Integer>> res = new ArrayList<List<Integer>>();        
//         Stack<TreeNode> s1 = new Stack<>();
//         Stack<TreeNode> s2 = new Stack<>();
//         ArrayList<Integer> ans;
        
//         if(root==null)
//             return res;
        
//         s1.push(root);
        
//         while(!s1.isEmpty() || !s2.isEmpty()){
            
//             ans = new ArrayList<>();
        
//             while(!s1.isEmpty()){
                    
//                 TreeNode pop = s1.pop();
//                 ans.add(pop.val);

//                 if(pop.left!=null){
//                     s2.push(pop.left);
//                 }
//                 if(pop.right!=null){
//                     s2.push(pop.right);
//                 }

//             }
            
//             if(!ans.isEmpty())
//                 res.add(ans);
            
            
//             ans = new ArrayList<>();
            
//             while(!s2.isEmpty()){
                    
//                 TreeNode pop = s2.pop();
//                 ans.add(pop.val);

//                 if(pop.right!=null){
//                     s1.push(pop.right);
//                 }
//                 if(pop.left!=null){
//                     s1.push(pop.left);
//                 }

//             }
            
//             if(!ans.isEmpty())
//                 res.add(ans);
            
//         }
        
//         return res;
        
        

        
        
        
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
//                 if(right)
//                     ans.add(pop.val);
//                 else
//                     ans.add(0,pop.val);
                
//                 if(pop.left!=null)
//                     q.add(pop.left);
                
//                 if(pop.right!=null)
//                     q.add(pop.right);
                
//             }
            
//             res.add(ans);
//             right = !right;
//         }
        
//         return res;
        
    }
    public static void f(TreeNode root,List<List<Integer>> res, int level){
        if(root==null){
            return;
        }
        
        if(res.size()==level){
            res.add(new ArrayList<Integer>());
        }
        
        if(level%2==0){
            res.get(level).add(root.val);
        }else{
            res.get(level).add(0,root.val);
        }
        
        f(root.left,res,level+1);
        f(root.right,res,level+1);
    }
}