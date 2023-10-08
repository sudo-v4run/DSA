class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        
        Collections.sort(processorTime);
        Collections.sort(tasks,(a,b)->{
            return b - a;
        });
        
        int ans = Integer.MIN_VALUE;
        int k = 0;
        
        for(int i = 0 ; i < tasks.size() ; i = i+4){
            
            ans = Math.max(ans,tasks.get(i)+processorTime.get(k));
            k++;
        }
        
        return ans;
    }
}