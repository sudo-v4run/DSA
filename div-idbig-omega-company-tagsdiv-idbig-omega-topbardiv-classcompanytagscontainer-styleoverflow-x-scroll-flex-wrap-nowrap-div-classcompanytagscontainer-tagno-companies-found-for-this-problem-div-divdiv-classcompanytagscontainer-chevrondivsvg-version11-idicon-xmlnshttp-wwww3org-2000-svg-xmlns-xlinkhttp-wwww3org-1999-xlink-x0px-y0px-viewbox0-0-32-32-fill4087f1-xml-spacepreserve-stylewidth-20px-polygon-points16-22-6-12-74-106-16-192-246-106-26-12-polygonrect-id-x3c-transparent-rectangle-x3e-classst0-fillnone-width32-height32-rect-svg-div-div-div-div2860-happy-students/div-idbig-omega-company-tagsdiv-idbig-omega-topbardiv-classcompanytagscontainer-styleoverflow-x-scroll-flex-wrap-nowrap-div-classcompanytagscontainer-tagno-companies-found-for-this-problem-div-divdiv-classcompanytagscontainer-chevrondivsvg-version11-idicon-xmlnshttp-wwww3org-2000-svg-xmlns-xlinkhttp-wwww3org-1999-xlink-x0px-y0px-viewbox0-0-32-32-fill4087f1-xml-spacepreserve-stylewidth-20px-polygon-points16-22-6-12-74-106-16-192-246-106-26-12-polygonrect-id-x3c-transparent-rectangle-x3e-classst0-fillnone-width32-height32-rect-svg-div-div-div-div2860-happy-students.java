class Solution {
    public int countWays(List<Integer> arr) {
        
        int n = arr.size();
        
        Collections.sort(arr);
        int cnt = 0;
        
        if(0 < arr.get(0)){
            cnt++;
        }
        
        for(int i = 0 ; i < n-1 ; i++){
            
            if(i+1 > arr.get(i) && i+1 < arr.get(i+1)){
                cnt++;
            }
        }
        
        if(n > arr.get(n-1)){
            cnt++;
        }
        
        return cnt;
    }
}