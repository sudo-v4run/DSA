class Solution {
    public int characterReplacement(String s, int K) {
        
        int n = s.length();
        HashSet<Character> hs = new HashSet<>();
        for(char ch : s.toCharArray()){
            hs.add(ch);
        }
        
        int max = 0;
        for(char ch : hs){
            int i = 0, j = 0;
            int k = K;
            while(j < n){
                if(s.charAt(j) != ch){
                    k--;
                }
                if(k >= 0){
                    max = Math.max(max,j-i+1);
                    j++;
                }else if(k < 0){
                    while(k < 0){
                        if(s.charAt(i) != ch){
                            k++;
                        }
                        i++;
                    }
                    j++;
                }
            }
        }
        
        return max;
    }
}