class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int v = numCourses;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < v ; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int pair[] : prerequisites){
            adj.get(pair[1]).add(pair[0]);
        }
        
        
        // BFS...
        
//         int indeg[] = new int[v];
//         findInDeg(adj,indeg);
        
//         Queue<Integer> q = new LinkedList<>();
        
//         for(int i = 0 ; i < numCourses ; i++){
//             if(indeg[i] == 0){
//                 q.add(i);
//             }
//         }
        
//         int cnt = 0;
        
//         while(!q.isEmpty()){
//             int pop = q.poll();
//             cnt++;
            
//             for(int nei : adj.get(pop)){
//                 indeg[nei]--;
//                 if(indeg[nei] == 0){
//                     q.add(nei);
//                 }
//             }
//         }
        
//         return cnt == numCourses;
        
        
        
        // DFS...
        
        HashSet<Integer> hs = new HashSet<>();
        int vis[] = new int[v];
        int cnt[] = new int[1];
        
        for(int i = 0 ; i < v ; i++){
            if(vis[i] != 1){
                if(dfs(i,adj,cnt,vis,hs)){
                    return false;
                }
            }
        }
        
        return cnt[0] == numCourses;
    }
    public static void findInDeg(ArrayList<ArrayList<Integer>> adj,int indeg[] ){
        
        for(ArrayList<Integer> neis : adj){
            for(int nei : neis){
                indeg[nei]++;
            }
        }
    }
    public static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj,
                               int cnt[], int vis[], HashSet<Integer> hs){
        
        vis[v] = 1;
        hs.add(v);
        
        for(int nei : adj.get(v)){
            if(vis[nei] != 1){
                if(dfs(nei,adj,cnt,vis,hs)){
                    return true;
                }
            }else if(hs.contains(nei)){
                return true;
            }
        }
        
        hs.remove(v);
        cnt[0]++;
        
        return false;
    }
}