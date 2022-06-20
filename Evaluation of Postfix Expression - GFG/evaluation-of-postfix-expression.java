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
            int ch = c-'0';
            int ch1 ,ch2;
            
            if(c=='+'){
                ch1 = s.pop();
                ch2 = s.pop();
                s.push(ch2+ch1);
            }
            else if(c=='/'){
                ch1 = s.pop();
                ch2 = s.pop();
                s.push(ch2 / ch1);
            }
            else if(c=='*'){
                ch1 = s.pop();
                ch2 = s.pop();
                s.push(ch2 * ch1);
            }
            else if(c=='-'){
                ch1 = s.pop();
                ch2 = s.pop();
                s.push(ch2 - ch1);
            }
            else if(Character.isDigit(c)){
                s.push(c-'0');
            }
        }
        
        return s.peek();
    }
}