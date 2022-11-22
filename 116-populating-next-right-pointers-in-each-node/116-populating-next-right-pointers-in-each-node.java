class Solution {
    public Node connect(Node root) {
        
        Queue<Node> q = new LinkedList<>();
        
        if(root==null)
            return null;
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int sz = q.size();
            
            for(int i = 0 ; i < sz ; i++){
                
                Node pop = q.poll();
                
                pop.next = i==sz-1?null:q.peek();
                
                if(pop.left!=null)
                    q.add(pop.left);
                
                if(pop.right!=null)
                    q.add(pop.right);
                
            }
        }
        
        return root;
        
        
        
        
        
//         List<List<Node>> res = new ArrayList<List<Node>>();
//         Queue<Node> q = new LinkedList<>();
        
//         if(root==null)
//             return null;
        
//         q.add(root);
        
//         while(!q.isEmpty()){
//             ArrayList<Node> ans = new ArrayList<>();
//             int sz = q.size();
            
//             for(int i = 0 ; i < sz ; i++){
                
//                 Node pop = q.poll();
//                 ans.add(pop);
                
//                 if(pop.left!=null)
//                     q.add(pop.left);
                
//                 if(pop.right!=null)
//                     q.add(pop.right);
                
//             }
//             res.add(ans);
//         }
        
//         for(List<Node> lvl : res){
//             int i = 0;
//             for( ; i < lvl.size()-1 ; i++){
//                 Node cur = lvl.get(i);
//                 cur.next = lvl.get(i+1);
//             }
//             lvl.get(i).next = null;
//         }
        
//         return root;
    }
}