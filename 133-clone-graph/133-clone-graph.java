class Solution {
    public Node cloneGraph(Node root){
        
        if(root == null){
            return null;
        }
        
        HashMap<Node,Node> hm = new HashMap<>();
        
        return dfs(root,hm);
    }
    public static Node dfs(Node root, HashMap<Node,Node> hm){

        ArrayList<Node> adj = new ArrayList<>();
        
        Node clone = new Node(root.val);
        hm.put(root,clone);
        
        for(Node nei : root.neighbors){
            if(!hm.containsKey(nei)){
                dfs(nei,hm);
            }
            adj.add(hm.get(nei));  
                // hm.get() will not return null coz we first traverse and then add to adj
        }
        
        clone.neighbors = adj;
        
        return clone;
    }
    
    
//     public Node cloneGraph(Node root) {
        
//         if(root == null){
//             return null;
//         }
        
//         HashMap<Integer,Node> hm = new HashMap<>();
        
//         it(root,hm);
        
//         HashSet<Node> hs = new HashSet<>();
        
//         f(root,hm,hs);
        
//         return hm.get(root.val);
//     }
//     public static void it(Node root, HashMap<Integer,Node> hm){
        
//         hm.put(root.val,new Node(root.val));
        
//         for(Node nei : root.neighbors){
//             if(!hm.containsKey(nei.val)){
//                 it(nei,hm);
//             }
//         }
//     }
//     public static void f(Node root, HashMap<Integer,Node> hm, HashSet<Node> hs){
        
//         if(root == null){
//             return;
//         }
        
//         ArrayList<Node> adj = new ArrayList<>();
        
//         hs.add(root);
        
//         for(Node nei : root.neighbors){
//             adj.add(hm.get(nei.val));
//             if(!hs.contains(nei)){
//                 f(nei,hm,hs);
//             }
//         }
        
//         hm.get(root.val).neighbors = adj;
//     }
}