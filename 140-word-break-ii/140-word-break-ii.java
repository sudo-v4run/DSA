class Solution {
    
    static List<String> res;
    static String ans;
    
    Solution(){
        res = new ArrayList<>();
        ans = "";
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        
        Set<String> hs = new HashSet();
        
        for(String word : wordDict){
            hs.add(word);
        }
        
        // Memoization.... Top-Down....

        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        f(s,0,hs,dp);
        
        return res;
    }
    
    public static boolean f(String s, int index, Set<String> hs, int dp[]){
        
        if(index >= s.length()){
            return true;
        }
        
        if(dp[index] != -1){
            return dp[index] == 1 ? true : false;
        }
        
        String temp = ans;
        for(int i = index ; i < s.length() ; i++){
            ans += s.substring(index,i+1)+" ";
            if(hs.contains(s.substring(index,i+1)) && f(s,i+1,hs,dp)){
                res.add(ans.substring(0,ans.length()-1));
            }
            ans = temp;
        }
        
        return false;
    }
}