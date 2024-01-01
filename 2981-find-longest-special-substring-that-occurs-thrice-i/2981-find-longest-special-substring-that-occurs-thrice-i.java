class Solution {
    public int maximumLength(String s) {
        
        int n = s.length();
        
        HashSet<String> spl = new HashSet<>();
        
        int i = 0;
        int j = 0;
        
        while(j < n){
            while(j < n && s.charAt(j) == s.charAt(i)){
                spl.add(s.substring(i,j+1));
                j++;
            }
            
            i = j;
        }
        
        int ans = -1;
        
        for(String sp : spl){
            
            for(int len = 1 ; len <= n ; len++){
                int cnt = 0;
                for(int index = 0 ; index < n ; index++){
                    if(index+len > n){
                        continue;
                    }
                    String temp = s.substring(index,index+len);
                    
                    if(temp.equals(sp)){
                        cnt++;
                    }
                }
                if(cnt >= 3){
                    ans = Math.max(ans,sp.length());
                }
            }
            
        }
        
        return ans;
    }
}