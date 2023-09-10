class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        if(sx == fx && sy == fy && t == 1){
            return false;
        }
        
        int x = Math.abs(sx-fx);
        int y = Math.abs(sy-fy);
        
        int minDist = Math.min(x,y);
        
        int xDiff = x - minDist;
        int yDiff = y - minDist;
                // any of both will surely become 0
        
        minDist += xDiff + yDiff;   // adding remaining dist
        
        return minDist <= t;
    }
}