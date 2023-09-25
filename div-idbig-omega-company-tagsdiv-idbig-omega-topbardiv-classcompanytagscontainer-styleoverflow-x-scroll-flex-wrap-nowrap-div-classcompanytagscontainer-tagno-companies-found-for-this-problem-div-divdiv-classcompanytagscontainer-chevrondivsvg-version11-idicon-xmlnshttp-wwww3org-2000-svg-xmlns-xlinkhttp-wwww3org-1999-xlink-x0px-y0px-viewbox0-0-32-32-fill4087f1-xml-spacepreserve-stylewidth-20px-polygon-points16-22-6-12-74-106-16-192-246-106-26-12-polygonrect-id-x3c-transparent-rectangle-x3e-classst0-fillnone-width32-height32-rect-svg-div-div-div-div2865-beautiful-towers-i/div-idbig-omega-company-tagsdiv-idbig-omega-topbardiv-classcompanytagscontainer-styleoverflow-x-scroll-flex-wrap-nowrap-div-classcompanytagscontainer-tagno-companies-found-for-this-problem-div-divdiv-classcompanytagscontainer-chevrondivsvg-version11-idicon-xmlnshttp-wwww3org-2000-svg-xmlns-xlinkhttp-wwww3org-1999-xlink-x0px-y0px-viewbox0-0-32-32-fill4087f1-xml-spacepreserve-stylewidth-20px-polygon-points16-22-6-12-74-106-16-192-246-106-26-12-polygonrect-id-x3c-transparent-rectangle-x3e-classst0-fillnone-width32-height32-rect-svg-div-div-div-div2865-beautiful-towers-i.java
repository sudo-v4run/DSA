class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        
        int n = maxHeights.size();
        
        long ans = 0;
        for(int maxInd = 0 ; maxInd < n ; maxInd++){
            long sum = maxHeights.get(maxInd);
            int min = maxHeights.get(maxInd);
            for(int i = maxInd-1 ; i >=0 ; i--){
                min = Math.min(min,maxHeights.get(i));
                sum += min;
            }

            min = maxHeights.get(maxInd);
            for(int i = maxInd+1 ; i < n ; i++){
                min = Math.min(min,maxHeights.get(i));
                sum += min;
            }
            
            ans = Math.max(ans,sum);
        }
        
        return ans;
    }
}