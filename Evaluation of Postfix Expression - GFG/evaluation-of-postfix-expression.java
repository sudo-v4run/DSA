// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> s = new Stack<>();
        
        for(char c : S.toCharArray()){
            if(Character.isDigit(c)){
                s.push(c-'0');
            }else{
                int op1 = s.pop();
                int op2 = s.pop();
                switch(c){
                    case '+':
                        s.push(op2+op1);
                        break;
                    case '-':
                        s.push(op2-op1);
                        break;
                    case '*':
                        s.push(op2*op1);
                        break;
                    case '/':
                        s.push(op2/op1);
                        break;
                }
            }
        }
        
        return s.peek();
    }
}