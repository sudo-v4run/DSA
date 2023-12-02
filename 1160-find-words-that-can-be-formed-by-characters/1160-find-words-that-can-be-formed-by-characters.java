class Solution {
    public int countCharacters(String[] words, String chars) {
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(char ch : chars.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        int cnt = 0;
        
        for(String s : words){
            HashMap<Character,Integer> curMap = new HashMap<>();
            boolean flag = true;
            for(int i = 0 ; i < s.length() ; i++){
                char cur = s.charAt(i);
                
                curMap.put(cur,curMap.getOrDefault(cur,0)+1);
                if(!hm.containsKey(cur) || hm.get(cur) < curMap.get(cur)){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                cnt += s.length();
            }
        }
        
        return cnt;
    }
}