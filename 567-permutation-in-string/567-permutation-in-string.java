class Solution {
    public boolean checkInclusion(String t, String s) {
        
        int i = 0, j = 0;
        int n1 = s.length();
        int k = t.length();
        
        if(k > n1){
            return false;
        }
        
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch : t.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int cnt = hm.size();
        
        while(j < n1){
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
                    return true;
                }
                char temp = s.charAt(i);
                if(hm.containsKey(temp)){
                    hm.put(temp,hm.get(temp)+1);
                    if(hm.get(temp) == 1){
                        cnt++;
                    }
                }
                i++;
                j++;
            }
        }
        
        return false;
    }
}