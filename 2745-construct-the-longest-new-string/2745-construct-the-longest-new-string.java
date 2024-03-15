class Solution {
    public int longestString(int x, int y, int z) {
        
        int res = z;
        
        if(x == y){
            res += x + y;
        }else{
            res += Math.min(x,y)+1;
            res += Math.min(x,y);
        }
        
        return 2*res;
    }
}