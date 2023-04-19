//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    static String minWindow(String s, String t) {
        
        String ans = "";
        int j = 0;
        int n = s.length();
        int end = -1;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == t.charAt(j)){
                j++;
                if(j == t.length()){
                    end = i+1;
                    j--;
                    while(j >= 0){
                        if(s.charAt(i) == t.charAt(j)){
                            j--;
                        }
                        i--;
                    }
                    i++;
                    j++;
                    
                    if(end - i < min){  // (end-1) - i + 1
                        min = end - i;
                        ans = s.substring(i,end);
                    }
                }
                
            }
        }
        
        return ans;
    }
}