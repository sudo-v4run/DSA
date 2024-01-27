class Solution {
    public boolean checkOverlap(int radius, int xCenter, 
                                int yCenter, int x1, int y1, int x2, int y2) {
        
        int minX = x1 > xCenter ? x1 : x2 < xCenter ? x2 : xCenter;
        int minY = y1 > yCenter ? y1 : y2 < yCenter ? y2 : yCenter;
        
        int xDist = xCenter - minX;
        int yDist = yCenter - minY;
        
        return xDist*xDist + yDist*yDist <= radius*radius;
    }
}