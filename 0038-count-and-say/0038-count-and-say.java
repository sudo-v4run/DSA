class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        
        if(n==2)
            return "11";
        
        String s = "11";
        
        for(int i = 3 ; i <= n ; i++){
            
            s = s+'$';
            String t = "";
            int cnt = 1;
            
            for(int c = 1 ; c < s.length(); c++){
                if(s.charAt(c)==s.charAt(c-1)){
                    cnt++;
                }else{
                    String cntStr = String.valueOf(cnt);
                    t+=cntStr+s.charAt(c-1);
                    cnt = 1;
                }
            }
            
            s = t;
        }
        
        return s;
    }
}