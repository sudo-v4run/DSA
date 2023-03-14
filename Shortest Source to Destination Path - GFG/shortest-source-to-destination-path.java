//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends

class Solution {
    static class Pair{
        int r,c;
        
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    int shortestDistance(int N, int M, int arr[][], int X, int Y) {
        
        int m = arr.length;
        int n = arr[0].length;
        
        if(arr[0][0] == 0){
            return -1;
        }
        
        int dis[][] = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        
        int vis[][] = new int[m][n];
        vis[0][0] = 1;
        
        int steps = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            
            for(int i = 0 ; i < sz ; i++){
                Pair pop = q.poll();
                int r = pop.r;
                int c = pop.c;
                
                if(r == X && c == Y){
                    return steps;
                }
                
                for(int d[] : dis){
                    int nr = r+d[0];
                    int nc = c+d[1];
                    
                    if( nr < 0 || nr >= m || nc < 0 || nc >= n || 
                        vis[nr][nc] == 1 || arr[nr][nc] == 0 ){
                            
                            continue;
                    }
                    
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr,nc));
                }
            }
            steps++;
        }
        
        return -1;
    }
};