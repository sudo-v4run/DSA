// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        ArrayList<Long> res = new ArrayList<>();
        int f = findfirst(arr,x,0,n-1);
        int l = findlast(arr,x,0,n-1);
        res.add((long)f);
        res.add((long)l);
        
        return res;
    }
    static int findfirst(long arr[],int x,int l,int h){
        while(l<=h){
            int mid = l+(h-l)/2;
            if(x==arr[mid] && (mid==0 || arr[mid-1]!=x)){
               return mid;
            }else if(x<=arr[mid]){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        return -1;
    }
    static int findlast(long arr[],int x,int l,int h){
        while(l<=h){
            int mid = l+(h-l)/2;
            if(x==arr[mid] && (mid==arr.length-1 || arr[mid+1]!=x)){
                return mid;
            }else if(x>=arr[mid]){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        
        return -1;
    }
}



// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}
  // } Driver Code Ends