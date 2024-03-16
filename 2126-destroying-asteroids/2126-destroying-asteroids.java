class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        int n = asteroids.length;
        
        Arrays.sort(asteroids);
        
        long mas = mass*1l;
        
        for(int i = 0 ; i < n ; i++){
            int cur = asteroids[i];
                    
            if(cur <= mas){
                mas += cur;
            }else{
                return false;
            }
        }
        
        return true;
    }
}