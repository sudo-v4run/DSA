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
            int f = 0;
            for(int j = 0 ; j < or.size();j++){
                char ch2 = or.get(j);
                if(vis[ch2-'a']==1){
                    ans+=ch2;
                    f = 1;
                    break;
                }
            }
            if(f==0){
                ans+='#';
            }
        }
        
        return ans;
    }
}