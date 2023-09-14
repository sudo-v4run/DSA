class Solution {
    public boolean parseBoolExpr(String exp) {
        
        Stack<Character> s = new Stack<>();
        
        for(char ch : exp.toCharArray()){
            if(ch == ','){
                continue;
            }
            
            if(ch == ')'){
                boolean hasTrue = false;
                boolean hasFalse = false;
                int cnt = 0;
                char ifSingleChar = '#';
                while(s.peek() != '('){
                    char poped = s.pop();
                    if(cnt == 0){
                        ifSingleChar = poped;
                    }
                    if(poped == 't'){
                        hasTrue = true;
                    }else if(poped == 'f'){
                        hasFalse = true;
                    }
                    cnt++;
                }
                s.pop();
                char op = s.pop();
                if(cnt == 1){
                    if(op == '!'){
                        s.push(ifSingleChar == 't' ? 'f' : 't');
                    }else{
                        s.push(ifSingleChar);
                    }
                }else{
                    if(op == '&'){
                        if(hasFalse == false){  // all are chars are true
                            s.push('t');
                        }else{
                            s.push('f');
                        }
                    }else if(op == '|'){
                        if(hasFalse == true && hasTrue == false){   // all are false
                            s.push('f');
                        }else{
                            s.push('t');
                        }
                    }
                }
            }else{
                s.push(ch);
            }
        }
        
        return s.peek() == 't' ? true : false;
    }
}