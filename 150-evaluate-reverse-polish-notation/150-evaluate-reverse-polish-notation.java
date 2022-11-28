class Solution {
    public int evalRPN(String[] tokens){
        
        Stack<Integer> s = new Stack<>();
        
        for(String str : tokens){
            if(str.equals("+")){
                s.push(s.pop()+s.pop());
            }else if(str.equals("-")){
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(op1-op2);
            }else if(str.equals("*")){
                s.push(s.pop()*s.pop());
            }else if(str.equals("/")){
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(op1/op2);
            }else{
                s.push(Integer.parseInt(str));
            }
        }
        
        return s.peek();
    }
}