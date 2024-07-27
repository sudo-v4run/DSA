class Solution {
    public int maxOperations(String s) {
        
        int n = s.length();
        
        int cnt = 0;
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                cnt++;
            }else{
                ans += cnt;
                while(i < n && s.charAt(i) == '0'){
                    i++;
                }
                i--;
            }
        }
        
        return ans;
    }
}