class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        
        // Slightly Optimized... in 2 swipes...
        
        int m = grid.length;
        int n = grid[0].length;
        
        int ans[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            populateDiagonal(i,0,grid,ans);
        }
        
        for(int j = 1 ; j < n ; j++){
            populateDiagonal(0,j,grid,ans);
        }
        
        return ans;
        
        
        // Brute force...
        
//         int m = grid.length;
//         int n = grid[0].length;
        
//         int ans[][] = new int[m][n];
        
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 HashSet<Integer> tl = new HashSet<>();
//                 HashSet<Integer> br = new HashSet<>();
                
//                 int r = i-1, c = j-1;
                
//                 while(r >= 0 && c >= 0){
//                     tl.add(grid[r][c]);
//                     r--;c--;
//                 }
                
//                 r = i+1;
//                 c = j+1;
                
//                 while(r < m && c < n){
//                     br.add(grid[r][c]);
//                     r++;c++;
//                 }
                
//                 ans[i][j] = Math.abs(tl.size() - br.size());
//             }
//         }
        
//         return ans;
    }
    
    public static void populateDiagonal(int i , int j , int grid[][], int ans[][]){
        
        int m = grid.length;
        int n = grid[0].length;
        
        HashSet<Integer> tl = new HashSet<>();
        HashSet<Integer> br = new HashSet<>();

        int d = 0;
        for( ; i+d < m && j+d < n ; d++){
            ans[i+d][j+d] = tl.size();
            tl.add(grid[i+d][j+d]);
        }

        for(d = d-1 ; d >=0 ; d--){
            ans[i+d][j+d] = Math.abs(ans[i+d][j+d] - br.size());
            br.add(grid[i+d][j+d]);
        }
    }
}