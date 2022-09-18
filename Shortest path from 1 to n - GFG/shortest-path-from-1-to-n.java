//{ Driver Code Starts
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
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minStep(n));
        }
    }
}
// } Driver Code Ends



class Solution{
    static int minStep(int n){
        int temp = n;
        int cnt = 0;
        while(temp>1){
            if(temp%3==0){
                cnt++;
                temp = temp/3;
            }else if(temp%3!=0){
                temp = temp-1;
                cnt++;
            }
        }
        
        return cnt;
    }
}
