class DisjointSet{
    int parent[],rank[];
    DisjointSet(int n){
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        rank = new int[n];
        Arrays.fill(rank,1);
    }
    int findParent(int u){
        if(parent[u] == u){
            return u;
        }
        
        return parent[u] = findParent(parent[u]);
    }
    void union(int a, int b){
        int parent_a = findParent(a);
        int parent_b = findParent(b);
        
        if(parent_a == parent_b){
            return;
        }
        
        int rank_parent_a = rank[parent_a];
        int rank_parent_b = rank[parent_b];
        
        if(rank_parent_a < rank_parent_b){
            parent[parent_a] = parent_b;
        }else if(rank_parent_a > rank_parent_b){
            parent[parent_b] = parent_a;
        }else{
            parent[parent_b] = parent_a;
            rank[parent_a]++;
        }
    }
}

class Solution {
    
    static int dir[][] = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    static int compoCnt;
    
    public int largestIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int vis[][] = new int[m][n];
        
        DisjointSet ds = new DisjointSet(m*n);
        int max = Integer.MIN_VALUE;
        
        // 1st Step...Finding Components and respective no.of 1s...
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1 && vis[i][j] != 1){
                    compoCnt = 0;
                    int node = ds.findParent(cellNum(i,j,n));
                    dfs(i,j,grid,vis,ds,node);
                    hm.put(node,compoCnt);
                    max = Math.max(max,compoCnt);
                }
            }
        }
        
        // 2nd Step...
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                grid[i][j] = 1;
                int cnt = 0;
                HashSet<Integer> compoVis = new HashSet<>();
                for(int d[] : dir){
                    int newR = i+d[0];
                    int newC = j+d[1];
                    
                    if( newR < 0 || newR >= m || newC < 0 || newC >= n || 
                        grid[newR][newC] == 0){
                        
                        continue;
                    }
                    
                    int key = ds.findParent(cellNum(newR,newC,n));
                    
                    if(!compoVis.contains(key)){
                        cnt += hm.get(key);
                        compoVis.add(key);
                    }
                }
                max = Math.max(max,cnt+1);  // +1 for itself
                grid[i][j] = 0;
            }
        }
        
        return max;
    }
    public void dfs(int r, int c, int arr[][], int vis[][], DisjointSet ds, int par){
        
        if( r < 0 || r >= arr.length || c < 0 || c >= arr[0].length ||
            arr[r][c] == 0 || vis[r][c] == 1){
            
            return;
        }
        
        vis[r][c] = 1;
        ds.parent[cellNum(r,c,arr[0].length)] = par;
        compoCnt++;
        
        dfs(r-1,c,arr,vis,ds,par);
        dfs(r,c-1,arr,vis,ds,par);
        dfs(r+1,c,arr,vis,ds,par);
        dfs(r,c+1,arr,vis,ds,par);
    }
    public static int cellNum(int row, int col, int n){
        return row*n+col;
    }
}