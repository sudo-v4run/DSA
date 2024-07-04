class Solution {
    class Pair{
        
        int node, dist;
        
        Pair(int node, int dist){
            
            this.node = node;
            this.dist = dist;
        }
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        
        ArrayList<ArrayList<Integer>> adj1 = makeGraph(edges1);
        ArrayList<ArrayList<Integer>> adj2 = makeGraph(edges2);
        
        int dia1 = findDiameter(adj1);
        int dia2 = findDiameter(adj2);
        
        return Math.max(dia1,Math.max(dia2,((dia1+1)/2)+((dia2+1)/2)+1));
    }
    public ArrayList<ArrayList<Integer>> makeGraph(int[][] edges){
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < edges.length+1 ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
    public int findDiameter(ArrayList<ArrayList<Integer>> adj){
        
        Pair ans = new Pair(-1,-1);
        
        findFarthest(0,-1,0,ans,adj); // first farthest node
    
        findFarthest(ans.node,-1,0,ans,adj); // farthest distance from first farthest node
        
        return ans.dist;
    }
    public void findFarthest(int root, int par, int dist, 
                             Pair ans, ArrayList<ArrayList<Integer>> adj){
        
        if(dist > ans.dist){
            ans.node = root;
            ans.dist = dist;
        }
        
        for(int nei : adj.get(root)){
            if(nei != par){
                findFarthest(nei,root,1+dist,ans,adj);
            }
        }
    }
}