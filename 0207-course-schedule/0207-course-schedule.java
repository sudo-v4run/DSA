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
        
        
        // BFS using HashSet or ParentMap will not work...
        // 0 -> 1 ; 3 -> 1 : Test Case eg where BFS fails 
        // In the above eg, cycle does not exist 
        // but in case of hs method, hs will contain 1 when reach 3 (after finishing 0) and 
        // returns true. Also in case of parentMap, when we reach 3 (after finishing 0),
        // vis[1] == 1 and parent of 1 != 3. So, it returns true.
        // But modified BFS - Kahn's Algo (Topological Sort) can be used...
        
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
        
        for(int i = 0 ; i < v ; i++){
            if(vis[i] != 1){
                if(isCycle(i,adj,vis,hs)){
                    return false;
                }
            }
        }
        
        return true;
    }
    public static void findInDeg(ArrayList<ArrayList<Integer>> adj,int indeg[] ){
        
        for(ArrayList<Integer> neis : adj){
            for(int nei : neis){
                indeg[nei]++;
            }
        }
    }
    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj,
                               int vis[], HashSet<Integer> hs){
        
        vis[v] = 1;
        hs.add(v);
        
        for(int nei : adj.get(v)){
            if(hs.contains(nei)){
                return true;
            }
            if(vis[nei] != 1){
                if(isCycle(nei,adj,vis,hs)){
                    return true;
                }
            }
        }
        
        hs.remove(v);
        
        return false;
    }
}