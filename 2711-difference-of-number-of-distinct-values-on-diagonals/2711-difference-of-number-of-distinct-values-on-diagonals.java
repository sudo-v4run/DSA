class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        
        // Just brute force...
        
        int m = grid.length;
        int n = grid[0].length;
        
        int ans[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                HashSet<Integer> tl = new HashSet<>();
                HashSet<Integer> br = new HashSet<>();
                
                int r = i-1, c = j-1;
                
                while(r >= 0 && c >= 0){
                    tl.add(grid[r][c]);
                    r--;c--;
                }
                
                r = i+1;
                c = j+1;
                
                while(r < m && c < n){
                    br.add(grid[r][c]);
                    r++;c++;
                }
                
                ans[i][j] = Math.abs(tl.size() - br.size());
            }
        }
        
        return ans;
    }
}