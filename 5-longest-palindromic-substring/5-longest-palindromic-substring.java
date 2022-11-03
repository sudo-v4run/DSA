class Solution {
    
    static String res = "";
    static int resLen = 0;
    
    public String longestPalindrome(String s){
        int n = s.length();
        
        res = "";
        resLen = 0;
        
        
        for(int i = 0 ; i < n ; i++){
            int l = i;
            int r = i;
            
            // Odd...
            pali(s,l,r);
            
            // Even...
            l = i;
            r = i+1;
            pali(s,l,r);
        }
        
        return res;
    }
    
    public static void pali(String s , int l , int r){
        int n =s.length();
        
        while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
            if(r-l+1>resLen){
                resLen = r-l+1;
                res = s.substring(l,r+1);
            }
            l--;
            r++;
        }
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