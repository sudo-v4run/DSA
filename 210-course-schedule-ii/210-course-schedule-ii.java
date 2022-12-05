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
}