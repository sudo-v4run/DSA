class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Integer> s = new Stack<>();
        
        for(char ch : num.toCharArray()){
            int x = ch-'0';
            
            while(k != 0 && !s.isEmpty() && s.peek() > x){
                s.pop();
                k--;
            }
            
            if(s.isEmpty() && x == 0){
                continue;
            }
            s.push(x);
        }
        
        while(!s.isEmpty() && k != 0){
            s.pop();
            k--;
        }
        
        String ans = "";
        while(!s.isEmpty()){
            ans = String.valueOf(s.pop()) + ans;
        }
        
        return ans.equals("") ? "0" : ans;
    }
}