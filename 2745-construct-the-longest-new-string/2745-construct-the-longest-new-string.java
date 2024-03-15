class Solution {
    public int longestString(int x, int y, int z) {
        
        int res = 2*z;
        
        if(x == y){
            res += 2*x + 2*y;
        }else{
            res += (Math.min(x,y)+1)*2;
            res += Math.min(x,y)*2;
        }
        
        return res;
    }
}