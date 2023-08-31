/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node root) {
        
        if(root == null){
            return null;
        }
        
        HashMap<Integer,Node> hm = new HashMap<>();
        
        it(root,hm);
        
        HashSet<Node> hs = new HashSet<>();
        
        f(root,hm,hs);
        
        return hm.get(root.val);
    }
    public static void it(Node root, HashMap<Integer,Node> hm){
        
        hm.put(root.val,new Node(root.val));
        
        for(Node nei : root.neighbors){
            if(!hm.containsKey(nei.val)){
                it(nei,hm);
            }
        }
    }
    public static void f(Node root, HashMap<Integer,Node> hm, HashSet<Node> hs){
        
        if(root == null){
            return;
        }
        
        ArrayList<Node> adj = new ArrayList<>();
        
        hs.add(root);
        
        for(Node nei : root.neighbors){
            adj.add(hm.get(nei.val));
            if(!hs.contains(nei)){
                f(nei,hm,hs);
            }
        }
        
        hm.get(root.val).neighbors = adj;
    }
}