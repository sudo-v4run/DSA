class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        
        return Math.max(f(red,blue),f(blue,red));
    }
    public int f(int red, int blue){
        
        int cnt = 0;
        
        int r = 1;
        
        while(true){
            
            blue = blue-r;
            cnt++;
            
            if(blue < 0){
                
                return cnt-1;
            }
            
            r++;
            
            red = red - r;
            cnt++;
            
            if(red < 0){
                return cnt-1;
            }
            
            r++;
        }
    }
}