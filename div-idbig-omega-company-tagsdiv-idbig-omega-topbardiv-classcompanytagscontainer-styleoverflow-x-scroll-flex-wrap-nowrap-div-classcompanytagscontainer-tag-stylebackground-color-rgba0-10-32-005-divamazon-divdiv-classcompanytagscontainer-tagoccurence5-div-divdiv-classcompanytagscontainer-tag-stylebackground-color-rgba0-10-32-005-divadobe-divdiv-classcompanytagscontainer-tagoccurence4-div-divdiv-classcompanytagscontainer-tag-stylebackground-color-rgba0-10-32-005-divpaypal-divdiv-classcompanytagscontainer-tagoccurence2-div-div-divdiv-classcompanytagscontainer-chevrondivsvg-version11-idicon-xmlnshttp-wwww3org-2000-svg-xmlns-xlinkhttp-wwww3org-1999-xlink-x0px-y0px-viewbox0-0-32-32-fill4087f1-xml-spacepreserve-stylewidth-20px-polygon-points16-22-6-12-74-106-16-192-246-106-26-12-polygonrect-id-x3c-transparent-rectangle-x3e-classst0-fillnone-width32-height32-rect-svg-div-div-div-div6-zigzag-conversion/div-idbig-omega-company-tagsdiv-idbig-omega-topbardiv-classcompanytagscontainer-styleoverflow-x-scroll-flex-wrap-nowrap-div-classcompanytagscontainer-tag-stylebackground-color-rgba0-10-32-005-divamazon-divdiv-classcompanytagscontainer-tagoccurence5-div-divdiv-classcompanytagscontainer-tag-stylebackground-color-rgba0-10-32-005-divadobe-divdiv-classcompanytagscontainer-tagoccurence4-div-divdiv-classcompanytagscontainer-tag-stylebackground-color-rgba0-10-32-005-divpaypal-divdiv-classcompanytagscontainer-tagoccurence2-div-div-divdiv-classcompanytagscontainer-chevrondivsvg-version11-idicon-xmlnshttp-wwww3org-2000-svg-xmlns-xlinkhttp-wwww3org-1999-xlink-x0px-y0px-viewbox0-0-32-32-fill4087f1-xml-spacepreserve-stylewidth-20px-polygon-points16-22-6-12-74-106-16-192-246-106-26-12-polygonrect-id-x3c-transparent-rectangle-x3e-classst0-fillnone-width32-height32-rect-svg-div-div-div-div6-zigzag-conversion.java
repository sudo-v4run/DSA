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
                if(i >= 1 && i <= numRows-2){
                    if(j+inc-(2*i) < n){
                        ans += s.charAt(j+inc-(2*i));
                    }
                }
            }
        }
        
        return ans;
        
        
//         char[] c = s.toCharArray();
//         int len = c.length;
//         StringBuffer[] sb = new StringBuffer[nRows];
        
//         for (int i = 0; i < sb.length; i++){
//             sb[i] = new StringBuffer();
//         }

//         int i = 0;
//         while (i < len) {
//             for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
//                 sb[idx].append(c[i++]);
//             for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
//                 sb[idx].append(c[i++]);
//         }
        
//         for (int idx = 1; idx < sb.length; idx++)
//             sb[0].append(sb[idx]);
        
//         return sb[0].toString();
    }
}