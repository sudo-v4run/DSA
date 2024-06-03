class Solution {
    public int minimumChairs(String s) {
     
        int n = s.length();
        
        int cnt = 0;
        
        int ans = -1;
        
        for(char ch : s.toCharArray()){
            if(ch=='E'){
                cnt++;
            }else{
                cnt--;
            }
            ans = Math.max(ans,cnt);
        }
        
        return ans;
    }
}