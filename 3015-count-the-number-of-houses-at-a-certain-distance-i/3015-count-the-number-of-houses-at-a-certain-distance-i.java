class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        
        int arr[][] = new int[n][n];
        
        for(int row[] : arr){
            Arrays.fill(row,-1);
        }
        
        for(int i = 0 ; i < n-1 ; i++){
            arr[i][i+1] = 1;
            arr[i+1][i] = 1;
        }
        
        arr[x-1][y-1] = 1;
        arr[y-1][x-1] = 1;
        
        for(int i = 0 ; i < n ; i++){
            arr[i][i] = 0;
        }
        
        shortest_distance(arr);
        
        
        int res[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int curDist = arr[i][j];
                
                if(curDist == 0){
                    continue;
                }
                
                res[curDist-1]++;
            }
        }
        
        return res;
    }
    public void shortest_distance(int[][] matrix)
    {
        // this Q can also be solved using dijkstra algo. if no -ve cycles. TC -> V*E*logV..
        
        // TC -> O(N*N*N)... 
        
        int n = matrix.length;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = (int)1e7;
                }
            }
        }
        
        // Floyd Warshall Algo...
        
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        
        // To detect -ve cycle...not asked in Q..
        
        // for(int i = 0 ; i < n ; i++){
        //     if(matrix[i][i] < 0){
        //         return "-ve Cycle exists..."
        //     }
        // }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == (int)1e7){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}