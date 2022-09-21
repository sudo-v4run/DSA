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
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends

class Solution
{
    static class Pair{
        int v,w;
        Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // kruskal ...
        
        TreeMap<Integer,ArrayList<Pair> > tm = new TreeMap<>();
        int par[] = new int[V];
        for(int i = 0 ; i < V ; i++){
            par[i] = i;
        }
        
        for(int i = 0 ; i < V ; i++){
            ArrayList<ArrayList<Integer>> nei = adj.get(i);
            for(ArrayList<Integer> a : nei){
                ArrayList<Pair> al = tm.get(a.get(1));
                if (al == null) {
                    al = new ArrayList<Pair>();
                    tm.put(a.get(1), al);
                }
                al.add(new Pair(i,a.get(0)));
            }
        }
        
        int ans = 0;
      
        
        for (Map.Entry<Integer,ArrayList<Pair>>entry : tm.entrySet()){
            ArrayList<Pair> list = entry.getValue();
            for(Pair pr : list){
                Pair e = pr;
                if(find(par,e.v)!=find(par,e.w)){
                    ans+=entry.getKey();
                    unionSet(par,e.v,e.w);
                }
            }
            
        }
        
        return ans;
        
        
        
        
        // Prims ...
        
        // int key[] = new int[V];
        // boolean mst[] = new boolean[V];
        // //int parent[] = new int[V];
        // int ans = 0;
        
        // for(int i = 0 ; i < V ;i++){
        //     key[i] = 10000000;
        //     mst[i] = false;
        //     //parent[i] = -1;
        // }
        // key[0] = 0;
        
        // PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->{return a.w-b.w;});
        
        // q.offer(new Pair(0,key[0]));
        
        // while(!q.isEmpty()){
        //     Pair cur = q.poll();
            
        //     mst[cur.v] = true;
            
        //     ArrayList<ArrayList<Integer>> nei = adj.get(cur.v);
            
        //     for(ArrayList<Integer> a : nei){
        //         int vr = a.get(0);
        //         int wt = a.get(1);
                
        //         if(mst[vr]==false && key[vr]>wt){
        //             key[vr]=wt;
        //           // parent[vr]=cur.v;
        //             q.offer(new Pair(vr,key[vr]));
        //         }
        //     }
        // }
        // for(int i=0; i < V ; i++){
        //     ans+=key[i];
        // }
        // return ans;
    }
    
    
    static int find(int parent[],int x)
    {
          if(parent[x]!=x){
              parent[x] = find(parent,parent[x]);
          }
          
          return parent[x];
	}
	static void unionSet(int parent[],int x,int z)
    {
         int parX = find(parent,x);
         int parZ = find(parent,z);
         
         if(parX==parZ){
             return;
         }
         
         parent[parX] = parZ;
	}
}