class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        
//         String ans = strs[0];
        
//         for(int i = 1; i < n ; i++){
//             String curS = strs[i];
//             while(curS.indexOf(ans)!=0){
//                 ans = ans.substring(0,ans.length()-1);
//             }
//         }
        
        
//         return ans;
        
        
        
        String ans = strs[0];
        
        for(int i = 0 ; i < ans.length() ; i++){
            char ch = ans.charAt(i);
            for(int j = 1 ; j < n ; j++){
                String curS= strs[j];
                if(i>=curS.length()||ch!=curS.charAt(i)){
                    return ans.substring(0,i);
                }
            }
        }
        
        return ans;
        
        
//         for(int i = 1; i < n ; i++){
//             String curS = strs[i];
//             while(ans.length()>curS.length() || 
//                             !ans.equals(curS.substring(0,ans.length()) )  ){
//                 ans = ans.substring(0,ans.length()-1);
//             }
//         }
        
//         return ans;
    }
}