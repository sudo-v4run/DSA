class Solution {
    public String removeDuplicateLetters(String s) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        int n = s.length();
        
        Stack<Character> st = new Stack<>();
        
        int vis[] = new int[26];
        
        for(int i = 0 ; i < n ; i++){
            
            char cur = s.charAt(i);
            
            if(vis[cur-'a'] == 1){
                hm.put(cur,hm.get(cur)-1);
                continue;
            }
            
            while(!st.isEmpty() && st.peek() >= cur && hm.get(st.peek()) >= 1){
                vis[st.peek()-'a'] = 0;
                st.pop();
            }
            st.push(cur);
            vis[cur-'a'] = 1;
            hm.put(cur,hm.get(cur)-1);
        }
        
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop()+ans;
        }
        
        return ans;
    }
}