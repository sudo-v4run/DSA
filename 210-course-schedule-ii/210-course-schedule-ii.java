class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int v = numCourses;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < v ; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int pair[] : prerequisites){
            adj.get(pair[1]).add(pair[0]);
        }
        
        // BFS...
        
        int indeg[] = new int[v];
        findInDeg(adj,indeg);
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < numCourses ; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int pop = q.poll();
            res.add(pop);
            
            for(int nei : adj.get(pop)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.add(nei);
                }
            }
        }
        
        int ans[] = new int[res.size()];
        int k = 0;
        
        for(int ele : res){
            ans[k++] = ele;
        }
        
        if(ans.length == numCourses){
            return ans;
        }
        return new int[]{};
    }
    public static void findInDeg(ArrayList<ArrayList<Integer>> adj,int indeg[] ){
        
        for(ArrayList<Integer> neis : adj){
            for(int nei : neis){
                indeg[nei]++;
            }
        }
    }
}