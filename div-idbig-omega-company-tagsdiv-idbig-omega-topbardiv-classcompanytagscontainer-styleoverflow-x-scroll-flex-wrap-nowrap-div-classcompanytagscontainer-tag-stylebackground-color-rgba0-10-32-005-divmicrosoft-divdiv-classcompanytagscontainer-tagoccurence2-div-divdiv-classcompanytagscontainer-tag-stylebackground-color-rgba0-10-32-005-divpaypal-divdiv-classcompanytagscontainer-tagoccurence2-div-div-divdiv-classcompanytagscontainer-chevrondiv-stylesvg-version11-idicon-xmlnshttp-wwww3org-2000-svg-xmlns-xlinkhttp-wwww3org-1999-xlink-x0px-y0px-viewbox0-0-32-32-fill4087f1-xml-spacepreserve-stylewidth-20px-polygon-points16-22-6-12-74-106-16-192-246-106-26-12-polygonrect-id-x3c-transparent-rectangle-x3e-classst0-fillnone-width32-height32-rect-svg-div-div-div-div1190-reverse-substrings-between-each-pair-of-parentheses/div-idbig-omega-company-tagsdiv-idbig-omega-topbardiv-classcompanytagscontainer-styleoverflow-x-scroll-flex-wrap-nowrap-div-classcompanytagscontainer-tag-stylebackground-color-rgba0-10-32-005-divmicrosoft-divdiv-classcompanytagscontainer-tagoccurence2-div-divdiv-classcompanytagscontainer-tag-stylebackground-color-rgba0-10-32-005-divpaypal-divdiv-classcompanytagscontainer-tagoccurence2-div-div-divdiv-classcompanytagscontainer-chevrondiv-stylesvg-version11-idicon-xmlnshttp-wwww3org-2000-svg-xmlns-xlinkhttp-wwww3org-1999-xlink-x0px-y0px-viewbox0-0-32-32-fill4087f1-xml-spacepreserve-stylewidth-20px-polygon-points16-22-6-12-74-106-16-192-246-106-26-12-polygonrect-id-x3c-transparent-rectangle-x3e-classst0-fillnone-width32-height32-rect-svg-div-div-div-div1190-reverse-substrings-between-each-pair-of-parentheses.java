class Solution {
    public String reverseParentheses(String str) {
        
        str = '(' + str + ')';
        
        Stack<String> s = new Stack<>();
        
        for(int i = 0 ; i < str.length() ; i++){
            char cur = str.charAt(i);
            
            if(cur == ')'){
                StringBuilder temp = new StringBuilder();
                while(!s.isEmpty() && !s.peek().equals("(")){
                    String top = s.pop();
                    for(int j = top.length()-1 ; j >= 0 ; j--){
                        temp.append(top.charAt(j));
                    }
                }
                s.pop();
                s.push(temp.toString());
            }else{
                s.push(cur+"");
            }
        }
        
        StringBuilder ans = new StringBuilder();
        String ss = s.pop();
        for(int i = ss.length()-1 ; i >= 0 ; i--){
            ans.append(ss.charAt(i));
        }
        
        return ans.toString();
    }
}