class Solution {
    public int romanToInt(String s) {
        
        int ans = 0;
        
        s = s.replace("IV","IIII");
        s = s.replace("IX","VIIII");
        s = s.replace("XL","XXXX");
        s = s.replace("XC","LXXXX");
        s = s.replace("CD","CCCC");
        s = s.replace("CM","DCCCC");
        
        for( int i = s.length()-1 ; i >=0 ; i-- ){
            char ch = s.charAt(i);
            if(ch=='I'){
                ans+=1;
            }else if(ch=='V'){
                ans+=5;
            }else if(ch=='X'){
                ans+=10;
            }else if(ch=='L'){
                ans+=50;
            }else if(ch=='C'){
                ans+=100;
            }else if(ch=='D'){
                ans+=500;
            }else{
                ans+=1000;
            }
        }
        
        return ans;
    }
}