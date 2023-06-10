class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        
        int n = intervals.length;
        
        int prevEnd = intervals[0][1];
        int res = 0;
        
        for(int i = 1 ; i < n ; i++){
            if(intervals[i][0] >= prevEnd){
                prevEnd = intervals[i][1];
            }else{
                res++;
                prevEnd = Math.min(prevEnd,intervals[i][1]);
            }
        }
        
        return res;
        
        
        
//         Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        
//         int ans = 0;
        
//         int start = intervals[0][0];
//         int end = intervals[0][1];
//         int n = intervals.length;
//         // ArrayList<int[]> res = new ArrayList<>();
        
//         for(int[] interval : intervals){
//             if(interval[0] >= end){
//                 // res.add(new int[]{start,end});
//                 start = interval[0];
//                 end = interval[1];
//             }else{
//                 end = Math.min(end,interval[1]);
//                 ans++;
//             }
//         }
        
//         // res.add(new int[]{start,end});
        
//         return ans-1;
        
//         // -1 for i = 0 since we are already 
//         // initializing start and end with 0th index
    }
}