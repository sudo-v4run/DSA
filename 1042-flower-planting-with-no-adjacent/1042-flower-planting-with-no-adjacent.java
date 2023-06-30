class Solution {
    
    static int M = 4;
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
        
        dfs(color);
        
        return color;
    }
    public static boolean dfs(int color[]){
        
        for(int v = 0 ; v < color.length ; v++){
            if(color[v] != -1){
                continue;
            }
            for(int i = 1 ; i <= M ; i++){
                if(isPossible(v,i,color)){
                    color[v] = i;
                    if(dfs(color)){
                        return true;
                    }
                    color[v] = -1;
                }
            }
            return false;
        }
        
        return true;
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