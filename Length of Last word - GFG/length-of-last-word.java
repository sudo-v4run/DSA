// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            int ans = ob.findLength(s);
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int findLength(String s) 
    { 
        // code here
        int result=0;
        int n=s.length();
        while(n>0){
            if(s.charAt(--n)!=' '){
                result++;
            }
            else if(result>0){
                return result;
                }
        }
        return result;
    }
}