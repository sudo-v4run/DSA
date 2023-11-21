class Solution {
    public long minimumSteps(String s) {
        
        int n = s.length();
        
        long cnt0 = 0;
        long ans = 0;
        
        for(int i = n-1 ; i >= 0 ; i--){
            if(s.charAt(i) == '0'){
                cnt0++;
            }else{
                ans += cnt0;
            }
        }
        
        return ans;
    }
}