class Solution {
    
    static ArrayList<ArrayList<Integer>> adj;
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int ed[] : paths){
            int u = ed[0]-1;
            int v = ed[1]-1;
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int color[] = new int[n];
        Arrays.fill(color,-1);
        
        dfs(0,color);
        
        return color;
    }
    public static boolean dfs(int v, int color[]){
        
        if(v == color.length){
            return true;
        }
        
        for(int i = 1 ; i <= 4 ; i++){
            if(isPossible(v,i,color)){
                color[v] = i;
                if(dfs(v+1,color)){
                    return true;
                }
                color[v] = -1;
            }
        }
        
        return false;
    }
    public static boolean isPossible(int v, int i, int color[]){
        for(int nei : adj.get(v)){
            if(color[nei] == i){
                return false;
            }
        }
        
        return true;
    }
}