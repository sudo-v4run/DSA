//{ Driver Code Starts
//Initial Template for Java

import java.io.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        
        //using BufferedReader to take input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //taking total testcases
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            
            //taking total number of elements
            int n = Integer.parseInt(br.readLine());
            
            int par[] = new int[n+1];
            int rank[] = new int[n+1];
            
            //initializing the parent and
            //the rank array
            for(int i = 1; i<=n; ++i){
                par[i] = i;
                rank[i] = 1;
            }
            int a = 0, b = 0;
            char c = '0';
            
            //taking number of queries
            int query = Integer.parseInt(br.readLine());
            
            Boolean output = false;
            while(query-- >0){
                String str[] = br.readLine().trim().split(" ");
                c = str[0].charAt(0);
                a = Integer.parseInt(str[1]);
                b = Integer.parseInt(str[2]);

                //if query type is 'U'
                //then calling union_ method
                if(c == 'U'){
                    new Solution().union_(a, b, par, rank);
                }
                else{//else calling isConnected() method
                    output = new Solution().isConnected(a, b, par, rank);
                    if(output == true)
                        System.out.println("1");
                    else
                        System.out.println("0");
                }
            }



        }
    }
}
// } Driver Code Ends

class Solution
{
    public static int findParent(int u,int parent[]){
        if(parent[u] == u){
            return u;
        }
        
        return parent[u] = findParent(parent[u],parent);
    }
    public void union_(int a, int b, int parent[], int rank[])
    {
        int parent_a = findParent(a,parent);
        int parent_b = findParent(b,parent);
        
        if(parent_a == parent_b){
            return;
        }
        
        // find by rank....
        
        int rank_parent_a = rank[a];
        int rank_parent_b = rank[b];
        
        if(rank_parent_a < rank_parent_b){
            parent[parent_a] = parent_b;
        }else if(rank_parent_a > rank_parent_b){
            parent[parent_b] = parent_a;
        }else{
            parent[parent_b] = parent_a;
            rank[parent_b]++;
        }
        
        // find by size...
        
        // int size_parent_a = size[a];
        // int size_parent_b = size[b];
        
        // if(size_parent_a < size_parent_b){
        //     parent[parent_a] = parent_b;
        //     size[parent_b] += size[parent_a];
        // }else{
        //     parent[parent_b] = parent_a;
        //     size[parent_a] += size[parent_b];
        // }
    }
    public Boolean isConnected(int a, int b, int parent[], int rank[])
    {
        int parent_a = findParent(a,parent);
        int parent_b = findParent(b,parent);
        
        if(parent_a == parent_b){
            return true;
        }
        return false;
    }
}