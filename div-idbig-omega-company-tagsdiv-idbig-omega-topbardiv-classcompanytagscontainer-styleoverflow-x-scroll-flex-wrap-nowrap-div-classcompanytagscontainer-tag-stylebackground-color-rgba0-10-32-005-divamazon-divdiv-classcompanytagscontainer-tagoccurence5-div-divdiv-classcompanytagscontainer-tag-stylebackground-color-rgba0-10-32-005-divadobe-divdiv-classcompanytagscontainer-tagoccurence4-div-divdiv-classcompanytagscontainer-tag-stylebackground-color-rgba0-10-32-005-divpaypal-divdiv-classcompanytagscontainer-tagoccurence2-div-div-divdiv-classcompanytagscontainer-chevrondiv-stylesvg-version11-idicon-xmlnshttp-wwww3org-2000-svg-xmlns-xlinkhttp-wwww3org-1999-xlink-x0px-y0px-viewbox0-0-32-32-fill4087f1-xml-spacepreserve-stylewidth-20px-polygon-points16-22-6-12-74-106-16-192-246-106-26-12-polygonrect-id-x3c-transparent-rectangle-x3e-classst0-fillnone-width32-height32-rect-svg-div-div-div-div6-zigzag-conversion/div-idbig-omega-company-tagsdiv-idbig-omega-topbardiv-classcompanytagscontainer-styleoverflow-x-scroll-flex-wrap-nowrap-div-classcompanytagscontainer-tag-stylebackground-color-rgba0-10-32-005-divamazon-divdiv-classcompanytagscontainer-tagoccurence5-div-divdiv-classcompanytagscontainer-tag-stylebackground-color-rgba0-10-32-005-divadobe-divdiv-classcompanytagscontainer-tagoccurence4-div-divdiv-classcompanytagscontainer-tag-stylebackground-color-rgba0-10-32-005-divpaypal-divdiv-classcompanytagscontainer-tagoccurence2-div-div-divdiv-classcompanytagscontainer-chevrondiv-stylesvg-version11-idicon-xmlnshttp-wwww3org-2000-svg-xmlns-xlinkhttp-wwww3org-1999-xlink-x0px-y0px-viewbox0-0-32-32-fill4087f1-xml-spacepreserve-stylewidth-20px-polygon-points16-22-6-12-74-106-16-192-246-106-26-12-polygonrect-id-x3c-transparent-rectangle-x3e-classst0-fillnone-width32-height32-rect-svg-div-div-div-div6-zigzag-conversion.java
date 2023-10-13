class Solution {
    public String convert(String s, int numRows) {
        
        String ans = "";
        
        int n = s.length();
        
        if(numRows == 1){
            return s;
        }
        
        for(int i = 0 ; i < numRows ; i++){
            int inc = (numRows-1)*2;
            
            for(int j = i ; j < n ; j = j+inc){
                ans += s.charAt(j);
                if(i >=1 && i <= numRows-2){
                    if(j+inc-(2*i) < n){
                        ans += s.charAt(j+inc-(2*i));
                    }
                }
            }
        }
        
        return ans;
    }
}