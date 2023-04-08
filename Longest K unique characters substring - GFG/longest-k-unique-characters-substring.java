//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends

class Solution {
    public int longestkSubstr(String s, int k) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        int i = 0, j = 0;
        int n = s.length();
        int max = -1;
        
        while(j < n){
            char ch = s.charAt(j);
            
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            if(hm.size() < k){
                j++;
            }else if(hm.size() == k){
                max = Math.max(max,j-i+1);
                j++;
            }else if(hm.size() > k){
                while(hm.size() > k){
                    char temp = s.charAt(i);
                    
                    hm.put(temp,hm.get(temp)-1);
                    if(hm.get(temp) == 0){
                        hm.remove(temp);
                    }
                    i++;
                }
                j++;
            }
        }
        
        return max;
    }
}