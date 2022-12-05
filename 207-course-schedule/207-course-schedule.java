class Solution {
    // BFS...
    
    public boolean canFinish(int numCourses, int[][] preReq) {
        
        int indeg[] = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < preReq.length ; i++){
            adj.get(preReq[i][0]).add(preReq[i][1]);
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
            return true;
        }
        return false;
    }
    
    
    
    // DFS...
    
//     public boolean canFinish(int numCourses, int[][] preReq) {
        
//         // List<List<Integer>> adj = new ArrayList<List<Integer>>();
        
//         // Using List of List is giving TLE .. 
        
//         HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        
//         for(int i = 0 ; i < numCourses ; i++){
//             adj.put(i,new ArrayList<Integer>());
//         }
        
//         for(int i = 0 ; i < preReq.length ; i++){
//             adj.get(preReq[i][0]).add(preReq[i][1]);
//         }
        
//         HashSet<Integer> hs = new HashSet<>();
        
//         for(int i = 0 ; i < numCourses ; i++){
//             if(!dfs(i,adj,hs)){
//                 return false;
//             }
//         }
        
//         return true;
        
//     }
//     public static boolean dfs(int node, HashMap<Integer,ArrayList<Integer>> adj ,
//                             HashSet<Integer> hs){
        
//         if(hs.contains(node)){
//             return false;
//         }
        
//         hs.add(node);
        
//         for(int nei : adj.get(node)){
//             if(!dfs(nei,adj,hs)){
//                 return false;
//             }
//         }
        
//         adj.put(node,new ArrayList<>());
        
//         hs.remove(node);
        
//         return true;
//     }
    
    
    
}