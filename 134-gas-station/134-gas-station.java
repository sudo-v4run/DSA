class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int cur = 0;
        int deficit = 0;
        
        int n = gas.length;
        
        int start = 0;
        
        for(int i = 0 ; i < n ; i++){
            cur += gas[i]-cost[i];
            
            if(cur<0){
                deficit += cur;
                cur = 0;
                start = i+1;
            }
        }
        
        if(cur+deficit<0){
            return -1;
        }
        
        return start;
        
        
        
//         int gasSum = 0;
        
//         for(int i : gas){
//             gasSum += i;
//         }
        
//         int costSum = 0;
        
//         for(int i : cost){
//             costSum += i;
//         }
        
//         if(gasSum<costSum){
//             return -1;
//         }
        
//         int n = gas.length;
        
//         int start = 0;
//         int target = 0;
        
//         for(int i = 0 ; i < n ; i++){
//             target += gas[i]-cost[i];
            
//             if(target<0){
//                 target = 0;
//                 start = i+1;
//             }
//         }
        
//         return start;
        
    }
}