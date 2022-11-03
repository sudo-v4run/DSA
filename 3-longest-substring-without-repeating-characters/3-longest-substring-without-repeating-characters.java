class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        
        int len = 0;
        int l = 0 ;
        int r = 0;
        
        while(r<n){
            char ch = s.charAt(r);
            if(hm.containsKey(ch) && hm.get(ch)+1 > l){
                l = hm.get(ch)+1;
            }
            hm.put(ch,r);
            len = Math.max(len,r-l+1);
            
            r++;
        }
        
        return len;
    }
}