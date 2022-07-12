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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        
        if(arr.length==1){
            return arr[0];
        }
        
        String ans =  commonprefix(arr,0,arr.length-1);
        if(ans!=""){
            return ans;
        }
        
        return "-1";
        
    }
    String commonprefix(String arr[],int l ,int h){
        if(l==h){
            return arr[l];
        }
        if(l<h){
            int mid = (l+h)/2;
            String str1=commonprefix(arr,l,mid);
            String str2=commonprefix(arr,mid+1,h);
            
            return combine(str1,str2);
        }
        return  null;
    }
    String combine(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        String ans="";
        for(int i = 0 , j = 0 ; i < n1 && j < n2 ; i++,j++){
            if(s1.charAt(i)!=s2.charAt(j)){
                break;
            }
            ans+=s1.charAt(i);
            
        }
        
        return ans;
    }
}