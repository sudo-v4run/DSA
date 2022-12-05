class Solution {
    public boolean canFinish(int numCourses, int[][] preReq) {
        
        // List<List<Integer>> adj = new ArrayList<List<Integer>>();
        
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        
        for(int i = 0 ; i < numCourses ; i++){
            adj.put(i,new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < preReq.length ; i++){
            adj.get(preReq[i][0]).add(preReq[i][1]);
        }
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0 ; i < numCourses ; i++){
            if(!dfs(i,adj,hs)){
                return false;
            }
        }
        
        return true;
        
    }
    public static boolean dfs(int node, HashMap<Integer,ArrayList<Integer>> adj ,
                            HashSet<Integer> hs){
        
        if(hs.contains(node)){
            return false;
        }
        
        hs.add(node);
        
        for(int nei : adj.get(node)){
            if(!dfs(nei,adj,hs)){
                return false;
            }
        }
        
        adj.put(node,new ArrayList<>());
        
        hs.remove(node);
        
        return true;
    }
}