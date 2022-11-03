class Solution {
    
    public String longestPalindrome(String s){
        int n = s.length();
        
        String res = "";
        int resLen = 0;
        
        for(int i = 0 ; i < n ; i++){
            int l = i;
            int r = i;
            
            // Odd...
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>resLen){
                    resLen = r-l+1;
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }
            
            // Even...
            l = i;
            r = i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>resLen){
                    resLen = r-l+1;
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        
        return res;
    }
    
    
    
//     String ans="";
//     public String longestPalindrome(String s){
//         if(s.length()<=0)
//             return "";
        
//         if(isPalindrom(s) && s.length()>ans.length()){
//             ans = s;
//         }
//         longestPalindrome(s.substring(0,s.length()-1));
//         longestPalindrome(s.substring(1,s.length()));
        
//         return ans;
//     }
//     public static boolean isPalindrom(String s){
//         int i = 0;
//         int j = s.length()-1;
//         while(i<=j){
//             if(s.charAt(i)!=s.charAt(j)){
//                 return false;
//             }
//             i++;
//             j--;
//         }
        
//         return true;
//     }
    
}