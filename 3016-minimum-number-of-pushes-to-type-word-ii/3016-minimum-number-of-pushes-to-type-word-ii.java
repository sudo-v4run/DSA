class Solution {
    class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public int minimumPushes(String word) {
        
        int n = word.length();
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            char ch = word.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        ArrayList<Pair> arr = new ArrayList<>();
        
        for(char ch : hm.keySet()){
            arr.add(new Pair(ch,hm.get(ch)));
        }
        
        Collections.sort(arr,(a,b)->{
            return b.freq-a.freq;
        });
        
        int res = 0;
        
        int k = 0;
        for(Pair p : arr){
            char ch = p.ch;
            res += ((k/8) +1)*p.freq;
            k++;
        }
        
        return res;
    }
}