class Solution {
    public boolean doesAliceWin(String s) {
        
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');hs.add('e');hs.add('i');hs.add('o');hs.add('u');
        
        int n = s.length();
        
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            char cur = s.charAt(i);
            
            if(hs.contains(cur)){
                cnt++;
            }
        }
        
        if(cnt == 0){
            return false;
        }
        
        return true;
    }
}