class Solution {
    static class Pair{
        String str;
        int lvl;
        
        Pair(String str,int lvl){
            this.str = str;
            this.lvl = lvl;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet();
        
        for(String s : wordList){
            if(!s.equals(beginWord))
                hs.add(s);
        }
        
        if(!hs.contains(endWord)){
            return 0;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        
        while(!q.isEmpty()){
            Pair pop = q.poll();
            String curS = pop.str;
            int l = pop.lvl;
            
            if(curS.equals(endWord)){
                return l;
            }
            
            for(int i = 0 ; i < curS.length() ; i++){
                char[] chArray = curS.toCharArray();
                for(char alpha = 'a' ; alpha <='z' ; alpha++){
                    chArray[i] = alpha;
                    String temp = new String(chArray);
                    if(!temp.equals(curS) && hs.contains(temp)){
                        hs.remove(temp);
                        q.add(new Pair(temp,l+1));
                    }
                }
            }
        }
        
        return 0;
    }
}