//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution
{
    static class Pair{
        int node,wt;
        
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        
        // TC -> O(E*LogV)...
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return (a.wt-b.wt);});
        pq.add(new Pair(s,0));
        
        int dis[] = new int[v];
        Arrays.fill(dis,(int)1e7);
        dis[s] = 0;
        
        while(!pq.isEmpty()){
            Pair pop = pq.poll();
            int node = pop.node;
            int dist = pop.wt;
            
            for(ArrayList<Integer> nei : adj.get(node)){
                int adjNode = nei.get(0);
                int adjWt = nei.get(1);
                
                int adjDist = dist + adjWt;
                
                if(adjDist < dis[adjNode]){
                    dis[adjNode] = adjDist;
                    pq.add(new Pair(adjNode,adjDist));
                }
            }
        }
        
        return dis;
    }
}

