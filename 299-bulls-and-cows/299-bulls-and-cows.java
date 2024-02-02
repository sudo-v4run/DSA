class Solution {
    public String getHint(String secret, String guess) {
        
        int sLen = secret.length();
        int gLen = guess.length();
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        int bulls = 0;
        int cows = 0;
        
        for(int i = 0 ; i < sLen ; i++){
            char ch = secret.charAt(i);
            if(ch == guess.charAt(i)){
                bulls++;
            }else{
                hm.put(ch,hm.getOrDefault(ch,0)+1);
            }
        }
        
        for(int i = 0 ; i < gLen ; i++){
            char ch = guess.charAt(i);
            if(ch == secret.charAt(i)){
                continue;
            }
            if(hm.containsKey(ch)){
                cows++;
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch) == 0){
                    hm.remove(ch);
                }
            }
        }
        
        return bulls+"A"+cows+"B";
    }
}