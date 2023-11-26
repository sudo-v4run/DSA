class Solution {
    public int beautifulSubstrings(String s, int k) {
        
        int n = s.length();
        
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');hs.add('e');hs.add('i');hs.add('o');hs.add('u');
        
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            int v = 0;
            int c = 0;
            
            for(int j = i ; j < n ; j++){
                
                if(hs.contains(s.charAt(j))){
                    v++;
                }else{
                    c++;
                }
                
                if(v == c && (v*c) % k == 0){
                    cnt++;
                }
            }
            
        }
        
        return cnt;
    }
}