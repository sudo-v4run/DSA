class Solution {
    public boolean isValid(String S) {
        Stack<Character> s = new Stack<>();
        
        for(int i = 0 ; i < S.length();i++){
            char ch = S.charAt(i);
//             if(ch=='('|| ch=='{' || ch== '['){
//                 s.push(ch);
//             }else{
//                 if(ch==')'){
//                     if(!s.isEmpty() && s.peek()=='('){
//                         s.pop();
//                     }else
//                         return false;
//                 }
//                 if(ch==']'){
//                     if(!s.isEmpty() && s.peek()=='['){
//                         s.pop();
//                     }else
//                         return false;
//                 }
//                 if(ch=='}'){
//                     if(!s.isEmpty() && s.peek()=='{'){
//                         s.pop();
//                     }else
//                         return false;
//                 }
//             }
//         }
        
//         if(s.size()==0)
//             return true;
//         else 
//             return false;
            
            if(ch=='(')
                s.push(')');
            else if(ch=='[')
                s.push(']');
            else if(ch=='{')
                s.push('}');
            else if(s.isEmpty() || s.pop()!=ch)
                return false;
            
        }
        return s.isEmpty();
    }
}