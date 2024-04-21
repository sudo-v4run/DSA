class Solution {
    public int numberOfSpecialChars(String word) {
        
        HashMap<Character,Integer> lastOfSmalls = new HashMap<>();
        HashMap<Character,Integer> firstOfCaps = new HashMap<>();
        
        int cnt = 0;
        
        for(int i = 0 ; i < word.length() ; i++){
            
            char ch = word.charAt(i);
            
            if(ch >= 'a' && ch <= 'z'){
                lastOfSmalls.put(ch,i);
            }else{
                if(!firstOfCaps.containsKey(ch)){
                    firstOfCaps.put(ch,i);
                }
            }
        }
        
        for(char ch : word.toCharArray()){
            
            if(ch >= 'A' && ch <= 'Z'){
                char smallCh = Character.toLowerCase(ch);
                
                if(lastOfSmalls.containsKey(smallCh) 
                   && lastOfSmalls.get(smallCh) < firstOfCaps.get(ch)){
                    
                    cnt += 1;
                    lastOfSmalls.remove(smallCh);
                }
            }
        }
        
        return cnt;
    }
}