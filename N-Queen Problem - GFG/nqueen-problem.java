// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int arr[][] = new int[n][n];
        nQueenS(arr,0,res,n);
        return res;
    }
    
    public static boolean nQueenS(int arr[][],int row,ArrayList<ArrayList<Integer>>res,int n){
        if(row==n){
            safeList(arr,res);
        }
        for(int col = 0 ; col < n ; col++){
            if(isSafe(arr,row,col,n)){
                arr[row][col]=1;
                if(nQueenS(arr,row+1,res,n)){
                    return true;
                }
                arr[row][col] = 0;
            }
        }
        
        return false;
    }
    
    public static boolean isSafe(int a[][],int row,int col,int n){
		for(int i = 0; i < n; i++) {
			if(a[i][col] == 1) return false;
		}
		
		for(int i = row, j = col; i>=0 && j >=0; i--, j--) {
			if(a[i][j] == 1) return false;
		}
		
		for(int i = row, j = col; i>=0 && j < n; i--, j++) {
			if(a[i][j] == 1) return false;
		}
		
		return true;
    }
    
    public static void safeList(int arr[][],ArrayList<ArrayList<Integer>> res){
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length ; j++){
                if(arr[i][j]==1){
                    ans.add(j+1);
                }
            }
        }
        
        res.add(ans);
        return;
    }
}