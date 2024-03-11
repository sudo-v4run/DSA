class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        
        int sum = 0 ;
        
        for(int x : apple){
            sum += x;
        }
        
        Arrays.sort(capacity);
        
        int c = 0;
        int cnt = 0;
        
        for(int i = capacity.length-1 ; i>= 0 ; i--){
            
            c += capacity[i];
            
            cnt++;
            
            if(c >= sum){
                return cnt;
            }
        }
        
        return capacity.length;
    }
}