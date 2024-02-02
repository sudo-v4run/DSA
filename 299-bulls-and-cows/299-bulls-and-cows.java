class Solution {
    public String getHint(String secret, String guess) {
        
        int sLen = secret.length();
        int gLen = guess.length();
        
        int bulls = 0;
        int cows = 0;
        
        // Single  Pass...
        
        int cnt[] = new int[10];
        
        for(int i = 0 ; i < sLen ; i++){
            
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if(s == g){
                bulls++;
            }else{
                
                if(cnt[s-'0'] < 0){
                    cows++;
                }
                if(cnt[g-'0'] > 0){
                    cows++;
                }
                
                cnt[s-'0']++;
                cnt[g-'0']--;
            }
        }
        
        
        
        // 2 O(N) passes....
        
//         HashMap<Character,Integer> hm = new HashMap<>();
        
//         for(int i = 0 ; i < sLen ; i++){
//             char ch = secret.charAt(i);
//             if(ch == guess.charAt(i)){
//                 bulls++;
//             }else{
//                 hm.put(ch,hm.getOrDefault(ch,0)+1);
//             }
//         }
        
//         for(int i = 0 ; i < gLen ; i++){
//             char ch = guess.charAt(i);
//             if(ch == secret.charAt(i)){
//                 continue;
//             }
//             if(hm.containsKey(ch)){
//                 cows++;
//                 hm.put(ch,hm.get(ch)-1);
//                 if(hm.get(ch) == 0){
//                     hm.remove(ch);
//                 }
//             }
//         }
        
        return bulls+"A"+cows+"B";
    }
}