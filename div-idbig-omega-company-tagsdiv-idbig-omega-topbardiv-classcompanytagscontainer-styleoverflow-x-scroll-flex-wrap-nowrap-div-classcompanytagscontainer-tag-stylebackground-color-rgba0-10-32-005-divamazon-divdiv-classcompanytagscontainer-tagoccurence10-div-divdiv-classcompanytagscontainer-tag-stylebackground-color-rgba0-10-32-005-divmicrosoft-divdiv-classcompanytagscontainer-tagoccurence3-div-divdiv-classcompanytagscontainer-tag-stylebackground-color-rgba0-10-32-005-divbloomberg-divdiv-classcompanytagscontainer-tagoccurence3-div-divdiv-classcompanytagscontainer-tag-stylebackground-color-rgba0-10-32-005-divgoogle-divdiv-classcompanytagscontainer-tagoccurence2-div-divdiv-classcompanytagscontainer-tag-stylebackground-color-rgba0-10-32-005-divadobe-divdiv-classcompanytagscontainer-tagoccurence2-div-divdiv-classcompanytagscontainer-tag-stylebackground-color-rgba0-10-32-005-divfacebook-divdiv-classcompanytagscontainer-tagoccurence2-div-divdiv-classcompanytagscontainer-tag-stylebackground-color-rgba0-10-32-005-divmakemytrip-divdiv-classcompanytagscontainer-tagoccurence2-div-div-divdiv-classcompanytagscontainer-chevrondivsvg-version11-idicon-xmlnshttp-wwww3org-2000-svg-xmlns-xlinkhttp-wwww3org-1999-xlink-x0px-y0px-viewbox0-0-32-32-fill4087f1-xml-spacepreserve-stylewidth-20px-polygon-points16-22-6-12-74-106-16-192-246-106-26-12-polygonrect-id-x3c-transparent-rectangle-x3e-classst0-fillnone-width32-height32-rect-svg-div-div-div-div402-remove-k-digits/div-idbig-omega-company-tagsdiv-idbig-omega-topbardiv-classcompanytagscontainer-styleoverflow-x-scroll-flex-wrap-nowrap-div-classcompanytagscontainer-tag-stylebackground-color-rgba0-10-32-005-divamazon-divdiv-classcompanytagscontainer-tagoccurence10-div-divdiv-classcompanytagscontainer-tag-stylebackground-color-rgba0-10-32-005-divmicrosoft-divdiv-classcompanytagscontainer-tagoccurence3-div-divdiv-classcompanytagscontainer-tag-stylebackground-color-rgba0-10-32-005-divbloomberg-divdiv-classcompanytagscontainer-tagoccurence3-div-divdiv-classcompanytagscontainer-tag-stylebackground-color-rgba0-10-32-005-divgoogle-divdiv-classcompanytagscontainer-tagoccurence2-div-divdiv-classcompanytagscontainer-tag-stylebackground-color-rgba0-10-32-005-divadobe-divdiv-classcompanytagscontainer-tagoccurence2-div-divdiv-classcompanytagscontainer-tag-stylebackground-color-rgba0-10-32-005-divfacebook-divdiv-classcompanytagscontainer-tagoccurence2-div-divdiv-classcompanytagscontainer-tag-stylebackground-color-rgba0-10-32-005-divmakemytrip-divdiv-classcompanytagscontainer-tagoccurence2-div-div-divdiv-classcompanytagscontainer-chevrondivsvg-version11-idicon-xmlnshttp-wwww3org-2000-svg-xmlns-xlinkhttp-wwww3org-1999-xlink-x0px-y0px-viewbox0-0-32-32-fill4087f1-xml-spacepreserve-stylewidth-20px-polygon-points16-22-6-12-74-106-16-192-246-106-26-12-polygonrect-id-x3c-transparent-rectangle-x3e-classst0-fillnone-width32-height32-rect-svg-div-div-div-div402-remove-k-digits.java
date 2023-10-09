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
        
        StringBuilder ans = new StringBuilder();
        while(!s.isEmpty()){
            ans = ans.append(String.valueOf(s.pop()));
        }
        
        if(ans.length() == 0){
            return "0";
        }
        return ans.reverse().toString();
    }
}