class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> s = new Stack<>();
        
        int n = asteroids.length;
        int i = 0;
        
        while(i < n && asteroids[i] < 0){
            s.push(asteroids[i]);
            i++;
        }
        
        while(i < n){
            int cur = asteroids[i];
            if(cur < 0){
                if(!s.isEmpty() && Math.abs(cur) < s.peek()){
                    i++;
                    continue;
                }
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(cur)){
                    s.pop();
                }
                if(s.isEmpty()){
                    s.push(cur);
                }else if(s.peek() < 0){
                    s.push(cur);
                }else if(s.peek() == Math.abs(cur)){
                    s.pop();
                }
            }else{
                s.push(cur);
            }
            
            i++;
        }
        
        int fn = s.size();
        int res[] = new int[fn];
        int k = fn-1;
        
        while(!s.isEmpty()){
            res[k] = s.pop();
            k--;
        }
        
        return res;
    }
}