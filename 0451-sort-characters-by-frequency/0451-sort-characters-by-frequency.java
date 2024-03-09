class Solution {
    
    public String frequencySort(String s) {
        
        int n = s.length();
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        ArrayList<Character>[] cnt = new ArrayList[n+1];
        
        for(char ch : hm.keySet()){
            
            int f = hm.get(ch);
            if(cnt[f] == null){
                cnt[f] = new ArrayList<>();
            }
            for(int i = 0 ; i < f ; i++){
                cnt[f].add(ch);
            }
        }
        
        String ans = "";
        
        for(int i = n ; i >= 0 ; i--){
            if(cnt[i] == null){
                continue;
            }
            for(char ch : cnt[i]){
                ans += ch;
            }
        }
        
        return ans;
    }
}

// class Solution {
    
//     class Pair{
//         char ch;
//         int f;
//         Pair(char ch, int f){
//             this.ch = ch;
//             this.f = f;
//         }
//     }
//     public String frequencySort(String s) {
        
//         HashMap<Character,Integer> hm = new HashMap<>();
        
//         for(char ch : s.toCharArray()){
//             hm.put(ch,hm.getOrDefault(ch,0)+1);
//         }
        
//         ArrayList<Pair> res = new ArrayList<>();
        
//         for(char k : hm.keySet()){
//             int f = hm.get(k);
//             res.add(new Pair(k,f));
//         }
        
//         Collections.sort(res,(a,b)->{
//             return b.f - a.f;
//         });
        
//         String ans = "";
        
//         for(Pair p : res){
//             for(int i = 0 ; i < p.f ; i++){
//                 ans += p.ch;
//             }
//         }
        
//         return ans;
//     }
// }