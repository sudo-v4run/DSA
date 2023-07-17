class Solution {
    public int maximumBeauty(int[] arr, int k) {
        
        Arrays.sort(arr);
        int n = arr.length;
        
        int max = 0;
        int i = 0;
        int j = 1;
        while(j < n){
            if(arr[j] - arr[i] <= 2*k){
                max = Math.max(max,j-i+1);
                j++;
            }else{
                i++;
            }
        }
        max = Math.max(max,j-i+1-1);
        
        return max;
    }
    
    
    
    
    
//     static int ans;
//     static ArrayList<Integer> res ;
    
//     public int maximumBeauty(int[] arr, int k) {
    
//         int n = arr.length;
//         res = new ArrayList<>();
//         ans = 0;
        
//         int dp[][] = new int[n][100001];
        
//         for(int row[] : dp){
//             Arrays.fill(row,-1);
//         }
        
//         return f(0,k,-1,arr,dp);
//     }
//     public static int f(int index, int k, int prev, int arr[], int dp[][]){
//         int n = arr.length;
        
//         if(index == n){
//             return res.size();
//         }
        
//         if(prev != -1 && dp[index][prev+1] != -1){
//             return dp[index][prev+1];
//         }
        
        
//         int maxi = 0;
//         int notTake = f(index+1,k,prev,arr,dp);
        
//         if(res.size() >=1 && prev != res.get(res.size()-1)){
//             return Integer.MIN_VALUE;
//         }
        
//         int take = 0;
//         for(int i = arr[index]-k ; i <= arr[index]+k ; i++){
//             res.add(i);
//             take = Math.max(take,f(index+1,k,i,arr,dp));
//             res.remove(res.size()-1);
//         }
        
//         maxi = Math.max(take,notTake);
        
//         return dp[index][prev+1] = maxi;
//     }
}