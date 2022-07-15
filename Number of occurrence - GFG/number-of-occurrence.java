// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        int f = findfirst(arr,x,0,n-1);
        int l = findlast(arr,x,0,n-1);
        if(f!= -1){
            return l-f+1;
        }
        
        return 0;
    }
    static int findfirst(int arr[], int x , int l , int h){
        while(l<=h){
            int m = l+(h-l)/2;
            if(x==arr[m] && (m==0 || arr[m-1]!=x)){
                return m;
            }else if(x <= arr[m]){
                h = m-1;
            }else{
                l = m+1;
            }
        }
        
        return -1;
    }
    static int findlast(int arr[], int x , int l , int h){
        while(l<=h){
            int m = l+(h-l)/2;
            if(x==arr[m] && (m==arr.length-1 || arr[m+1]!=x)){
                return m;
            }else if(x >= arr[m]){
                l = m+1;
            }else{
                h = m-1;
            }
        }
        
        return -1;
    }
}