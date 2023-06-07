class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        ArrayList<int []> res = new ArrayList<>();
        
        int n = intervals.length;
        
        for(int i = 0 ; i < n ; i++){
            
            if(newInterval[0] > intervals[i][1]){
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }else if(newInterval[1] < intervals[i][0]){
                res.add(newInterval);
                
                while(i < n){
                    res.add(new int[]{intervals[i][0],intervals[i][1]});
                    i++;
                }
                
                return res.toArray(new int [0][]);
            }else{
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        
        res.add(newInterval);
        
        return res.toArray(new int [0][]);
    }
}