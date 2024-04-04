class Solution {
    public int minimumDistance(int[][] points) {
        
        int max[] = maxDistanceBetweenAnyTwoPoints(points,-1);
        
        int temp1[] = maxDistanceBetweenAnyTwoPoints(points,max[1]);
        int temp2[] = maxDistanceBetweenAnyTwoPoints(points,max[2]);
        
        int ans = Math.min(temp1[0],temp2[0]);
        
        return ans;
    }
    public int[] maxDistanceBetweenAnyTwoPoints(int[][] points, int excludeIndex){
        
        int res[] = new int[3];
        
        Pair minSum = new Pair(Integer.MAX_VALUE,-1);
        Pair maxSum = new Pair(Integer.MIN_VALUE,-1);
        Pair minDiff = new Pair(Integer.MAX_VALUE,-1);
        Pair maxDiff = new Pair(Integer.MIN_VALUE,-1);
        
        for(int i = 0 ; i < points.length ; i++){
            
            if(i == excludeIndex){
                continue;
            }
            
            int point[] = points[i];
            int x = point[0];
            int y = point[1];
            
            int sum = x+y;
            int diff = x-y;
            
            if(minSum.dist > sum){
                minSum.dist = sum;
                minSum.index = i;
            }
            if(maxSum.dist < sum){
                maxSum.dist = sum;
                maxSum.index = i;
            }
            if(minDiff.dist > diff){
                minDiff.dist = diff;
                minDiff.index = i;
            }
            if(maxDiff.dist < diff){
                maxDiff.dist = diff;
                maxDiff.index = i;
            }
        }
        
        if(maxSum.dist-minSum.dist > maxDiff.dist-minDiff.dist){
            res[0] = maxSum.dist-minSum.dist;
            res[1] = maxSum.index;
            res[2] = minSum.index;
        }else{
            res[0] = maxDiff.dist-minDiff.dist;
            res[1] = maxDiff.index;
            res[2] = minDiff.index;
        }
        
        return res;
    }
    class Pair{
        int dist;
        int index;
        
        Pair(int dist, int index){
            
            this.dist = dist;
            this.index = index;
        }
    }
}