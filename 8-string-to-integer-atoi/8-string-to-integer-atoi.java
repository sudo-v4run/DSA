class Solution {
    public int myAtoi(String s) {

        if(s.length()==0){
            return 0;
        }

        int i = 0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }

        boolean isNeg = false;
        long ans = 0;
        if(i<s.length() && s.charAt(i)=='-'){
            isNeg = true;
        }
        if(i<s.length() && (s.charAt(i)=='+'||s.charAt(i)=='-')){
            i++;
        }

        for( ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(!Character.isDigit(ch)){
                break;
            }
            int toInt = ch-'0';
            ans = ans*10+toInt;

            if(ans>Integer.MAX_VALUE){
                if(isNeg){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }

        }

        if(isNeg){
            return (int)ans*(-1);
        }

        return (int)ans;
    }
}