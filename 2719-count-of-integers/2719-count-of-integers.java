class Solution {
    static int MOD = (int)1e9+7;
    
    public int count(String n1, String n2, int min_sum, int max_sum) {
        
        while(n1.length() != n2.length()){
            n1 = '0'+n1;
        }
        
        int dp[][][][] = new int[23][401][2][2];
        
        for(int a[][][] : dp){
            for(int b[][] : a){
                for(int c[] : b){
                    Arrays.fill(c,-1);
                }
            }
        }
        
        int tillMax = f(0,max_sum,1,1,n1,n2,dp);
        int tillMin = f(0,min_sum-1,1,1,n1,n2,dp);
        
        int ans = (tillMax-tillMin)%MOD;
        
        return (ans < 0) ? ans+MOD : ans;
    }
    public static int f(int i, int sum, int t1, int t2, 
                        String n1, String n2, int dp[][][][]){
        
        if(sum < 0){
            return 0;
        }
        
        if(i == n2.length()){
            return 1;
        }
        
        if(dp[i][sum][t1][t2] != -1){
            return dp[i][sum][t1][t2];
        }
        
        int l = t1 == 1 ?  n1.charAt(i)-'0' : 0;
        int h = t2 == 1 ? n2.charAt(i)-'0' : 9;
        
        int cnt = 0;
        
        for(int d = l ; d <= h ; d++){
            
            int nextT1 = t1 == 1 && (n1.charAt(i)-'0' == d) ? 1 : 0;
            int nextT2 = t2 == 1 && (n2.charAt(i)-'0' == d) ? 1 : 0;
            
            // here t1 and t2 are tight bounds
            
            cnt = (cnt%MOD + f(i+1,sum-d,nextT1,nextT2,n1,n2,dp))%MOD;
        }
        
        return dp[i][sum][t1][t2] = cnt;
    }
}