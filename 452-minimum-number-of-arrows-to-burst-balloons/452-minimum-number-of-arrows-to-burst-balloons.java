class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int n = points.length;
        
        // inorder to get min, we need to maximize the overlappings...
        
        Arrays.sort(points,(a,b)->{return Integer.compare(a[1],b[1]);});
        
        int ans = 0;
        int prevEnd = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            if(points[i][0] > prevEnd || prevEnd == Integer.MIN_VALUE){
                ans++;
                prevEnd = points[i][1];
            }
        }
        
        return ans;
    }
}