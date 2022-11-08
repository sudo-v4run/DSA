class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxL = 0;
        
        for(int r = 0 ; r < n ; r++){
            char ch = s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            int maxF = 0;
            for(int vals : hm.values()){
                maxF = Math.max(maxF,vals);
            }
            
            while((r-l+1)-maxF>k){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                l++;
            }
            
            maxL = Math.max(maxL,r-l+1);
        }
        
        return maxL;
    }
}