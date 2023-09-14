class Solution {
    public boolean parseBoolExpr(String exp) {
        
        Stack<Character> s = new Stack<>();
        
        for(char ch : exp.toCharArray()){
            if(ch == ','){
                continue;
            }
            
            if(ch == ')'){
                HashSet<Character> hs = new HashSet<>();
                while(s.peek() != '('){
                    char poped = s.pop();
                    hs.add(poped);
                }
                s.pop();
                char op = s.pop();
                if(op == '&'){
                    if(!hs.contains('f')){  // all are chars are true
                        s.push('t');
                    }else{
                        s.push('f');
                    }
                }else if(op == '|'){
                    if(hs.contains('t')){   // atleast one true is present
                        s.push('t');
                    }else{
                        s.push('f');
                    }
                }else{
                    if(hs.contains('t')){
                        s.push('f');
                    }else{
                        s.push('t');
                    }
                }
            }else{
                s.push(ch);
            }
        }
        
        return s.peek() == 't' ? true : false;
    }
}