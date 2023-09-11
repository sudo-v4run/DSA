class Solution {
    public int minimumMoves(int[][] arr) {
        
        int cnt = 0;
        
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(arr[i][j] == 0){
                    cnt++;
                }
            }
        }
        
        if(cnt == 0){
            return 0;
        }
        
        int ans = (int)1e7;
        
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(arr[i][j] == 0){
                    for(int ni = 0 ; ni < 3 ; ni++){
                        for(int nj = 0 ; nj < 3 ; nj++){
                            if(arr[ni][nj] > 1){
                                int dist = Math.abs(ni-i) + Math.abs(nj-j);
                                arr[ni][nj]--;
                                arr[i][j]++;
                                ans = Math.min(ans,dist+minimumMoves(arr));
                                arr[ni][nj]++;
                                arr[i][j]--;
                            }
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}