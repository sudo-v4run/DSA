class Solution {
    public String clearStars(String s) {
        
        int n = s.length();
        
        HashSet<Integer> hs = new HashSet<>();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.ch == b.ch){
                return b.index-a.index;
            }
            return a.ch-b.ch;
        });
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            
            if(ch == '*'){
                hs.add(pq.poll().index);
                continue;
            }else{
                pq.add(new Pair(ch,i));
            }
        }
        
        String ans = "";
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            
            if(hs.contains(i) || ch == '*'){
                continue;
            }
            
            ans += ch;
        }
        
        return ans;
    }
    class Pair{
        char ch;
        int index;
        
        Pair(char ch, int index){
            this.ch = ch;
            this.index = index;
        }
    }
}