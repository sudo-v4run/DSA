class Solution {
    static int mod;
    public int countOfPairs(int[] arr) {
        
        mod = (int)1e9+7;
        
        HashMap<String,Integer> dp = new HashMap<>();
        
        return f(0,0,arr,dp)%mod;
    }
    public int f(int index, int prev1, int arr[], HashMap<String,Integer> dp){
        
        int n = arr.length;
        
        if(index == n){
            return 1;
        }
        
        String state = index+","+prev1;
        
        if(dp.containsKey(state)){
            return dp.get(state);
        }
        
        int ans = 0;
        int prev2 = index==0 ? (int)1e9 : (arr[index-1]-prev1);
        
        for(int i = prev1 ; i <= arr[index] ; i++){
            int curSecond = arr[index]-i;
            if(prev2 >= curSecond){
                int cur = f(index+1,i,arr,dp)%mod;
                ans = (ans + cur)%mod;
            }
        }
        
        dp.put(state,ans%mod);
        
        return ans%mod;
    }
}