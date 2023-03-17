//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    static class Pair{
        int num,muls;
        
        Pair(int num, int muls){
            this.num = num;
            this.muls = muls;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        
        int mod = 100000;
        int dist[] = new int[mod];
        Arrays.fill(dist,(int)1e7);
        dist[start] = 0;
        
        while(!q.isEmpty()){
            Pair pop = q.poll();
            int num = pop.num;
            int muls = pop.muls;
            
            if(num == end){
                return muls;
            }
            
            for(int ele : arr){
                int newNum = (num*ele)%mod;
                int newMuls = muls+1;
                
                if(newMuls < dist[newNum]){
                    dist[newNum] = newMuls;
                    q.add(new Pair(newNum,newMuls));
                }
            }
        }
        
        return -1;
    }
}
