class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0 , j = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        
        return i==s.length();
        
        
        
        // int m = s.length();
        // int n = t.length();
        // if(m==0)
        //     return true;
        // if(n==0)
        //     return false;
        // if(s.charAt(m-1)==t.charAt(n-1)){
        //     m = m-1;
        //     n = n-1;
        //     return isSubsequence(s.substring(0,m),t.substring(0,n));
        // }
        // n = n-1;
        // return isSubsequence(s,t.substring(0,n));
    }
}