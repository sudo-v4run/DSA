class Solution {
    public long findMaximumScore(List<Integer> arr) {
        
        int n = arr.size();
        
        int cur = arr.get(0);
        int lastInd = 0;
        
        long ans = 0;
        
        for(int i = 1 ; i < n ; i++){
            if(arr.get(i) > cur){
                ans += (i-lastInd)*1l*cur;
                cur = arr.get(i);
                lastInd = i;
            }
        }
        
        
        ans += ((n-1)-lastInd)*1l*cur;
        
        return ans;
    }
}