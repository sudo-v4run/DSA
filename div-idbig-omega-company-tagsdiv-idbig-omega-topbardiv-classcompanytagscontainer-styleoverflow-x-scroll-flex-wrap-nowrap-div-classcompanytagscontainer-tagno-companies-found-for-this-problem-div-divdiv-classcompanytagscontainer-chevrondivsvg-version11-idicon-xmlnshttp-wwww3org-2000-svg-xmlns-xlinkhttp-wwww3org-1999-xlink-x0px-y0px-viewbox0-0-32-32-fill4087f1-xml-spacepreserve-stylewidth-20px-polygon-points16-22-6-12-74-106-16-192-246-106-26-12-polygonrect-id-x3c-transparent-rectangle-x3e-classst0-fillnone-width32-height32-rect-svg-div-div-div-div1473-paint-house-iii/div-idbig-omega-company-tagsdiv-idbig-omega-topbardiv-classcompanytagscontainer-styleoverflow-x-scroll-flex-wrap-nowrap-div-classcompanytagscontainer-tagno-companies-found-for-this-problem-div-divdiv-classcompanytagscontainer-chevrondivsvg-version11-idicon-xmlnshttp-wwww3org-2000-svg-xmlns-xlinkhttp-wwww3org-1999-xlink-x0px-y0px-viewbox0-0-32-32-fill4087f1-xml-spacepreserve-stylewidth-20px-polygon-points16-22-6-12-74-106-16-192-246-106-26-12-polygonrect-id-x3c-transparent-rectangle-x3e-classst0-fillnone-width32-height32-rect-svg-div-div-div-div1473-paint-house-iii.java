class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int dp[][][] = new int[m][n+1][m];
        for(int a[][] : dp){
            for(int b[] : a){
                Arrays.fill(b,-1);
            }
        }
        
        int res = f(0,0,0,houses,cost,target,dp);   
            // no need to set prevColor = -1 initially for this Q.
        
        return res == (int)1e7 ? -1 : res;
    }
    public static int f(int index, int prevColor, int cnt,
                        int houses[], int cost[][], int target, int dp[][][]){
        
        if(cnt > target){
            return (int)1e7;
        }
        
        if(index == houses.length){
            if(cnt != target){
                return (int)1e7;
            }
            
            return 0;
        }
        
        if(dp[index][prevColor][cnt] != -1){
            return dp[index][prevColor][cnt];
        }
        
        int ans = (int)1e7;
        
        if(houses[index] != 0){
            int newCnt = prevColor == houses[index] ? cnt : cnt+1;
            
            ans = f(index+1,houses[index],newCnt,houses,cost,target,dp);
        }else{
            
            for(int j = 0 ; j < cost[0].length ; j++){
                houses[index] = j+1;
                int newCnt = prevColor == houses[index] ? cnt : cnt+1;
                int cur = cost[index][j] + f(index+1,j+1,newCnt,houses,cost,target,dp);
                houses[index] = 0;
                ans = Math.min(ans,cur);
            }
        }
        
        return dp[index][prevColor][cnt] = ans;
    }
}