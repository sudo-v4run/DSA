//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends



class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        List<String> sl = new ArrayList<>();
        int n = s.length();
        
        for(int num = 0 ; num < Math.pow(2,n) ; num++){
            String ss = "";
            for(int i = 0 ; i < n ; i++){
                // here i refers to ith bit to check if ith bit is 1 or 0
                if((num&(1<<i))!=0){
                    ss+=s.charAt(i);
                }
            }
            
            if (ss.length() > 0) {
			    sl.add(ss);
		    }
        }
        Collections.sort(sl);
        return sl;
    }
}