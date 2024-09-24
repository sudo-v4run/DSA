class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        
        // long pre[][] = new long[workerTimes.length][mountainHeight];
        
        // for(int i = 0 ; i < workerTimes.length ; i++){
        //     pre[i][0] = workerTimes[i];
        //     for(int j = 1 ; j < mountainHeight ; j++){
        //         pre[i][j] = (pre[i][j-1] + workerTimes[i]*1l*(j+1))*1l;
        //     }
        // }
        
        long lo = 1;
        long hi = (long)1e17;
        
        long ans = -1;
        
        while(lo <= hi){
            
            long mid = lo+(hi-lo)/2;
            
            if(isPossible(mid,workerTimes,mountainHeight)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    public static boolean isPossible(long maxSeconds, int workerTimes[], int mountainHeight){
        
        int totalCutsCnt = 0;
        
        for(int curTime : workerTimes){
            
            long cuts = -1;
            
            long l = 1;
            long h = mountainHeight;
            while(l <= h){
                long m = (l+h)/2;
                long cost = ((m * (m + 1)) / 2)*1l*curTime;
                if(cost <= maxSeconds){
                    cuts = m;
                    l = m+1;
                }else{
                    h = m-1;
                }
            }
            
            if(cuts == -1){
                continue;
            }
            
            totalCutsCnt += cuts;
        }
        
        return totalCutsCnt >= mountainHeight;
    }
}