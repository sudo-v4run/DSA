// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        int l = 0 ;
        HashSet<Character> hs = new HashSet<>();
        int res = 0;
        
        for(int r = 0 ; r  < S.length(); r++){
            while(hs.contains(S.charAt(r))){
                hs.remove(S.charAt(l));
                l++;
            }
            hs.add(S.charAt(r));
            res = Math.max(res,hs.size());
        }
        return res;
    }
}