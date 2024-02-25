class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        
        long ans = 0;
        
        int n = bottomLeft.length;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                
                int nstrx = Math.min(topRight[i][0],topRight[j][0]);
                int nstry = Math.min(topRight[i][1],topRight[j][1]);
                
                int nslbx = Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                int nslby = Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                
                int s1 = nstrx-nslbx;
                int s2 = nstry-nslby;
                
                int s = Math.min(s1,s2);
                
                if(s1 < 0 || s2 < 0){
                    continue;
                }
                
                ans = Math.max(ans, s*1l*s);
            }
        }
        
        return ans;
    }
}