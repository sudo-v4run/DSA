class Solution {
    public int minimizedStringLength(String s) {
        
        return (int) s.chars().distinct().count();
        
//         HashSet<Character> hs = new HashSet<>();
        
//         for(char ch : s.toCharArray()){
//             hs.add(ch);
//         }
        
//         return hs.size();
    }
}