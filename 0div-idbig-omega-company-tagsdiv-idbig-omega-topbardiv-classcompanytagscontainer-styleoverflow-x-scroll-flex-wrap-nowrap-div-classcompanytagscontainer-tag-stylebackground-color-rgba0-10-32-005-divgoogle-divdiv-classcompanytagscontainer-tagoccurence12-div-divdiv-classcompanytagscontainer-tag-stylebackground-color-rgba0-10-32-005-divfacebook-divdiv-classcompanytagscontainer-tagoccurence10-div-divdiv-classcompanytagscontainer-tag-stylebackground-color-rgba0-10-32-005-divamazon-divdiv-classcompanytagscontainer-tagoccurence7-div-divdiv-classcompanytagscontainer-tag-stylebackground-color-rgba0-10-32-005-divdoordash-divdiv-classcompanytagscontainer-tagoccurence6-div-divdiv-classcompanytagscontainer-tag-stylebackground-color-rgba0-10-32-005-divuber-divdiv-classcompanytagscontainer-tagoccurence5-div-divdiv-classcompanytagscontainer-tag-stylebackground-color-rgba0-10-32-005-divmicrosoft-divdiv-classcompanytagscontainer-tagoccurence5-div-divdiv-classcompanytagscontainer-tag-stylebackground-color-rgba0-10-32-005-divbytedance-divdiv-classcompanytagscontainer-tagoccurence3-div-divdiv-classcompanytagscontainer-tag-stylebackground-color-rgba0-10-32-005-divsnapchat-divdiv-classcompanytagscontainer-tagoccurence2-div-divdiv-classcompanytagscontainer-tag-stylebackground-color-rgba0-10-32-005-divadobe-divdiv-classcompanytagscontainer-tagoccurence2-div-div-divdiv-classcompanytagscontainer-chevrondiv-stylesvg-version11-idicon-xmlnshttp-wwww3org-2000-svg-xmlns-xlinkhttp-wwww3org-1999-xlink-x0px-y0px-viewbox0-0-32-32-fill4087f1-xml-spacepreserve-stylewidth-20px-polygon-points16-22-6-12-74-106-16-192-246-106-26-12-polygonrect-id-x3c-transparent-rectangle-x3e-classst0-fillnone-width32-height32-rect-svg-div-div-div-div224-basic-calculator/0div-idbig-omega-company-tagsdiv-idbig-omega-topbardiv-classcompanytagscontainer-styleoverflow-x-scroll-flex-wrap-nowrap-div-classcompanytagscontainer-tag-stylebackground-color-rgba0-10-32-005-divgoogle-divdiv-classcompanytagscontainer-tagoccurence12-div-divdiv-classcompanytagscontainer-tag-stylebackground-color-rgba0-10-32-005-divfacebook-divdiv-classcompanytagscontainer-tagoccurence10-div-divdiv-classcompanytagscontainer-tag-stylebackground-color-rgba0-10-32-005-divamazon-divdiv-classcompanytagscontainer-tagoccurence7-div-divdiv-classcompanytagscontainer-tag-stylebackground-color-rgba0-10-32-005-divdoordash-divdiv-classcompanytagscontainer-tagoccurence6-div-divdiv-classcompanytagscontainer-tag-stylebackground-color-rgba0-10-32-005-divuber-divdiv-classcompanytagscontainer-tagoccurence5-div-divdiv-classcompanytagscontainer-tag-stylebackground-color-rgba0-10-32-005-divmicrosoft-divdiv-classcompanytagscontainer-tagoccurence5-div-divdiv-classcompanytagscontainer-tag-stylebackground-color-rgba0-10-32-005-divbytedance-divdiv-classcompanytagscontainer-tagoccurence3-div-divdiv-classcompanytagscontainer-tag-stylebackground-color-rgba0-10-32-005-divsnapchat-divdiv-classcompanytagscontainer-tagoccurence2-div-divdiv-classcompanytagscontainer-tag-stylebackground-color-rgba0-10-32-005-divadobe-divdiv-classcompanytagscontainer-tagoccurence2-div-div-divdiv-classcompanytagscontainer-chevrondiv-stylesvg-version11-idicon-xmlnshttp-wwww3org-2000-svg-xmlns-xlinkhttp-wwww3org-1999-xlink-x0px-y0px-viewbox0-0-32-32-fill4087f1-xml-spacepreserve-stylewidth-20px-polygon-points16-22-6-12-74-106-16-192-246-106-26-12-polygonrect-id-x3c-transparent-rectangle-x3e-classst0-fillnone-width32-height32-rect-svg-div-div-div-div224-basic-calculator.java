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
                
                int val = 0;
                String op = "+";
                while(!s.isEmpty() && !s.peek().equals("(")){
                    String cur = s.pop();
                    if(cur.equals("+") || cur.equals("-")){
                        continue;
                    }
                    if(s.peek().equals("-")){
                        val += -1*Integer.parseInt(cur);
                    }else{
                        val += Integer.parseInt(cur);
                    }
                    
                }
                s.pop();
                s.push(String.valueOf(val));
            }
        }
        
        return Integer.parseInt(s.peek());
    }
}