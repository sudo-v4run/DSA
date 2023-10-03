class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        
        int n = edges.size();
        
        int vis[] = new int[n];
        int res[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            if(vis[i] != 1)
                dfs1(i,vis,res,edges);
        }
        
        return res;
    }
    public static void dfs1(int v, int vis[], int res[], List<Integer> edges){
        
        vis[v] = 1;
        
        int nei = edges.get(v);
        
        if(vis[nei] != 1){
            dfs1(nei,vis,res,edges);
        }else if(vis[nei] == 1 && res[nei] == 0){
            HashSet<Integer> hs = new HashSet<>();
            dfs2(nei,hs,edges);
            for(int node : hs){
                res[node] = hs.size();
            }
        }
        
        if(res[v] == 0){
            res[v] = res[nei]+1;
        }
    }
    public static void dfs2(int v, HashSet<Integer> hs, List<Integer> edges){
        
        hs.add(v);
        
        int nei = edges.get(v);
        if(!hs.contains(nei)){
            dfs2(nei,hs,edges);
        }
    }
}