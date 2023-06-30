//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    
    static int M;
    static ArrayList<ArrayList<Integer>> adj;
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        
        adj = new ArrayList<>();
        M = m;
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(graph[i][j] == true){
                    adj.get(i).add(j);
                }
            }
        }
        
        int color[] = new int[n];
        Arrays.fill(color,-1);
        
        return dfs(color);
    }
    public static boolean dfs(int color[]){
        
        for(int v = 0 ; v < color.length ; v++){
            if(color[v] != -1){
                continue;
            }
            for(int i = 1 ; i <= M ; i++){
                if(isPossible(v,i,color)){
                    color[v] = i;
                    if(dfs(color)){
                        return true;
                    }
                    color[v] = -1;
                }
            }
            return false;
        }
        
        return true;
    }
    public static boolean isPossible(int v, int i, int color[]){
        for(int nei : adj.get(v)){
            if(color[nei] == i){
                return false;
            }
        }
        
        return true;
    }
}