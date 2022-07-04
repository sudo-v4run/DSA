// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        char ch[] = S.toCharArray();
        int i = 0 ;
        int j = 0;
        
        for( ;j<ch.length;j++){
            if(ch[j]=='.'){
                reverseChars(ch,i,j-1);
                
                i = j+1;
                
            }
            else if(j==ch.length-1){
                reverseChars(ch,i,j);
            }
        }
        
        reverseChars(ch,0,ch.length-1);
        
        return new String(ch);
    }
    public void reverseChars(char[] arr,int i , int j){
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        }
    }
}