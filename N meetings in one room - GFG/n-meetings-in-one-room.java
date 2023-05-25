//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution 
{
    static class Tuple{
        int s, e, i;
        Tuple(int s, int e , int i){
            this.s = s;
            this.e = e;
            this.i = i;
        }
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        Tuple arr[] = new Tuple[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = new Tuple(start[i],end[i],i);
        }
        Arrays.sort(arr,(a,b)->{return a.e-b.e;});
        
        int prevEnd = -1;
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(start[arr[i].i] > prevEnd){
                cnt++;
                prevEnd = arr[i].e;
            }
        }
        
        return cnt;
    }
}
