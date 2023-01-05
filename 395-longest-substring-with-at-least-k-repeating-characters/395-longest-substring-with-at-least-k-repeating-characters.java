class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        
        if(n==0 || n<k){
            return 0;
        }
        if(k<=1){
            return n;
        }
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        int index = 0;
        
        while( index<n && hm.get(s.charAt(index)) >=k ){
            index++;
        }
        
        if(index>=n-1){
            return index;
        }
        
        int left = longestSubstring(s.substring(0,index),k);
        
        while(index<n && hm.get(s.charAt(index)) <k ){
            index++;
        }
        
        int right = longestSubstring(s.substring(index),k);
        
        return Math.max(left,right);
    }
    
    
    
    
    
//     public int longestSubstring(String s, int k) {
        
//         int n = s.length();
        
//         int ans = 0;
        
//         for(int i = 0 ; i < n ; i++){
//             String temp = "";
//             for(int j = i ; j < n ; j++){
//                 temp+=s.charAt(j);
//                 int posLen = findPosLen(temp,k);
//                 ans = Math.max(ans,posLen);
//             }
//         }
        
//         return ans;
//     }
//     public static int findPosLen(String temp,int k){
//         HashMap<Character,Integer> hm = new HashMap<>();
//         int n = temp.length();
        
//         for(char ch : temp.toCharArray()){
//             hm.put(ch,hm.getOrDefault(ch,0)+1);
//         }
        
//         for(int val : hm.values()){
//             if(!(val>=k)){
//                 return 0;
//             }
//         }
        
//         return n;
//     }
    
}