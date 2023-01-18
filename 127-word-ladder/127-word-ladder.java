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
            String[] hsArr = hs.toArray(new String[hs.size()]);
            for(String word : hsArr){
                int cnt = 0;
                for(int i = 0 ; i < word.length() ; i++){
                    if(word.charAt(i)!=s.charAt(i)){
                        cnt++;
                    }
                }
                if(cnt==1){
                    q.add(new Pair(word,l+1));
                    hs.remove(word);
                }
            }
        }
        
        return 0;
    }
}