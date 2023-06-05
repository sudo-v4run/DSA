class Solution {
    public int minimizedStringLength(String s) {
        
        HashSet<Character> hs = new HashSet<>();
        
        for(char ch : s.toCharArray()){
            hs.add(ch);
        }
        
        return hs.size();
    }
}