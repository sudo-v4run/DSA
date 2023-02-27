class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        int n = word.length();
        
        int div[] = new int[n];
        long prev = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            prev = (prev)*10 + Integer.parseInt(word.charAt(i)+"");
            prev = prev % m;
            
            if(prev == 0){
                div[i] = 1;
            }
        }
        
        return div;
    }
}