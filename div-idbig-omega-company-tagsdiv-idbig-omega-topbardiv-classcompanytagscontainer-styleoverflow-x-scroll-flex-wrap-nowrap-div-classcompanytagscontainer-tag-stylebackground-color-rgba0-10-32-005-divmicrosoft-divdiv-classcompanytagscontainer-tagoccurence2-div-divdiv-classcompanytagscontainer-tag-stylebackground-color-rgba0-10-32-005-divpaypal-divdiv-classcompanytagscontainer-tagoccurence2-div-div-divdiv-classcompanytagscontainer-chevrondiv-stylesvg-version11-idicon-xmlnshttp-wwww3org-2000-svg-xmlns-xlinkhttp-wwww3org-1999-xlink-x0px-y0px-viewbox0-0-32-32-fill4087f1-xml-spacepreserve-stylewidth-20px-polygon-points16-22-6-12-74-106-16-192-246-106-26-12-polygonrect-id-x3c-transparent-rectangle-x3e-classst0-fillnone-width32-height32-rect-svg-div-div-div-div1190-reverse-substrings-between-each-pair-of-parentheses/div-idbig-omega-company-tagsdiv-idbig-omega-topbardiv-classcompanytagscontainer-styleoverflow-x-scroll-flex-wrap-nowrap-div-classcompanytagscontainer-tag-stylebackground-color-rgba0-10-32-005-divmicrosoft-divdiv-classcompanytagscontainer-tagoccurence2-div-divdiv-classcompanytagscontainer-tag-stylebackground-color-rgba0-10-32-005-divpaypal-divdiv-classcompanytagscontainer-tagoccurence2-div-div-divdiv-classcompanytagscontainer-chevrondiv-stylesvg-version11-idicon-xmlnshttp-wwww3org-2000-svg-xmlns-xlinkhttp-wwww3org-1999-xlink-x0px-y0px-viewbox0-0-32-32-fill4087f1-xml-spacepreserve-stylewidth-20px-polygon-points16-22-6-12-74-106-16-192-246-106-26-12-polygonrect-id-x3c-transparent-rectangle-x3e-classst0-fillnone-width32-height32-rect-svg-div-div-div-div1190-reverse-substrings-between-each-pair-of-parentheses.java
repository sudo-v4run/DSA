class Solution {
    public String reverseParentheses(String str) {
        
        str = '(' + str + ')';
        
        Stack<String> s = new Stack<>();
        
        for(int i = 0 ; i < str.length() ; i++){
            char cur = str.charAt(i);
            
            if(cur == ')'){
                String temp = "";
                while(!s.isEmpty() && !s.peek().equals("(")){
                    String top = s.pop();
                    for(int j = top.length()-1 ; j >= 0 ; j--){
                        temp += top.charAt(j);
                    }
                }
                s.pop();
                s.push(temp);
            }else{
                s.push(cur+"");
            }
        }
        
        String ans = "";
        String ss = s.pop();
        for(int i = ss.length()-1 ; i >= 0 ; i--){
            ans += ss.charAt(i);
        }
        
        return ans;
    }
}