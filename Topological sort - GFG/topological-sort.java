//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Using DFS...
    
    // static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    // {
        
    //     int vis[] = new int[V];
    //     Stack<Integer> st = new Stack<>();
        
        
    //     for(int i = 0 ; i < V ; i++){
    //         if(vis[i]!=1){
    //             dfs(0,vis,adj,st);
    //         }
    //     }
        
    //     int res[] = new int[V];
    //     int k = 0;
        
    //     while(!st.isEmpty()){
    //         res[k++] = st.pop();
    //     }
        
    //     return res;
        
    // }
    // static void dfs(int s,int vis[] ,ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
    //     vis[s] = 1;
        
    //     for(int nei : adj.get(s)){
    //         if(vis[nei]!=1){
    //             dfs(nei,vis,adj,st);
    //         }
    //     }
    //     st.push(s);
    // }
    
    
    
    // Using Kahn's Algorithm - BFS....
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        int vis[] = new int[V];
        int indeg[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        int res[] = new int[V];
        int k = 0;
        
        findIG(adj,indeg);
        
        for(int i = 0 ; i < V ; i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int pop = q.poll();
            res[k++] = pop;
            
            for(int nei : adj.get(pop)){
                indeg[nei]--;
                if(indeg[nei]==0){
                    q.offer(nei);
                }
            }
        }
        
        return res;
        
    }
    static void findIG(ArrayList<ArrayList<Integer>> adj, int indeg[]){
        for(int i = 0 ; i < adj.size() ; i++){
            for(int j : adj.get(i) ){
                indeg[j]++;
            }
        }
    }
}
