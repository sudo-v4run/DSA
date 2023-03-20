class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int matrix[][] = new int[n][n];
        
        for(int row[]: matrix){
            Arrays.fill(row,(int)1e7);
        }
        
        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            int wt = ed[2];
            
            matrix[u][v] = wt;
            matrix[v][u] = wt;
        }
        
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                matrix[i][i] = 0;
                for(int j = 0 ; j < n ; j++){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        
        int ans = -1;
        int min = n;
        
        for(int i = 0 ; i < n ; i++){
            int cnt = 0;
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=min){
                min = cnt;
                ans = i;
            }
        }
        
        return ans;
    }
}