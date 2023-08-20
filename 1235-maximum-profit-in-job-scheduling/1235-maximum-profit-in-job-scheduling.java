class Solution {
    class Job{
        int s,e,p;
        Job(int s, int e, int p){
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = startTime.length;
        
        Job arr[] = new Job[n];
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        
        Arrays.sort(arr,(a,b)->{return a.s-b.s;});
                // we can sort on the basis of start as well..
        
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
        
        int nextInd = getNextInd(index,arr[index].e,arr);
        
        int take = arr[index].p+f(nextInd,arr,dp);
        int notTake = f(index+1,arr,dp);
        
        return dp[index] = Math.max(take,notTake);
    }
    public static int getNextInd(int l, int currentJobEnd, Job arr[]){
        
        int lo = l;
        int hi = arr.length-1;
        
        int ans = arr.length;
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            
            if(arr[mid].s >= currentJobEnd){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
}