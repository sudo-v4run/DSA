class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        
        HashSet<String> hs = new HashSet<>();
        
        for(String w : forbidden){
            hs.add(w);
        }
        
        int n = word.length();
        int end = n-1;
        
        int ans = -1;
        
        for(int left = n-1 ; left >= 0 ; left--){
            String substr = "";
            for(int k = left ; k <= Math.min(left+10,end) ; k++){
                substr += word.charAt(k);
                if(hs.contains(substr)){
                    end = k-1;
                    break;
                }
            }
            ans = Math.max(ans,end-left+1);
        }
        
        return ans;
    }
}