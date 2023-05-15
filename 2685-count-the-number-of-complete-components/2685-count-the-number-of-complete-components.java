class Solution {
    
    static int edgs;
    static int nodes;
    
    public int countCompleteComponents(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int vis[] = new int[n];
        
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(vis[i] != 1){
                nodes = 0;
                edgs = 0;
                dfs(i,vis,adj);
                System.out.println(i+"  "+nodes+"   "+edgs);
                if(edgs == nodes*(nodes-1)){
                    ans++;
                }
            }
        }
        
        return ans;
    }
    public static void dfs(int v, int vis[], ArrayList<ArrayList<Integer>> adj){
        
        vis[v] =  1;
        nodes++;
        edgs += adj.get(v).size();
        
        for(int nei : adj.get(v)){
            if(vis[nei] != 1){
                dfs(nei,vis,adj);
            }
        }
    }
}