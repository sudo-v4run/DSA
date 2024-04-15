class Solution {
    public String findLatestTime(String s) {
        
        int n = s.length();
        
        String ans = "";
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            
            if(ch != '?'){
                ans += ch;
                continue;
            }
            
            if(i == 0){
                if(s.charAt(i+1) == '0' || s.charAt(i+1) == '1' || s.charAt(i+1) == '?'){
                    ans += '1';
                }else{
                    ans += '0';
                }
            }else if(i == 1){
                if(s.charAt(i-1) == '0'){
                    ans += '9';
                }else{
                    ans += '1';
                }
            }else if(i == 3){
                ans += '5';
            }else if(i == 4){
                ans += '9';
            }
            
        }
        
        return ans;
    }
}