class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        
        int v = adj.length;
        List<Integer> ans = new ArrayList<>();
        
        
        // DFS...
        
//         int vis[] = new int[v];
//         HashSet<Integer> hs = new HashSet();
//         int safeNodes[] = new int[v];
        
//         for(int i = 0 ; i < v ; i++){
//             if(vis[i] != 1){
//                 isCycle(i,adj,vis,hs,safeNodes);
//             }
//         }
        
//         for(int i = 0 ; i < v ; i++){
//             if(safeNodes[i] == 1){
//                 ans.add(i);
//             }
//         }
        
//         return ans;
        
        
        // BFS....
        
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        
        for(int i = 0 ; i < v ; i++){
            revAdj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < adj.length ; i++){
            for(int nei : adj[i]){
                revAdj.get(nei).add(i);
            }
        }
        
        int indeg[] = new int[v];
        
        for(ArrayList<Integer> neis : revAdj){
            for(int nei : neis){
                indeg[nei]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < v ; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int pop = q.poll();
            ans.add(pop);
            
            for(int nei : revAdj.get(pop)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.add(nei);
                }
            }
        }
        
        Collections.sort(ans);
        
        return ans;
        
    }
    public static boolean isCycle( int v,int adj[][],int vis[],
                                   HashSet<Integer> hs, int safeNodes[] ){
        
        vis[v] = 1;
        hs.add(v);
        
        for(int nei : adj[v]){
            if(vis[nei] == 0){
                if(isCycle(nei,adj,vis,hs,safeNodes)){
                    return true;
                }
            }else if(hs.contains(nei)){
                return true;
            }
        }
        
        hs.remove(v);
        safeNodes[v] = 1;
        
        return false;
    }
}