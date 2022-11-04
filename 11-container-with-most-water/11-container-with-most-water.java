class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n-1;
        
        int maxWater = 0;
        
        while(l<=r){
            int w = r-l;
            int h = Math.min(heights[l],heights[r]);
            
            maxWater = Math.max(maxWater,w*h);
            
            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
        }
        
        return maxWater;
    }
}