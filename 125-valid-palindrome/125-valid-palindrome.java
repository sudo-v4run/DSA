class Solution {
    public boolean isPalindrome(String s) {
        int st = 0 , e = s.length()-1;
        
        while(st<=e){
            if(!Character.isLetterOrDigit(s.charAt(st)))
                st++;
            else if(!Character.isLetterOrDigit(s.charAt(e)))
                e--;
            else{
                if(Character.toLowerCase(s.charAt(st)) != Character.toLowerCase(s.charAt(e)))
                    return false;
                st++;
                e--;
            }
        }
        return true;
    }
}