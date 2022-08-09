//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        Stack<Character> s = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(char c : exp.toCharArray()){
            if(c==')'){
                while(!(s.peek()=='(')){
                    ans.append(s.pop());
                }
                s.pop();
            }else if(c=='('){
                s.push(c);
            }else if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^'){
                while(!s.isEmpty() && precedence(s.peek())>=precedence(c)){
                    ans.append(s.pop());
                }
                s.push(c);
            }else{
                ans.append(c);
            }
        }
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        
        return ans.toString();
    }
    static int precedence(char ch){
        if(ch=='+'||ch=='-'){
            return 1;
        }else if(ch=='*'||ch=='/'){
            return 2;
        }else if(ch=='^'){
            return 3;
        }
        
        return -1;
    }
}