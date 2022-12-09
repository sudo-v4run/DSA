class Solution {
    // BFS...
    
    public int[] findOrder(int numCourses, int[][] preReq) {
        
        int indeg[] = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < preReq.length ; i++){
            adj.get(preReq[i][1]).add(preReq[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < numCourses ; i++){
            for(int nei : adj.get(i)){
                indeg[nei]++;
            }
        }
        
        for(int i = 0 ; i < numCourses ; i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        
        int res[] = new int[numCourses];
        int k = 0;
        
        while(!q.isEmpty()){
            int pop = q.poll();
            res[k++] = pop;
            
            for(int nei : adj.get(pop)){
                indeg[nei]--;
                if(indeg[nei]==0){
                    q.add(nei);
                }
            }
        }
        
        if(k==numCourses){
            return res;
        }
        return new int[]{};
    }
    
    
    
    // DFS...
    
//     public int[] findOrder(int numCourses, int[][] preReq) { 
        
//         HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        
//         for(int i = 0 ; i < numCourses ; i++){
//             adj.put(i,new ArrayList<Integer>());
//         }
        
//         for(int i = 0 ; i < preReq.length ; i++){
//             adj.get(preReq[i][0]).add(preReq[i][1]);
//         }
        
//         int vis[] = new int[numCourses];
//         HashSet<Integer> hs = new HashSet<>();
//         ArrayList<Integer> res = new ArrayList<>();
        
//         for(int i = 0 ; i < numCourses ; i++){
//             if(!dfs(i,adj,vis,res,hs)){
//                 return new int[]{};
//             }
//         }
        
//         int ans[] = new int[res.size()];
//         int k = 0;
        
//         for(int i : res){
//             ans[k++] = i;
//         }
        
//         return ans;
//     }
//     public static boolean dfs(int node,HashMap<Integer,ArrayList<Integer>> adj,
//                       int vis[], ArrayList<Integer> res, HashSet<Integer> hs){
        
//         if(hs.contains(node)){
//             return false;
//         }
        
//         if(vis[node]==1){
//             return true;
//         }
        
//         hs.add(node);
        
//         for(int nei : adj.get(node)){
//             if(!dfs(nei,adj,vis,res,hs)){
//                 return false;
//             }
//         }
        
//         vis[node] = 1;
//         res.add(node);
//         hs.remove(node);
        
//         return true;
//     }
    
}