class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        int n = asteroids.length;
        
        Arrays.sort(asteroids);
        
        long mss = mass*1l;
        
        for(int i = 0 ; i < n ; i++){
            int cur = asteroids[i];
                    
            if(cur <= mss){
                mss += cur;
            }else{
                return false;
            }
            
            // Instead of long, we can check if mass >= 1e5, coz if mass is 
            // reaches 1e5, then mass is always >= asteroids[i] for any i.
            // coz it is given that 1 <= asteroid[i] <= 1e5. So, we can simply
            // return true if mass exceeds 1e5.
        }
        
        return true;
    }
}