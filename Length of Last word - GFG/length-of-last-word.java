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
        s=s.trim();
        int res = 0;
        int n=s.length()-1;
        while(n>=0 && s.charAt(n)!=' '){
            res++;
            n--;
        }
        return res;
    }
}