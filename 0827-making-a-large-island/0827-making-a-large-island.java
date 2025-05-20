// class Solution {
//     int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
//     public int largestIsland(int[][] arr) {

//         int n = arr.length;

//         HashMap<Integer,Integer> area = new HashMap<>();
//         int id = 2;

//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 if(arr[i][j] == 1){
//                     int cur = f(i, j, id, arr);
//                     System.out.println(cur);
//                     area.put(id,cur);
//                     id++;
//                 }
//             }
//         }

//         int max = 0;
//         boolean zeroExists = false;

//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 if(arr[i][j] == 0){
//                     zeroExists = true;

//                     HashSet<Integer> vis = new HashSet<>();
//                     int cur = 1;

//                     for(int d[] : dirs){
//                         int newR = i + d[0];
//                         int newC = j + d[1];
//                         if(newR < 0 || newR >= n || newC < 0 || newC >= n){
//                             continue;
//                         }

//                         if(!vis.contains(arr[newR][newC])){
//                             cur += area.getOrDefault(arr[newR][newC],0);
//                             vis.add(arr[newR][newC]);
//                         }
//                     }

//                     max = Math.max(max,cur);
//                 }
//             }
//         }

//         if(!zeroExists){
//             return n*n;
//         }

//         return max;
//     }
//     public int f(int r, int c, int id, int arr[][]){

//         int n = arr.length;

//         if(r < 0 || r >= n || c < 0 || c >= n){
//             return 0;
//         }

//         if(arr[r][c] != 1){
//             return 0;
//         }

//         arr[r][c] = id;

//         int up = f(r-1,c,id,arr);     
//         int left = f(r,c-1,id,arr);
//         int down = f(r+1,c,id,arr);
//         int right = f(r,c+1,id,arr);

//         return 1+up+down+left+right;
//     }
// }

// class DisjointSet{
//     int parent[],rank[];
//     DisjointSet(int n){
//         parent = new int[n];
//         for(int i = 0 ; i < n ; i++){
//             parent[i] = i;
//         }
//         rank = new int[n];
//         Arrays.fill(rank,1);
//     }
//     int findParent(int u){
//         if(parent[u] == u){
//             return u;
//         }
        
//         return parent[u] = findParent(parent[u]);
//     }
//     void union(int a, int b){
//         int parent_a = findParent(a);
//         int parent_b = findParent(b);
        
//         if(parent_a == parent_b){
//             return;
//         }
        
//         int rank_parent_a = rank[parent_a];
//         int rank_parent_b = rank[parent_b];
        
//         if(rank_parent_a < rank_parent_b){
//             parent[parent_a] = parent_b;
//         }else if(rank_parent_a > rank_parent_b){
//             parent[parent_b] = parent_a;
//         }else{
//             parent[parent_b] = parent_a;
//             rank[parent_a]++;
//         }
//     }
// }

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
                        cnt += hm.getOrDefault(key,0);
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

        int n = arr.length;
        
        if( r < 0 || r >= n || c < 0 || c >= n || arr[r][c] == 0 || vis[r][c] == 1){
            
            return;
        }
        
        vis[r][c] = 1;
        ds.union(cellNum(r,c,n),par);
        compoCnt++;
        
        dfs(r-1,c,arr,vis,ds,par);
        dfs(r,c-1,arr,vis,ds,par);
        dfs(r+1,c,arr,vis,ds,par);
        dfs(r,c+1,arr,vis,ds,par);
    }
    public static int cellNum(int row, int col, int n){
        return row*n+col;
    }

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
            
            //parent[parent_a] = parent_b;

            if(rank_parent_a < rank_parent_b){
                parent[parent_a] = parent_b;
            }else if(rank_parent_a > rank_parent_b){
                parent[parent_b] = parent_a;
            }else{
                parent[parent_a] = parent_b;
                rank[parent_b]++;
            }
        }
    }
}