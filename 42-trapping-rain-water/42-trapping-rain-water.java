class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        
        int left[] = new int[n];
        int right[] = new int[n];
        
        left[0] = heights[0];
        right[n-1] = heights[n-1];
        
        for(int i = 1 ; i < n ; i++){
            left[i] = Math.max(left[i-1],heights[i]);
        }
        
        for(int i = n-2 ; i >= 0 ; i--){
            right[i] = Math.max(right[i+1],heights[i]);
        }
        
        int water = 0;
        
        for(int i = 0 ; i < n ; i++){
            water += Math.min(right[i],left[i]) - heights[i];
        }
        
        return water;
    }
}