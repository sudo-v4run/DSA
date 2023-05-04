class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // without repeating characters == all unique characters...
        // Similar to Longest Sustrinh with k unique characters...
        // all unique characters means hm.size() == window size(j-i+1)...
        // therefore k = window size...
        
        HashMap<Character,Integer> hm = new HashMap<>();
        int i = 0, j = 0;
        int n = s.length();
        int max = 0;
        
        while(j < n){
            
            char ch = s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            int k = j-i+1;    // k is window_size...
                              // condition for all unique chars...
            
            if(hm.size() > k){
                // this condition never occurs...
                // since hm size can't be more than window
                // size at any given point...
            }else if(hm.size() == k){
                max = Math.max(max,j-i+1);
                j++;
            }else if(hm.size() < k){
                while(hm.size() < j-i+1){
                    char temp = s.charAt(i);
                    hm.put(temp,hm.get(temp)-1);
                    if(hm.get(temp) == 0){
                        hm.remove(temp);
                    }
                    i++;
                }
                j++;
            }
        }
        
        return max;
    }
}


// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         HashMap<Character,Integer> hm = new HashMap<>();
        
//         int len = 0;
//         int l = 0 ;
//         int r = 0;
        
//         while(r<n){
//             char ch = s.charAt(r);
//             if(hm.containsKey(ch) && hm.get(ch)+1 > l){
//                 l = hm.get(ch)+1;
//             }
//             hm.put(ch,r);
//             len = Math.max(len,r-l+1);
            
//             r++;
//         }
        
//         return len;
//     }
// }