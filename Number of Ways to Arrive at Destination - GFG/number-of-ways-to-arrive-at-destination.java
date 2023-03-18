//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends

class Solution {
    
    static class Pair{
        long node,wt;
        
        Pair(long node, long wt){
            this.node = node;
            this.wt = wt;
        }
    }

    static int countPaths(int n, List<List<Integer>> roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> ed : roads){
            int u = ed.get(0);
            int v = ed.get(1);
            int wt = ed.get(2);
            
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        
        long dis[] = new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0] = 0;
        
        long ways[] = new long[n];
        ways[0] = 1;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return (int)a.wt-(int)b.wt;});
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()){
            Pair pop = pq.poll();
            long node = pop.node;
            long wt = pop.wt;
            
            for(Pair nei : adj.get((int)node)){
                long adjNode = nei.node;
                long adjWt = nei.wt;
                
                long adjDist = (wt+adjWt);
                
                if(adjDist < dis[(int)adjNode]){
                    dis[(int)adjNode] = adjDist;
                    pq.add(new Pair(adjNode,adjDist));
                    ways[(int)adjNode] = ways[(int)node]%1000000007;
                }else if(adjDist == dis[(int)adjNode]){
                    ways[(int)adjNode] = (ways[(int)adjNode] + ways[(int)node])%1000000007;
                }
            }
        }
        
        return (int)ways[n-1];
    }
}
