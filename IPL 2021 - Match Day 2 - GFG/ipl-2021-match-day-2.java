//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // ArrayList<Integer> res = new ArrayList<>();
        // ArrayDeque<Integer> q = new ArrayDeque<>();
        // int i = 0 ;
        // for(; i < k ; i++){
        //     while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]){
        //         q.removeLast();
        //     }
        //     q.addLast(i);
        //     res.add(arr[q.peekFirst()]);
        // }
        // for(; i<n ; i++){
        //     if(!q.isEmpty() && q.peek()==i-k){
        //         q.removeFirst();
        //     }
        //     while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]){
        //         q.removeLast();
        //     }
        //     q.addLast(i);
        //     res.add(arr[q.peekFirst()]);
        // }
        
        // return res;
        ArrayList<Integer> res2 = new ArrayList<>();
        int res[] = new int[arr.length-k+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int j = 0 ;
        int i = 0;
        for(;i<k;i++){
            while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]){
                q.removeLast();
            }
            q.addLast(i);
            res[j] = arr[q.peek()];
        }
        for(;i<arr.length;i++){
          
            if(!q.isEmpty() && q.peek()==i-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]){
                q.removeLast();
            }
            q.addLast(i);
            res[++j] = arr[q.peek()];
        }
        
        for(int l = 0 ; l < res.length ; l++){
            res2.add(res[l]);
        }
        
        return res2;
    }
}