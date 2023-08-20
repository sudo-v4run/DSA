class Solution {
    class Job{
        int s,e,p;
        Job(int s, int e, int p){
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }
    public int maximizeTheProfit(int m, List<List<Integer>> offers) {
        
        // very similar to 1235. Maximum Profit in Job Scheduling
        
        int n = offers.size();
        
        Job arr[] = new Job[n];
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = new Job(
                offers.get(i).get(0),offers.get(i).get(1),offers.get(i).get(2)
                );
        }
        
        Arrays.sort(arr,(a,b)->{return a.s-b.s;});
        
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        
        return f(0,arr,dp);
    }
    public static int f(int index, Job arr[], int dp[]){
        
        int n = arr.length;
        
        if(index == n){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int nextInd = getNextInd(arr[index].e,arr);
        
        int take = arr[index].p+f(nextInd,arr,dp);
        int notTake = f(index+1,arr,dp);
        
        return dp[index] = Math.max(take,notTake);
    }
    public static int getNextInd(int currentJobEnd, Job arr[]){
        
        int n = arr.length;
        
        int lo = 0;
        int hi = n-1;
        
        int ans = n;
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            
            if(arr[mid].s > currentJobEnd){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
}