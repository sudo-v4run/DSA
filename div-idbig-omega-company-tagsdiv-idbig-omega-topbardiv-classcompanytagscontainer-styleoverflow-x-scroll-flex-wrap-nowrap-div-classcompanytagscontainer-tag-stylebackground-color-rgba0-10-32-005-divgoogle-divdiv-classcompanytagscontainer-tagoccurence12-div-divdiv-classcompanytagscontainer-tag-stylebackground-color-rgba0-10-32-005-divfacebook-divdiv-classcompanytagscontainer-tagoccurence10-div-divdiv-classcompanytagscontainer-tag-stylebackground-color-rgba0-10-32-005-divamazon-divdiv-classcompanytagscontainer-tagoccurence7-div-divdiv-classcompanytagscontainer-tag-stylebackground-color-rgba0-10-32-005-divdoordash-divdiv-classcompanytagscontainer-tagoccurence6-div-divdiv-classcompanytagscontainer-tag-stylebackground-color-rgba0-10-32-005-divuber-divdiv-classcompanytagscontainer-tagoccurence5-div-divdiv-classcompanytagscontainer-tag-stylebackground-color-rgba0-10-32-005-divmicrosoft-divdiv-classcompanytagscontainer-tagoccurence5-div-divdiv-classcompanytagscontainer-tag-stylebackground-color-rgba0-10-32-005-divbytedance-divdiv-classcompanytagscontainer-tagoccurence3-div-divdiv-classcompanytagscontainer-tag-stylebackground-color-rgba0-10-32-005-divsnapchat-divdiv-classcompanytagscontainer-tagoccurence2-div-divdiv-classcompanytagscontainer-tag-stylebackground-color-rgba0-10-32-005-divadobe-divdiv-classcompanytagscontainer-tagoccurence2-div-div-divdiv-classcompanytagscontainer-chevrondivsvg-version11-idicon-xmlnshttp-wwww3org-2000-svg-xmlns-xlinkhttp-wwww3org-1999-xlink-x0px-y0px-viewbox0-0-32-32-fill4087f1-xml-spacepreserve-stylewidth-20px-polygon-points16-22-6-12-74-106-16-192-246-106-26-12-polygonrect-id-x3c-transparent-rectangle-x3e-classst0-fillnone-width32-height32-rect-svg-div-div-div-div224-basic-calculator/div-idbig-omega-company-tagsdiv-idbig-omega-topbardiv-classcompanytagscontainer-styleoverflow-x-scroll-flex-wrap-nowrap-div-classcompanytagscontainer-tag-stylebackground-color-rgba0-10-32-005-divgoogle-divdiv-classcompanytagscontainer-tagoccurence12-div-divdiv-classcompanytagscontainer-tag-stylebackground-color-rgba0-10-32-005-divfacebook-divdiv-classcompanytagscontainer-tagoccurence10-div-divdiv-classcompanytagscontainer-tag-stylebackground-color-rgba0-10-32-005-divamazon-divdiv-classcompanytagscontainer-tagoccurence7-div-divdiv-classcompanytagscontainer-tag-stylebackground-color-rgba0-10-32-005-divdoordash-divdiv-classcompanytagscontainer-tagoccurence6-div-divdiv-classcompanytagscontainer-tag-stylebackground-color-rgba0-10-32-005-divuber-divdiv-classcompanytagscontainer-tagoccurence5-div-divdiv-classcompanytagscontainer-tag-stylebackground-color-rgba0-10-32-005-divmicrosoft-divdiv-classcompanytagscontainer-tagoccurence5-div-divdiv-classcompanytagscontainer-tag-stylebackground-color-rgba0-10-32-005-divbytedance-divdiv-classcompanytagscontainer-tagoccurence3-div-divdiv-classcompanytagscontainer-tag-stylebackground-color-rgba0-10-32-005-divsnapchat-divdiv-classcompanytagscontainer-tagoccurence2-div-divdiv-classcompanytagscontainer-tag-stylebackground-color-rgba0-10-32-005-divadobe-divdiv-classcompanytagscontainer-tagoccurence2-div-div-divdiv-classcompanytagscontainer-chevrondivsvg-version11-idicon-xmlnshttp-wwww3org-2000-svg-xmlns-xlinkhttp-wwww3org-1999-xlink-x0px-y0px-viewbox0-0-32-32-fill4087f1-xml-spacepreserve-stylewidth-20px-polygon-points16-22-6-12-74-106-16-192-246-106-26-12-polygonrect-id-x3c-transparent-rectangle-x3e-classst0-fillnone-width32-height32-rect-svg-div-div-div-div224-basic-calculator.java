class Solution {
    public int calculate(String str) {
        
        str = '(' + str + ')';
        
        int n = str.length();
        
        Stack<String> s = new Stack<>();
        String num = "";
        
        for(int i = 0 ; i < n ; i++){
            
            char ch = str.charAt(i);
            if(ch == ' '){
                continue;
            }
            if(ch != ')'){
                if(Character.isDigit(ch)){
                    num += ch;
                }else{
                    if(!num.equals("")){
                        s.push(num);
                        num = "";
                    }
                    s.push(ch+"");
                }
                
            }else{
                if(!num.equals("")){
                    s.push(num);
                    num = "";
                }
                
                Stack<String> temp = new Stack<>();
                while(!s.isEmpty() && !s.peek().equals("(")){
                    temp.push(s.pop());
                }
                s.pop();
                
                int val = 0;
                String op = "+";
                while(!temp.isEmpty()){
                    String cur = temp.pop();
                    if(cur.equals("+") || cur.equals("-")){
                        op = cur;
                    }else{
                        if(op.equals("+")){
                            val += Integer.parseInt(cur);
                        }else{
                            val -= Integer.parseInt(cur);
                        }
                    }
                }
                
                s.push(String.valueOf(val));
            }
        }
        
        return Integer.parseInt(s.peek());
    }
}