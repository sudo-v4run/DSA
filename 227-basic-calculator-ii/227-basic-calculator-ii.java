class Solution {
    public int calculate(String s) {
        
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        
        for(int i = 0 ; i < n ; i++){
            
            if(Character.isDigit(s.charAt(i))){
                String temp = "";
                
                while( i<n && Character.isDigit(s.charAt(i))){
                    temp+=s.charAt(i);
                    i++;
                }
                
                i--;  // this will increment in for loop...
                
                int value = Integer.parseInt(temp);
                
                if(sign=='+'){
                    st.push(value);
                }else if(sign=='-'){
                    st.push(-value);
                }else if(sign == '*'){
                    int top = st.pop();
                    st.push(top*value);
                }else if(sign == '/'){
                    int top = st.pop();
                    st.push(top/value);
                }
                
            }else if(s.charAt(i) != ' '){
                sign = s.charAt(i);
            }
        }
        
        int res = 0;
        
        while(!st.isEmpty()){
            res += st.pop();
        }
        
        return res;
    }
    
    
    
    
    
    
//     public int calculate(String S) {
//         String s="";
//         for(char ch : S.toCharArray()){
//             if(ch!=' '){
//                 s+=ch;
//             }
//         }
//         return infixToPostfix(s);
//     }
//     public static int infixToPostfix(String s){
//         Stack<Character> st1 = new Stack<>();
//         Stack<Integer> st2 = new Stack<>();
        
//         for(int i = 0 ; i < s.length() ; i++){
//             String temp = "";
//             while(i<s.length() && (s.charAt(i) != '+' && s.charAt(i) !='-' 
//                   && s.charAt(i) != '*' && s.charAt(i) != '/') ){
//                 temp+=s.charAt(i);
//                 i++;
//             }
             
//             st2.push(Integer.parseInt(temp));
//             if(i<s.length()){
//                 char op = s.charAt(i);
            
//                 while(!st1.isEmpty() && precedence(st1.peek())>=precedence(op)){
//                     char oper = st1.pop();
                    
//                     int op1 = st2.pop();
//                     int op2 = st2.pop();
                    
//                     if(oper=='+'){
//                         st2.push(op2+op1);
//                     }else if(oper=='-'){
//                         st2.push(op2-op1);
//                     }else if(oper=='*'){
//                         st2.push(op2*op1);
//                     }else if(oper=='/'){
//                         st2.push(op2/op1);
//                     }
//                 }

//                 st1.push(op);
//             }

//         }
//         while(!st1.isEmpty()){
//             char oper = st1.pop();

//             int op1 = st2.pop();
//             int op2 = st2.pop();

//             if(oper=='+'){
//                 st2.push(op2+op1);
//             }else if(oper=='-'){
//                 st2.push(op2-op1);
//             }else if(oper=='*'){
//                 st2.push(op2*op1);
//             }else if(oper=='/'){
//                 st2.push(op2/op1);
//             }
//         }
        
//         return st2.peek();
        
//     }
//     public static int precedence(char ch){
//         if(ch=='+' || ch=='-'){
//             return 1;
//         }else if(ch=='*' || ch=='/'){
//             return 2;
//         }
        
//         return -1;
//     }
    
}