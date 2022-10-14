class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->{return a.length()-b.length();});
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        
        int maxi = 1;
        
        for(int i = 0 ; i < n ; i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(compare(words[i],words[prev]) && 1+dp[prev] > dp[i]){
                    dp[i] = 1+dp[prev];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        
        return maxi;
    }
    public static boolean compare(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        
        if(n1 != n2+1 )
            return false;
        
        int p1 = 0;
        int p2 = 0;
            
        while(p1<n1){
            if(p2<n2 && s1.charAt(p1)==s2.charAt(p2)){
                p1++;
                p2++;
            }else{
                p1++;
            }
        }
        if(p1==n1 && p2 ==n2)
            return true;
        
        return false;
    }
}