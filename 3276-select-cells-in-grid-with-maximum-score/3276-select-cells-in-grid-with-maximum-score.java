class Solution {
    public int maxScore(List<List<Integer>> grid) {
        
        int dp[][] = new int[101][1024];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return f(1,0,grid,dp);
    }
    public int f(int val, int rowMask, List<List<Integer>> grid, int dp[][]){
        
        if(val > 100){
            return 0;
        }
        
        if(dp[val][rowMask] != -1){
            return dp[val][rowMask];
        }
        
        int ans = f(val+1,rowMask,grid,dp); // notTake
        //take...
        
        for(int i = 0 ; i < grid.size() ; i++){
            if((rowMask & (1<<i)) != 0){
                continue;
            }
            for(int j = 0 ; j < grid.get(0).size() ; j++){
                
                int curEle = grid.get(i).get(j);
                if(curEle == val){
                    int curRes = val + f(val+1, (rowMask | (1<<i)) ,grid,dp);
                    ans = Math.max(ans,curRes);
                }
            }
        }
        
        return dp[val][rowMask] = ans;
    }
}