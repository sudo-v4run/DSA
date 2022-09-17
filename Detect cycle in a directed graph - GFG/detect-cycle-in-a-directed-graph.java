//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        //............BFS-Kahns Algo............
        
        int cnt = 0 ; 
        int indeg[] = new int [V];
        Queue<Integer> q = new LinkedList<>();
        
        findIG(adj,indeg);
        
        for(int i = 0 ; i < V ; i++){
            if(indeg[i]==0){
                q.offer(i);
                cnt++;
            }
        }
        
        while(!q.isEmpty()){
            int pop = q.poll();
            
            for(int nei : adj.get(pop)){
                indeg[nei]--;
                if(indeg[nei]==0){
                    q.offer(nei);
                    cnt++;
                }
            }
        }
        
        if(cnt<V){
            return true;
        }
        
        return false;
     
        
        //.............DFS...........................
        
        // Stack<Integer> st = new Stack<>();
        // int vis[] = new int [V];
        // int pathVis[] = new int[V];
        
        // for(int i =  0 ; i < V ; i++){
        //     if(vis[i]!=1){
        //         if(dfs(i,vis,adj,cnt,pathVis))
        //             return true;
        //     }
        // }
        
        // return false;
      
        
        
    }
    
    // static boolean dfs(int s , int vis[],ArrayList<ArrayList<Integer>> adj,int cnt,int pathVis[] ){
    //     vis[s] = 1;
    //     pathVis[s] = 1;
    //     for(int nei : adj.get(s) ){
    //         if(vis[nei]!=1){
    //             if(dfs(nei,vis,adj,cnt,pathVis)){
    //                 return true;
    //             }
    //         }else{
    //             if(pathVis[nei]==1){
    //                 return true;
    //             }
    //         }
    //     }
    //     pathVis[s] = 0;
    //     return false;
        
    // }
    
    static void findIG(ArrayList<ArrayList<Integer>> adj , int indeg[]){
        for(int i = 0 ; i < adj.size() ; i++){
            for(int j : adj.get(i)){
                indeg[j]++;
            }
        }
    }
}