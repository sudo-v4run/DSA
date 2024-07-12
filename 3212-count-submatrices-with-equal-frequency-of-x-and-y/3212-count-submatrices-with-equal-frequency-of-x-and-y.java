class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int cntX[][] = new int[m][n];
        int cntY[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                
                char cur = grid[i][j];
                
                if(j > 0){
                    cntX[i][j] = cntX[i][j-1];
                    cntY[i][j] = cntY[i][j-1];
                }
                if(i > 0){
                    cntX[i][j] += cntX[i-1][j];
                    cntY[i][j] += cntY[i-1][j];
                }
                if(i > 0 && j > 0){
                    cntX[i][j] -= cntX[i-1][j-1];
                    cntY[i][j] -= cntY[i-1][j-1];
                }
                
                if(cur == 'X'){
                    cntX[i][j]++;
                }else if(cur == 'Y'){
                    cntY[i][j]++;
                }
            }
        }
        
        int cnt = 0;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(cntX[i][j] != 0 && (cntX[i][j] == cntY[i][j])){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}