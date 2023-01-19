class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        
        Set<String> hs = new HashSet();
        
        for(String word : wordDict){
            hs.add(word);
        }
        
        int dp[] = new int[n+1];
        dp[n] = 1;
        
        for(int index = n-1; index>=0 ; index--){
            for(int i = index ; i < s.length() ; i++){
            
                if(hs.contains(s.substring(index,i+1)) && dp[i+1]==1){
                    dp[index] = 1;
                }
            }
        }
        
        return dp[0] == 1 ? true : false;
        
        
        // Memoization.... Top-Down....
        
//         int dp[] = new int[n];
//         Arrays.fill(dp,-1);
        
//         return f(s,0,hs,dp);
    }
    public static boolean f(String s, int index, Set<String> hs,int dp[]){
        
        
        if(index >= s.length()){
            return true;
        }
        
        if(dp[index] != -1){
            return dp[index] == 1 ? true : false;
        }
        
        for(int i = index ; i < s.length() ; i++){
            
            if(hs.contains(s.substring(index,i+1)) && f(s,i+1,hs,dp)){
                dp[index] = 1;
                return true;
            }
        }
        
        dp[index] = 0;
        return false;
        
        
        
        
//         if(index >= s.length()){
//             return true;
//         }
        
//         for(int i = index ; i < s.length() ; i++){
            
//             if(hs.contains(s.substring(index,i+1))){
//                 if(f(s,i+1,hs)){
//                     return true;
//                 }
//             }
//         }
        
//         return false;
    }
}