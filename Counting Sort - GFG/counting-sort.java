// { Driver Code Starts
import java.util.*;
import java.lang.*;

class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.countSort(arr));
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr)
    {
        int count[] = new int[26];
        char input[] = arr.toCharArray();
        char output[] = new char[input.length];
        
        for(int i = 0 ; i < input.length ; i++){
            count[input[i]-'a']++;
        }
        for(int i = 1 ; i < count.length ; i++){
            count[i]+=count[i-1];
        }
        
        for(int i = input.length-1 ; i>=0 ; i--){
            output[--count[input[i]-'a']] = input[i];
        }
        
        for(int i = 0 ; i < input.length;i++){
            input[i] = output[i];
        }
        return new String(input);
    }
}