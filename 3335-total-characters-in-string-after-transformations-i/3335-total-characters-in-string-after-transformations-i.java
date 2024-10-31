class Solution {
    public int lengthAfterTransformations(String s, int t) {
        
        int mod = (int)1e9+7;
        
        int freq[] = new int[26];
        
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        
        while(t != 0){
            
            int temp[] = new int[26];
            
            for(int i = 0 ; i < 26 ; i++){
                if(i == 25 && freq[i] != 0){
                    
                    temp[0] = (temp[0] + freq[i])%mod;
                    temp[1] = (temp[1] + freq[i])%mod;
                }else if(freq[i] != 0){
                    
                    temp[i+1] = (temp[i+1] + freq[i])%mod;
                }
            }
            
            freq = temp;
            
            t--;
        }
        
        int ans = 0;
        for(int cnt : freq){
            ans = (ans + cnt)%mod;
        }
        
        return ans;
        
        
        
        
//         HashMap<Character,Integer> hm = new HashMap<>();
        
//         for(char ch : s.toCharArray()){
//             hm.put(ch,hm.getOrDefault(ch,0)+1);
//         }
        
//         while(t != 0){
            
//             HashMap<Character, Integer> tempMap = new HashMap<>();
            
//             for (char ch : hm.keySet()) {
//                 if (ch == 'z') {
//                     tempMap.put('a', (tempMap.getOrDefault('a', 0) + hm.get(ch))%mod);
//                     tempMap.put('b', (tempMap.getOrDefault('b', 0) + hm.get(ch))%mod);
//                 } else {
//                     char nxt = ch;
//                     nxt++;
//                     tempMap.put(nxt, (tempMap.getOrDefault(nxt, 0) + hm.get(ch))%mod);
//                 }
//             }
            
//             hm = tempMap;
//             t--;
//         }
        
//         int ans = 0;
        
//         for(char ch : hm.keySet()){
//             ans = (ans + hm.get(ch))%mod;
//         }
        
//         return ans;
    }
}