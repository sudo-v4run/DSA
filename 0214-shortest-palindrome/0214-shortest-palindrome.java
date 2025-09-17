class Solution {
    public String shortestPalindrome(String s) {
        
        int paliLength = kmp(s);
        String extraToAdd = s.substring(paliLength);
        
        return new StringBuilder(extraToAdd).reverse().toString()+s;
    }
    public int kmp(String s){

        String newStr = s+"#"+new StringBuilder(s).reverse().toString();
        int n = newStr.length();

        int lps[] = new int[n];
        int prev = 0;
        int i = 1;
        while(i < n){
            if(newStr.charAt(prev) == newStr.charAt(i)){
                lps[i] = prev+1;
                prev++;
                i++;
            }else{
                if(prev > 0){
                    prev = lps[prev-1];
                }else if(prev == 0){
                    i++;
                }
            }
        }

        return lps[n-1];
    }
}