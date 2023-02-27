class Solution {
    public boolean isPalindrome(String s) {
        
        int start = 0;
        int end = s.length()-1;
        
        while(start<=end){
            
            if( !Character.isLetterOrDigit(s.charAt(start)) ){
                start++;
            }
            else if( !Character.isLetterOrDigit(s.charAt(end)) ){
                end--;
            }else{
            
                if( Character.toLowerCase(s.charAt(start)) != 
                                    Character.toLowerCase(s.charAt(end)) ){
                    return false;
                }
                start++;
                end--;
            }
        }
        
        return true;
        
        
        
        
//         s = s.toLowerCase();
        
//         String str = "";
        
//         for(char ch : s.toCharArray()){
//             if( (ch>='a' && ch<='z') || (ch>='0' && ch<='9') ){
//                 str+=ch;
//             }
//         }
        
//         int start = 0;
//         int end = str.length()-1;
        
//         while(start<=end){
//             if(str.charAt(start)!=str.charAt(end)){
//                 return false;
//             }else{
//                 start++;
//                 end--;
//             }
//         }
        
//         return true;
    }
}