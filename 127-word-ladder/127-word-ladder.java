class Solution {
    
    static class Pair{
        String str;
        int lvl;
        
        Pair(String str, int lvl){
            this.str = str;
            this.lvl = lvl;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, 
                                            List<String> wordList) {
        
        Queue<Pair> q = new LinkedList<>();
        Set<String> hs = new HashSet();
        
        for(String s : wordList){
            hs.add(s);
        }
        
        q.add(new Pair(beginWord,1));
        
        while(!q.isEmpty()){
            Pair pop = q.poll();
            String s = pop.str;
            int l = pop.lvl;
            
            if(s.equals(endWord)){
                return l;
            }
            
            for(int i = 0 ; i < s.length() ; i++){
                char[] chArray = s.toCharArray();
                
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    chArray[i] = ch;
                    String toString = new String(chArray);
                    
                    if(hs.contains(toString)){
                        q.add(new Pair(toString,l+1));
                        hs.remove(toString);
                    }
                }
            }
            
        }
        
        return 0;
    }
}