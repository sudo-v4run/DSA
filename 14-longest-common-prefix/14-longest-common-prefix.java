class Solution {
    public String longestCommonPrefix(String[] s) {
        String pre = s[0];
        int n = s.length;
        for(int i =1 ; i <n ; i++ ){
            while(s[i].indexOf(pre)!=0)
                pre = pre.substring(0,pre.length()-1);
        }
        return pre;
        
//         String res=s[0];
//         for(int i = 0 ; i < s[0].length();i++){
//             char ch  = s[0].charAt(i);
//             for(int j = 1 ; j <n ; j++){
//                 if(i>=s[j].length() || ch!=s[j].charAt(i)){
//                     return s[0].substring(0,i);

//                 }
//             }
//         }
       // return res;
    }
}