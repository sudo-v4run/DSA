class Solution {
    public int countBattleships(char[][] arr) {
        
        int m = arr.length;
        int n = arr[0].length;
        
        int cnt = 0;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == '.'){
                    continue;
                }
                if(i > 0 && arr[i-1][j] == 'X'){
                    continue;
                }
                if(j > 0 && arr[i][j-1] == 'X'){
                    continue;
                }
                cnt++;
            }
        }
        
        return cnt;
    }
}