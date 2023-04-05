class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int n = s.length();
        int k = p.length();
        
        int i = 0;
        int j = 0;
        
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch : p.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        List<Integer> res = new ArrayList<>();
        int cnt = hm.size();    // count of distinct letters...i.e. size of hashMap
        
        while(j < n){
            char ch = s.charAt(j);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch) == 0){
                    cnt--;
                }
            }
            
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                if(cnt == 0){
                    res.add(i);
                }
                
                char ithChar = s.charAt(i);
                
                if(hm.containsKey(ithChar)){
                    hm.put(ithChar,hm.get(ithChar)+1);
                    if(hm.get(ithChar) == 1){
                        cnt++;
                    }
                }
                i++;j++;
            }
        }
        
        return res;
    }
}