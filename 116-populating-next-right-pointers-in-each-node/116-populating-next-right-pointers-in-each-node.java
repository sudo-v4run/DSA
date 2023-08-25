class Solution {
    public Node connect(Node root) {
        
//         if(root==null)
//             return root;
        
//         Node cur = root;
//         Node nxt = cur.left;
        
//         while(cur!=null && nxt!=null){
            
//             cur.left.next = cur.right;
            
//             if(cur.next != null){
//                 cur.right.next = cur.next.left;
//                 cur = cur.next;
//             }else{
//                 cur = nxt;
//                 nxt = cur.left;
//             }
            
//         }
        
//         return root;
        
        f(root);
        
        return root;
        
        
        
//         Queue<Node> q = new LinkedList<>();
        
//         if(root==null)
//             return null;
        
//         q.add(root);
        
//         while(!q.isEmpty()){
            
//             int sz = q.size();
            
//             for(int i = 0 ; i < sz ; i++){
                
//                 Node pop = q.poll();
                
//                 pop.next = i==sz-1?null:q.peek();
                
//                 if(pop.left!=null)
//                     q.add(pop.left);
                
//                 if(pop.right!=null)
//                     q.add(pop.right);
                
//             }
//         }
        
//         return root;
        
        
        
        
        
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
    public static void f(Node root){
        
        if(root == null){
            return;
        }
        
        if(root.left != null){
            root.left.next = root.right;
        }
        
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }
        
        f(root.left);
        f(root.right);
    }
}