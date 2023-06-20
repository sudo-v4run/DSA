
class Solution {
    
    static int MOD = (int)1e9+7;
    
    public int specialPerm(int[] arr) {
        
        int n = arr.length;
        
        int dp[][] = new int[n+1][(1<<14)];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(-1,0,0,arr,dp);
    }
    public static int f(int prev, int index, int mask, int arr[], int dp[][]){
        
        if(index == arr.length){
            return 1;
        }
        
        if(dp[prev+1][mask] != -1){
            return dp[prev+1][mask];
        }
        
        int ans = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            if((mask & (1<<i)) > 0){
                continue;
            }
            
            if(prev == -1 || arr[prev] % arr[i] == 0 || arr[i] % arr[prev] == 0){
                ans = (ans+f(i,index+1,(mask ^ (1<<i)),arr,dp)) % MOD;
            }
        }
        
        return dp[prev+1][mask] = ans;
    }
}


// class Solution {
    
//     static int ans;
    
//     public int specialPerm(int[] nums) {
        
//         ans = 0;
        
//         f(0,nums);
        
//         return ans;
//     }
//     public static void f(int ind, int arr[]){
        
//         if(ind == arr.length){
            
//             for(int i = 0 ; i < arr.length-1 ; i++){
//                 if(arr[i] % arr[i+1] != 0 && arr[i+1] % arr[i] != 0){
//                     return;
//                 }
//             }
//             ans++;
//             return;
//         }
        
//         for(int i = ind ; i < arr.length ; i++){
//             swap(arr,i,ind);
//             f(ind+1,arr);
//             swap(arr,i,ind);
//         }
//     }
//     public static void swap(int arr[], int i, int j){
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }
// }