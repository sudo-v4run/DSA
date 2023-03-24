//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends

class DisjointSet{
    int parent[],rank[];
    DisjointSet(int n){
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        rank = new int[n];
        Arrays.fill(rank,1);
    }
    int findParent(int u){
        if(parent[u] == u){
            return u;
        }
        
        return parent[u] = findParent(parent[u]);
    }
    void union(int a, int b){
        int parent_a = findParent(a);
        int parent_b = findParent(b);
        
        if(parent_a == parent_b){
            return;
        }
        
        int rank_parent_a = rank[parent_a];
        int rank_parent_b = rank[parent_b];
        
        if(rank_parent_a < rank_parent_b){
            parent[parent_a] = parent_b;
        }else if(rank_parent_a > rank_parent_b){
            parent[parent_b] = parent_a;
        }else{
            parent[parent_b] = parent_a;
            rank[parent_a]++;
        }
    }
}

class Solution {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        
        int m = rows;
        int n = cols;
        
        DisjointSet ds = new DisjointSet(m*n);
        List<Integer> res = new ArrayList<>();
        int dir[][] = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int vis[][] = new int[m][n];
        int cnt = 0;
        
        for(int cords[] : operators){
            int r = cords[0];
            int c = cords[1];
            
            if(vis[r][c] == 1){
                res.add(cnt);
                continue;
            }
            
            vis[r][c] = 1;
            cnt++;
            
            for(int d[] : dir){
                int newR = r+d[0];
                int newC = c+d[1];
                
                if(newR < 0 || newR >= m || newC < 0 || newC >= n || vis[newR][newC] != 1){
                    continue;
                }
                
                int u = cellNum(r,c,n);         // consider every cell as a number(node)
                int v = cellNum(newR,newC,n);
                
                if(ds.findParent(u) != ds.findParent(v)){
                    cnt--;
                    ds.union(u,v);
                }
                
            }
            res.add(cnt);
        }
        
        return res;
    }
    public static int cellNum(int row, int col, int n){
        return row*n+col;
    }
}




//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends