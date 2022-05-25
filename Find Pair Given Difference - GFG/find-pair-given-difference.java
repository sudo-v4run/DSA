// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        int i = 0 ;
        int j =1 ;
        while(i<size && j<size){
            if(i!=j && arr[j]-arr[i] == n){
                return true;
            }else if(arr[j]-arr[i]>n){
                i++;
            }else{
                j++;
            }
        }
        
        return false;
        
        
        // HashMap<Integer,Integer> hm = new HashMap<>();
        
        // for(int i = 0 ; i < size ; i++){
        //     hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        // }
        
        // for(int i = 0 ; i < size ; i++ ){
        //     int ans = arr[i]+n;
            
        //     if(n==0 && hm.get(arr[i])>1){
        //         return true;
        //     }
           
        //     else if(n>0 && hm.containsKey(ans)){
        //         return true;
        //     }
        // }
        
        // return false;
    }
}