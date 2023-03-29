class Solution {
    
    static int timer = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections){
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> ed : connections){
            int u = ed.get(0);
            int v = ed.get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        int dsc[] = new int[n];
        int low[] = new int[n];
        int vis[] = new int[n];
        
        dfs(0,vis,adj,-1,dsc,low,res);
        
        return res;
    }
    public static void dfs( int v, int vis[], ArrayList<ArrayList<Integer>> adj,
                            int parent, int dsc[], int low[], List<List<Integer>> res ){
        vis[v] = 1;
        dsc[v] = low[v] = timer++;
        
        for(int nei : adj.get(v)){
            if(nei == parent)
                continue;
            
            if(vis[nei] != 1){
                dfs(nei,vis,adj,v,dsc,low,res);
                low[v] = Math.min(low[v],low[nei]);
                
                // Check for Bridge
                if(low[nei] > dsc[v]){
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(v);
                    ans.add(nei);
                    res.add(ans);
                }
            }else{
                // BackEdge...Can't be bridge...
                
                low[v] = Math.min(low[v],low[nei]);
            }
        }
    }
}