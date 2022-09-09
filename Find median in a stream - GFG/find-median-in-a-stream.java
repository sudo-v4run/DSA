//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    static Queue<Integer> minH = new PriorityQueue<>();
    static Queue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
    static boolean isEven = true;
    
    
    
    // public static void insertHeap(int x)
    // {
    //     if(isEven){
    //         minH.offer(x);
    //         maxH.offer(minH.poll());
    //     }else{
    //         maxH.offer(x);
    //         minH.offer(maxH.poll());
    //     }
    //     isEven = !isEven;
        
    //     balanceHeaps();
    // }
    
    
    // public static void balanceHeaps()
    // {
    //     return;
    // }
    
    
    
    
    
    public static void insertHeap(int x)
    {
        if(maxH.size()==0 || x < maxH.peek()){
            maxH.offer(x);
        }else{
            minH.offer(x);
        }
        
        balanceHeaps();
    }
    
    
    public static void balanceHeaps()
    {
        if(maxH.size()>minH.size()+1){
            minH.offer(maxH.poll());
        }else if(maxH.size()<minH.size()){
            maxH.offer(minH.poll());
        }
    }
    
    
    
    
   
    public static double getMedian()
    {
        if(maxH.size() == minH.size())
            return (minH.peek() + maxH.peek()) / 2.0;
        else {
            if(maxH.size() > minH.size())
                return (double) maxH.peek();
            else return (double) minH.peek();
        }
    }
    
}