class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        
        int n = edges.size();
        
        // DFS...
        
//         int vis[] = new int[n];
//         int res[] = new int[n];
        
//         for(int i = 0 ; i < n ; i++){
//             if(vis[i] != 1)
//                 dfs1(i,vis,res,edges);
//         }
        
//         return res;
        
        
        // Stack...Simple...
        
        int res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0 ; i < n ; i++){
            
            int v = i;
            
            if(res[v] != 0){
                continue;
            }
            
            if(res[edges.get(v)] != 0){
                res[v] = res[edges.get(v)]+1;
                continue;
            }

            while(!hs.contains(v)){
                hs.add(v);
                s.add(v);
                v = edges.get(v);
            }
            
            if(hs.contains(v) && res[v] == 0){
                // hs.contains(v) and res[v] != 0 means we have computed the values 
                // for the cycle. No need to compute again and also 
                // s.indexOf(v) gives -1 if we again try to compute.
                
                int cycleLen = s.size() - s.indexOf(v);

                for(int temp = 0 ; temp < cycleLen ; temp++){
                    res[s.pop()] = cycleLen;
                }
            }

            while(!s.isEmpty()){
                v = s.pop();
                res[v] = res[edges.get(v)]+1;
            }
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