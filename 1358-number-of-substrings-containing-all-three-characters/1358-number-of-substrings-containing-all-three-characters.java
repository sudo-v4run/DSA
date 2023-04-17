class Solution {
    public int numberOfSubstrings(String s){
        
        // return atmostK(s,3) - atmostK(s,2);
        
        int cnt = 0;
        int i = 0;
        int freq[] = {0,0,0};
        int n = s.length();
        
        for(int j = 0 ; j < n ; j++){
            freq[s.charAt(j)-'a']++;
            
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                freq[s.charAt(i)-'a']--;
                i++;
            }
            cnt += i;
        }
        
        return cnt;
    }
    public static int atmostK(String s, int k){
        
        int i = 0, j = 0;
        int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        int cnt = 0;
        
        while(j < n){
            char ch = s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            if(hm.size() <= k){
                cnt += j-i+1;
                j++;
            }else if(hm.size() > k){
                while(hm.size() > k){
                    if(hm.containsKey(s.charAt(i))){
                        hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                        if(hm.get(s.charAt(i)) == 0){
                            hm.remove(s.charAt(i));
                        }
                    }
                    i++;
                }
                cnt += j-i+1;
                j++;
            }
        }
        
        return cnt;
    }
}