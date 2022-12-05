//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


class Solution {
    public boolean isPossible(int numCourses, int[][] preReq)
    {
        // List<List<Integer>> adj = new ArrayList<List<Integer>>();
        
        // Using List of List is giving TLE .. 
        
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        
        for(int i = 0 ; i < numCourses ; i++){
            adj.put(i,new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < preReq.length ; i++){
            adj.get(preReq[i][0]).add(preReq[i][1]);
        }
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0 ; i < numCourses ; i++){
            if(!dfs(i,adj,hs)){
                return false;
            }
        }
        
        return true;
        
    }
    public static boolean dfs(int node, HashMap<Integer,ArrayList<Integer>> adj ,
                            HashSet<Integer> hs){
        
        if(hs.contains(node)){
            return false;
        }
        
        hs.add(node);
        
        for(int nei : adj.get(node)){
            if(!dfs(nei,adj,hs)){
                return false;
            }
        }
        
        adj.put(node,new ArrayList<>());
        
        hs.remove(node);
        
        return true;
    }
}