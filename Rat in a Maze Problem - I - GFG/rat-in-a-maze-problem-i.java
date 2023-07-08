//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends

class Solution {
    
    static ArrayList<String> res;
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        
        res = new ArrayList<>();
        
        f(0,0,"",m);
        
        return res;
    }
    public static void f(int r, int c, String ans, int arr[][]){
        
        int n = arr.length;
        
        if(r < 0 || r >= n || c < 0 || c >= n){
            return;
        }
        
        if(arr[r][c] == 0 || arr[r][c] == -1){
            return;
        }
        if(r == n-1 && c == n-1){
            res.add(ans);
            return;
        }
        
        int temp = arr[r][c];
        arr[r][c] = -1;
        
        f(r-1,c,ans+"U",arr);
        f(r,c-1,ans+"L",arr);
        f(r+1,c,ans+"D",arr);
        f(r,c+1,ans+"R",arr);
        
        arr[r][c] = temp;
    }
}