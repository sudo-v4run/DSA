class Solution {
    public int minArraySum(int[] arr, int k, int op1, int op2) {
        
        int n = arr.length;
        
        int dp[][][] = new int[n][102][102];
        for(int a[][] : dp){
            for(int row[] : a){
                Arrays.fill(row,-1);
            }
        }
        
        return f(0,k,op1,op2,arr,dp);
    }
    public int f(int index, int k, int op1, int op2, int arr[], int dp[][][]){
        
        int n = arr.length;
        
        if(index == n){
            return 0;
        }
        
        if(dp[index][op1][op2] != -1){
            return dp[index][op1][op2];
        }
        
        int ans = Integer.MAX_VALUE;
        
        if(op1 > 0){
            int temp = arr[index];
            arr[index] = (arr[index]+1)/2;
            int ans1 = arr[index] + f(index+1, k, op1-1, op2, arr, dp);
            ans = Math.min(ans,ans1);
            arr[index] = temp;
        }
        if(op2 > 0 && arr[index] >= k){
            int temp = arr[index];
            arr[index] = arr[index]-k;
            int ans2 = arr[index] + f(index+1, k, op1, op2-1, arr, dp);
            ans = Math.min(ans,ans2);
            arr[index] = temp;
        }
        if(op1 > 0 && (op2 > 0 && (arr[index]+1)/2 >= k)){
            int temp = arr[index];
            arr[index] = (arr[index]+1)/2;
            arr[index] = arr[index]-k;
            int ans3 = arr[index] + f(index+1, k, op1-1, op2-1, arr, dp);
            ans = Math.min(ans,ans3);
            arr[index] = temp;
        }
        if((op2 > 0 && arr[index] >= k) && op1 > 0){
            int temp = arr[index];
            arr[index] = arr[index]-k;
            arr[index] = (arr[index]+1)/2;
            int ans4 = arr[index] + f(index+1, k, op1-1, op2-1, arr, dp);
            ans = Math.min(ans,ans4);
            arr[index] = temp;
        }
        
        int ans5 = arr[index] + f(index+1, k, op1, op2, arr, dp);
        ans = Math.min(ans,ans5);
        
        return dp[index][op1][op2] = ans;
    }
}