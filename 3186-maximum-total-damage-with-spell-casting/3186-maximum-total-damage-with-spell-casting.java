class Solution {
    HashMap<Integer,Integer> hm;
    public long maximumTotalDamage(int[] pow) {
        
        hm = new HashMap<>();
        
        for(int x : pow){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        
        int arr[] = new int[hm.size()];
        int i = 0;
        for(int key : hm.keySet()){
            arr[i++] = key;
        }
        
        Arrays.sort(arr);
        
        long dp[] = new long[arr.length];
        Arrays.fill(dp,-1);
        
        return f(0,arr,dp);
    }
    public long f(int index, int arr[], long dp[]){
        
        int n = arr.length;
        
        if(index >= n){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        long take = arr[index]*1l*hm.get(arr[index]);

        int newIndex = bs(index+1,arr[index]+3,arr);
        take += f(newIndex,arr,dp);
  
        long notTake = f(index+1,arr,dp);
        
        return dp[index] = Math.max(take,notTake);
    }
    public int bs(int st, int target, int arr[]){
        
        int lo = st;
        int hi = arr.length-1;
        
        int ans = arr.length;
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            
            if(arr[mid] >= target){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
}