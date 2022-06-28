// { Driver Code Starts
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


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<String>();
        String path = "";
        int vis[][] = new int[n][n];
        if(m[0][0]==0)
            return res;
        else solve(m,0,0,res,path,vis,n);
        return res;
    }
    public static void solve(int inp[][],int row,int col,ArrayList<String> res,String path,int vis[][],int n){
        if(row==n-1 && col==n-1){
            res.add(path);
        }
        
        //DLRU
        
        if(isSafe(inp,vis,row+1,col,n)){
            vis[row][col]=1;
            solve(inp,row+1,col,res,path+"D",vis,n);
            vis[row][col]=0;
        }
        if(isSafe(inp,vis,row,col-1,n)){
            vis[row][col]=1;
            solve(inp,row,col-1,res,path+"L",vis,n);
            vis[row][col]=0;
        }
        if(isSafe(inp,vis,row,col+1,n)){
            vis[row][col]=1;
            solve(inp,row,col+1,res,path+"R",vis,n);
            vis[row][col]=0;
        }
        if(isSafe(inp,vis,row-1,col,n)){
            vis[row][col]=1;
            solve(inp,row-1,col,res,path+"U",vis,n);
            vis[row][col]=0;
        }
        
    }
    public static boolean isSafe(int inp[][],int vis[][],int nr,int nc,int n){
        if((nr>=0 && nr<n) && (nc>=0 && nc<n) && inp[nr][nc]==1 && vis[nr][nc]!=1){
            return true;
        }
        
        else    return false;
    }
}