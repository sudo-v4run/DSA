// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.removeConsecutiveCharacter(S);
            
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public String removeConsecutiveCharacter(String s){
        int n = s.length();
        String res="";
        for(int i = 0 ; i < n-1 ; i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                res+=s.charAt(i);
            }
        }
        res+=s.charAt(n-1);
        
        return res;
    }
}