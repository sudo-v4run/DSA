//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        int vis[] = new int[26];
        ArrayList<Character> or = new ArrayList<>();
        String ans="";
        for(int i = 0 ; i < A.length();i++){
            char ch = A.charAt(i);
            if(vis[ch-'a']==0){
                or.add(ch);
            }
            vis[ch-'a']++;
            char ch2 = '#';
            for(int j = 0 ; j < or.size();j++){
                if(vis[or.get(j)-'a']==1){
                    ch2 = or.get(j);
                    break;
                }
            }
            ans+=ch2;
        }
        return ans;
    }
}