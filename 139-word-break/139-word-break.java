class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        
        HashSet<String> hs = new HashSet<>();
        
        for(String str : wordDict){
            hs.add(str);
        }
        
        // Tabulation...Buttom Up...
        
        boolean dp[] = new boolean[n+1];
        
        dp[n] = true;
        
        for(int i = n-1 ; i >= 0 ; i--){
            for(String w : wordDict){
                if(i+w.length()<=n && 
                                hs.contains(s.substring(i,i+w.length())) ){
                    dp[i] = dp[i+w.length()];
                }
                if(dp[i]){
                    break;
                }
            }
        }
        
        return dp[0];
        
        
        // Memoization... Top Down ...
        
//         int dp[] = new int[n];
        
//         Arrays.fill(dp,-1);
        
//         return f(0,s,hs,dp);
        
    }
    public static boolean f(int index,String s,HashSet<String> hs,int dp[]){
        if(index>=s.length()){
            return true;
        }
        
        if(dp[index]!= -1){
            return dp[index]==1?true:false;
        }
        
        for(int i = index ; i < s.length() ; i++){
            if(hs.contains(s.substring(index,i+1)) && f(i+1,s,hs,dp)){
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = 0;
        return false;
    }
}