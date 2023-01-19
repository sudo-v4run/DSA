class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        
        Set<String> hs = new HashSet();
        
        for(String word : wordDict){
            hs.add(word);
        }
        
        
        // Memoization.... Top-Down....
        
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        
        return f(s,0,hs,dp);
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