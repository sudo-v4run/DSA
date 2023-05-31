class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open.push(i);
            }else if(ch == '*'){
                star.push(i);
            }else{  // balancing ) paranthesis...
                if(!open.isEmpty()){
                    open.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        
        // balancing ( paranthesis...
        
        while(!open.isEmpty()){
            
            if(star.isEmpty()){
                return false;
            }
            if(star.peek() < open.peek()){    
                    // * should be present to the right of ( to be valid..
                    // so if index of * < index of ( , return false...
                return false;
            }
            star.pop();
            open.pop();
        }
        
        return true;
    }
}