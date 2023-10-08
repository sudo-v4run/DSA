class Solution {
    public int minOperations(String s1, String s2, int x) {
        
        ArrayList<Integer> diffInds = new ArrayList<>();
        
        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diffInds.add(i);
            }
        }
        
        int n = diffInds.size();
        
        if(n % 2 != 0){
            return -1;
        }
        
        int dp[][] = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,n-1,diffInds,x,dp);
    }
    public static int f(int i, int j, ArrayList<Integer> diffInds, int x, int dp[][]){
        
        int n  = diffInds.size();
        
        if(i > j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int firstTwo = diffInds.get(i+1)-diffInds.get(i) + f(i+2,j,diffInds,x,dp);
        int lastTwo = diffInds.get(j)-diffInds.get(j-1) + f(i,j-2,diffInds,x,dp);
        int firstAndLast = x + f(i+1,j-1,diffInds,x,dp);
        
        return dp[i][j] = Math.min(firstTwo,Math.min(lastTwo,firstAndLast));
    }
}