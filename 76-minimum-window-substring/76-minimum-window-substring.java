class Solution {
    public String minWindow(String s, String t) {
        
        int n1 = s.length();
        int n2 = t.length();
        int start = -1;
        int end = -1;
        int ans = Integer.MAX_VALUE;
        
        Map<Character,Integer> hm = new HashMap();
        
        int i = 0, j = 0 ;
        
        for(char ch : t.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        int cnt = hm.size();
        
        while(j<=n1){
            
            if(cnt>0){
                
                if(j>=n1)
                    break;
                
                char ch = s.charAt(j);
                
                if(hm.containsKey(ch)){
                    hm.put(ch,hm.get(ch)-1);
                    
                    if(hm.get(ch)==0){
                        cnt--;
                    }
                }
                
                j++;
            }
            
            if(cnt==0){
                
                if(i>=n1)
                    break;
                
                int len = j-i;
                
                if(len<ans){
                    ans = len;
                    start = i;
                    end = j;
                }
                
                char ch = s.charAt(i);
                
                if(hm.containsKey(ch) && hm.get(ch)<=0){
                    hm.put(ch,hm.get(ch)+1);
                    if(hm.get(ch)>=1){
                        cnt++;
                    }
                }
                i++;
            }
            
        }
        
        if(start==-1)
            return "";
        
        return s.substring(start,end);
    }
}