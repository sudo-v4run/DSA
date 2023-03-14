//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution {
    
    static class Pair{
        int node,wt;
        
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        int par[] = new int[n+1];
        par[1] = -1;
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            int w = ed[2];
            
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        int dis[] = new int[n+1];
        Arrays.fill(dis,(int)1e7);
        dis[1] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return a.wt-b.wt;});
        pq.add(new Pair(1,0));
        
        while(!pq.isEmpty()){
            
            Pair pop = pq.poll();
            int node = pop.node;
            int dist = pop.wt;
            
            if(node == n){
                
                List<Integer> res = new ArrayList<>();
                int sc = n;
                
                while(sc != -1){
                    res.add(sc);
                    sc = par[sc];
                }
                Collections.reverse(res);
                
                return res;
            }
            
            for(Pair ed : adj.get(node)){
                int v = ed.node;
                int wt = ed.wt;
                int adjDist = dist + wt;
                
                if(adjDist < dis[v]){
                    dis[v] = adjDist;
                    par[v] = node;
                    pq.add(new Pair(v,dist+wt));
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        res.add(-1);
        
        return res;
    }
}