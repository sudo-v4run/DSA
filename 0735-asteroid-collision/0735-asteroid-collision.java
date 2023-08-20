class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> s = new Stack<>();
        
        int n = asteroids.length;
        int i = 0;
        while(i < n){
            int cur = asteroids[i];
            if(cur > 0){
                s.push(cur);
            }else if(cur < 0){
                while(!s.isEmpty() && s.peek() > 0 && 
                      s.peek() < Math.abs(cur)){
                    s.pop();
                }
                if(s.isEmpty() || s.peek() < 0){
                    s.push(cur);
                }else if(s.peek() == Math.abs(cur)){
                    s.pop();
                }
            }
            i++;
        }
        
        int len = s.size();
        int res[] = new int[len];
        int k = len-1;
        
        while(!s.isEmpty()){
            res[k--] = s.pop();
        }
        
        return res;
    }
}