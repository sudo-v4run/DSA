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
        
        int indeg[] = new int[v];
        findInDeg(adj,indeg);
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < numCourses ; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        int cnt = 0;
        
        while(!q.isEmpty()){
            int pop = q.poll();
            cnt++;
            
            for(int nei : adj.get(pop)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.add(nei);
                }
            }
        }
        
        return cnt == numCourses;
    }
    public static void findInDeg(ArrayList<ArrayList<Integer>> adj,int indeg[] ){
        
        for(ArrayList<Integer> neis : adj){
            for(int nei : neis){
                indeg[nei]++;
            }
        }
    }
}