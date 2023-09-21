//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends

class Solution
{
    int celebrity(int M[][], int n)
    {
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            s.push(i);
        }
        
        while(s.size() > 1){
            int a = s.pop();
            int b = s.pop();
            
            if(M[a][b] == 1){
                s.push(b);
            }else{
                s.push(a);
            }
        }
        int candidate = s.peek();
        
        for(int i = 0 ; i < n ; i++){
            
            if(M[candidate][i] == 1){
                return -1;
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            
            if(i != candidate && M[i][candidate] == 0){
                return -1;
            }
        }
        
        return candidate;
    }
}