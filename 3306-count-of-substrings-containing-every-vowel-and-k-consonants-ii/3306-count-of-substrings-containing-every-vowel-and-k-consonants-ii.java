class Solution {
    public long countOfSubstrings(String word, int k) {
        
        //System.out.println(atmostK(word,k));
        //System.out.println(atmostK(word,k-1));
        
        return atleastK(word,k)-atleastK(word,k+1);
    }
    public long atleastK(String word, int k) {
        
        int n = word.length();
        
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');hs.add('e');hs.add('i');hs.add('o');hs.add('u');
        
        int i = 0;
        int j = 0;
        
        HashMap<Character,Integer> vowVis = new HashMap<>();
        
        long cnt = 0;
        int c = 0;
        
        while(j < n){
            char ch = word.charAt(j);
            
            if(hs.contains(ch)){
                vowVis.put(ch,vowVis.getOrDefault(ch,0)+1);
            }else{
                c++;
            }
            
            while(i <= j && vowVis.size() == 5 && c >= k){
                
                cnt += n-j;
                    
                char ithChar = word.charAt(i);

                if(vowVis.containsKey(ithChar)){
                    vowVis.put(ithChar,vowVis.get(ithChar)-1);
                    if(vowVis.get(ithChar) == 0){
                        vowVis.remove(ithChar);
                    }
                }else{
                    c--;
                }

                i++;
            }
            
            j++;
        }
        
        return cnt;
    }
}