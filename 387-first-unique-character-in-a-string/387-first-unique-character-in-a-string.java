class Solution {
    public int firstUniqChar(String s) {
        
        int freq[] = new int[26];
        
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        
        for(int i = 0 ;  i < s.length() ; i++){
            if(freq[s.charAt(i)-'a']==1)
                return i;
        }
        
        return -1;
        
        
        
        
        
//         LinkedHashMap<Character,Integer> hm = new LinkedHashMap<>();
        
//         for(char ch : s.toCharArray()){
//             hm.put(ch,hm.getOrDefault(ch,0)+1);
//         }
        
//         char ans = '1';
        
//         for(Map.Entry<Character,Integer> e : hm.entrySet()){
//             if(e.getValue()==1){
//                 ans = e.getKey();
//                 break;
//             }
//         }
        
//         for(int i = 0 ; i < s.length(); i++){
//             if(s.charAt(i)==ans){
//                 return i;
//             }
//         }
        
//         return -1;
        
    }
}