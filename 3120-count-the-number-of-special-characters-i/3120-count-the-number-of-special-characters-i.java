class Solution {
    public int numberOfSpecialChars(String word) {
        
        HashSet<Character> hs = new HashSet<>();
        
        int cnt = 0;
        
        for(char ch : word.toCharArray()){
            
            hs.add(ch);
        }
        
        for(char ch : hs){
            if(ch >= 'a' && ch <= 'z'){
                if(hs.contains(Character.toUpperCase(ch))){
                    cnt++;
                }
            }else{
                if(hs.contains(Character.toLowerCase(ch))){
                    cnt++;
                }
            }
        }
        
        return cnt/2;
    }
}