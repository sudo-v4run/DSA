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
        
        for(int i = 0 ; i < Math.pow(2,n) ; i++){
            String ss = "";
            for(int j = 0 ; j < n ; j++){
                if((i&(1<<j))!=0){
                    ss+=s.charAt(j);
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