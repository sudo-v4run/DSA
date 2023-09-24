class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        
        int n = maxHeights.size();
        
        long ans = 0;
        for(int maxInd = 0 ; maxInd < n ; maxInd++){
            long sum = 0;
            int cur = maxHeights.get(maxInd);
            for(int i = maxInd ; i >=0 ; i--){
                if(maxHeights.get(i) <= cur){
                    sum += maxHeights.get(i);
                    cur = maxHeights.get(i);
                }else{
                    sum += cur;
                }
            }

            cur = maxHeights.get(maxInd);

            for(int i = maxInd+1 ; i < n ; i++){
                if(maxHeights.get(i) <= cur){
                    sum += maxHeights.get(i);
                    cur = maxHeights.get(i);
                }else{
                    sum += cur;
                }
            }
            
            ans = Math.max(ans,sum);
        }
        
        return ans;
    }
}