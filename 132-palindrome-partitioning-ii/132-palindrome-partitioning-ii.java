class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        // Tabulation ...
        
        int dp[] = new int[n+1];
        
        for(int i = n-1 ; i >= 0 ;i--){
            int mini = Integer.MAX_VALUE;
            String temp = "";

            for(int j = i ; j < n ; j++){
                temp += s.charAt(j);

                if(isPalin(temp)){
                    int cost = 1+dp[j+1];
                    mini = Math.min(mini,cost);
                }
            }

            dp[i] = mini;
        }
        
        return dp[0]-1;
        
        
        // Memoization...
        
//         int dp[] = new int[n];
//         Arrays.fill(dp,-1);
        
//         return minpartis(0,s,dp)-1;
    }
    
    public static int minpartis(int i , String s, int dp[]){
        
        if(i==s.length())
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        int mini = Integer.MAX_VALUE;
        String temp = "";
        
        for(int j = i ; j < s.length() ; j++){
            temp += s.charAt(j);
            
            if(isPalin(temp)){
                int cost = 1+minpartis(j+1,s,dp);
                mini = Math.min(mini,cost);
            }
        }
        
        return dp[i] = mini;
        
        
        
        // Recursion...
        
//         if(i==s.length())
//             return 0;
        
//         String temp = "";
//         int mini = Integer.MAX_VALUE;
        
//         for(int j = i ; j < s.length() ; j++){
            
//             temp+=s.charAt(j);
//             if(isPalin(temp)){
//                 int cost = 1+minpartis(j+1,s);
//                 mini = Math.min(mini,cost);
//             }
           
//         }
        
//         return mini;
    }
    
    
    
    public static boolean isPalin(String s){
        int i = 0;
        int j = s.length()-1;
        
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            
            i++;
            j--;
        }
        
        return true;
    }
    
}