class Solution {
    public int findPermutationDifference(String s, String t) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            
            hm.put(ch,i);
        }
        
        int sum = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            
            sum += Math.abs(i-hm.get(s.charAt(i)));
        }
        
        return sum;
    }
}