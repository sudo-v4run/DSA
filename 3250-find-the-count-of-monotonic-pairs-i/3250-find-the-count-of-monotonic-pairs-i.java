class Solution {
    static int mod;
    public int countOfPairs(int[] arr) {
        
        mod = (int)1e9+7;
        
        HashMap<String,Integer> dp = new HashMap<>();
        
        return f(0,0,arr,dp)%mod;
    }
    public int f(int index, int prev, int arr[], HashMap<String,Integer> dp){
        
        int n = arr.length;
        
        if(index == n){
            return 1;
        }
        
        String state = index+","+prev;
        
        if(dp.containsKey(state)){
            return dp.get(state);
        }
        
        int ans = 0;
        
        for(int i = prev ; i <= arr[index] ; i++){
            int second = arr[index]-i;
            if(index == 0 || (index-1 >= 0 && second <= arr[index-1]-prev)){
                int cur = f(index+1,i,arr,dp)%mod;
                ans = (ans + cur)%mod;
            }
        }
        
        dp.put(state,ans%mod);
        
        return ans%mod;
    }
}