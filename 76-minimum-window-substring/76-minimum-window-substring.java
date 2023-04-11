class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch : t.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int cnt = hm.size();
        
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        int start = -1, end = -1;
        int n = s.length();
        
        if(t.length() > n){
            return "";
        }
        
        while(j <= n){
            if(cnt > 0){
                if(j == n){
                    break;
                }
                char ch = s.charAt(j);
                if(hm.containsKey(ch)){
                    hm.put(ch,hm.get(ch)-1);
                    if(hm.get(ch) == 0){
                        cnt--;
                    }
                }
                j++;
            }else if(cnt == 0){
                if(min > j-i+1){
                    min = j-i+1;
                    start = i;
                    end = j;
                }
                char ithChar = s.charAt(i);
                if(hm.containsKey(ithChar)){
                    hm.put(ithChar,hm.get(ithChar)+1);
                    if(hm.get(ithChar) == 1){
                        cnt++;
                    }
                }
                i++;
            }
        }
        
        // return min if substring size if asked...
        
        if(start == -1){
            return "";
        }
        return s.substring(start,end);
    }
}