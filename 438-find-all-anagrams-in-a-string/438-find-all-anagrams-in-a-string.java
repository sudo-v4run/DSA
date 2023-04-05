class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
//         int n = s.length();
//         int k = p.length();
        
//         int i = 0;
//         int j = 0;
        
//         HashMap<Character,Integer> hm = new HashMap<>();
//         for(char ch : p.toCharArray()){
//             hm.put(ch,hm.getOrDefault(ch,0)+1);
//         }
        
//         List<Integer> res = new ArrayList<>();
//         int cnt = hm.size();    // count of distinct letters...i.e. size of hashMap
        
//         while(j < n){
//             char ch = s.charAt(j);
//             if(hm.containsKey(ch)){
//                 hm.put(ch,hm.get(ch)-1);
//                 if(hm.get(ch) == 0){
//                     cnt--;
//                 }
//             }
            
//             if(j-i+1 < k){
//                 j++;
//             }else if(j-i+1 == k){
//                 if(cnt == 0){
//                     res.add(i);
//                 }
                
//                 char ithChar = s.charAt(i);
                
//                 if(hm.containsKey(ithChar)){
//                     hm.put(ithChar,hm.get(ithChar)+1);
//                     if(hm.get(ithChar) == 1){
//                         cnt++;
//                     }
//                 }
//                 i++;j++;
//             }
//         }
        
//         return res;
        
        
        // TC -> O(N*26)... SC->O(1)...
        
        
        int n = s.length();
        int k = p.length();
        
        int window[] = new int[26];
        int freq[] = new int[26];
        
        List<Integer> res = new ArrayList<>();
        
        if(n<k){
            return res;
        }
        
        for(int i = 0 ; i < k ; i++){
            window[s.charAt(i)-'a']++;
            freq[p.charAt(i)-'a']++;
        }
        
        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] != window[i]){
                break;
            }
            if(i==25){
                res.add(0);
            }
        }
        
        for(int i = k ; i < n ; i++){
            window[s.charAt(i-k) - 'a']--;
            window[s.charAt(i)-'a']++;
            
            for(int j = 0 ; j < 26 ; j++){
                if(freq[j] != window[j]){
                    break;
                }
                if(j==25){
                    res.add(i-k+1);
                }
            }
        }
        
        return res;
    }
}