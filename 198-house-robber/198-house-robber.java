class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        
        // Memoization...
        
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        
        return f(0,arr,dp);
    }
    public static int f(int index,int arr[],int dp[]){
        
       if(index>=arr.length)
            return 0;
        
        if(dp[index] != -1)
            return dp[index];
        
        int takeThis = arr[index]+f(index+2,arr,dp);
        int notTake = f(index+1,arr,dp);
        
        return dp[index] = Math.max(takeThis,notTake);
        
        
//         Recursion...
        
//         if(index>=arr.length)
//             return 0;
        
//         int takeThis = arr[index]+f(index+2,arr);
//         int notTake = f(index+1,arr);
        
//         return Math.max(takeThis,notTake);
    }
}