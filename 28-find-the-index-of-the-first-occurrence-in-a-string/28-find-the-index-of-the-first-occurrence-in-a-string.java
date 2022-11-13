class Solution {
    public int strStr(String haystack, String needle) {
        // KMP Algo... TC : O(m+n) ...
        
        int lps[] = computeLPS(needle);
        return match(haystack,needle,lps);
    }
    public static int match(String s,String p ,int lps[]){
        int m = s.length();
        int n = p.length();
        int i = 0 ; 
        int j = 0 ;
        while(i<m){
            if(s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }else{
                if(j!=0)
                    j = lps[j-1];
                else
                    i++;
            }
            if(j==n)
                return i-n;
        }
        
        return -1;
    }
    public static int[] computeLPS(String p){
        int n = p.length();
        int lps[] = new int[n];
        int len = 0;
        int i = 1;
        while(i<n){
            if(p.charAt(i)==p.charAt(len)){
                lps[i] = len+1;
                len++;
                i++;
            }else{
                if(len!=0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}