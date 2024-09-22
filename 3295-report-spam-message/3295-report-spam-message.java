class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        
        HashSet<String> hs = new HashSet<>();
        for(String s : bannedWords){
            hs.add(s);
        }
        
        int cnt = 0;
        
        for(String s : message){
            if(hs.contains(s)){
                cnt++;
                if(cnt == 2){
                    return true;
                }
            }
        }
        
        return false;
    }
}