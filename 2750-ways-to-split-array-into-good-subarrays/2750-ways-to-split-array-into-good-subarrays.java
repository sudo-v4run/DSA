class Solution {
    
    static int MOD = (int)1e9+7;
    
    public int numberOfGoodSubarraySplits(int[] arr) {
        
        int n = arr.length;
        
        int i = 0;
        while(i < n && arr[i] == 0){
            i++;
        }
        if(i == n){
            return 0;
        }
        
        long ans = 1;
        int cnt = 0;
        
        for( ; i < n ; i++){
            if(arr[i] == 0){
                cnt++;
            }else{
                ans = (ans * (cnt+1))%MOD;
                cnt = 0;
            }
        }
        
        return (int)ans;
    }
    
//     public int numberOfGoodSubarraySplits(int[] arr) {
        
//         int n = arr.length;
        
//         // int dp[] = new int[n+1];
//         int next = 1;
        
//         // dp[n] = 1;
        
//         for(int index = n-1 ; index >= 0 ; index--){
//             int ans = 0;
        
//             int oneCnt = 0;

//             for(int i = index ; i < arr.length ; i++){

//                 if(oneCnt > 1){
//                     continue;
//                 }

//                 if(arr[i] == 1){
//                     oneCnt++;
//                 }

//                 if(oneCnt == 1){
//                     ans = (ans + next) % MOD;
//                 }
//             }
//             int cur = ans;
//             next = cur;
//         }
        
//         return next;
        
        
// //         Arrays.fill(dp,-1);
        
//         // return f(0,nums,dp);
//     }
//     public static int f(int index, int arr[], int dp[]){
        
//         if(index == arr.length){
//             return 1;
//         }
        
//         if(dp[index] != -1){
//             return dp[index];
//         }
        
//         int ans = 0;
        
//         int oneCnt = 0;
        
//         for(int i = index ; i < arr.length ; i++){
            
//             if(oneCnt > 1){
//                 continue;
//             }
            
//             if(arr[i] == 1){
//                 oneCnt++;
//             }
            
//             if(oneCnt == 1){
//                 ans = (ans + f(i+1,arr,dp)) % MOD;
//             }
//         }
        
//         return dp[index] = ans;
//     }
}