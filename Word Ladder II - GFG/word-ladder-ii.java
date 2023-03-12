//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String st, String end, String[] wordList)
    {
        HashSet<String> hs = new HashSet<>();
        
        for(String s : wordList){
            hs.add(s);
        }
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> lvl = new ArrayList<>();
        lvl.add(st);
        q.add(new ArrayList<>(lvl));
        HashSet<String> toDel = new HashSet<>();
        toDel.add(st);
        
        while(!q.isEmpty()){
            int sz = q.size();
            
            for(int l = 0 ; l < sz ; l++){
                ArrayList<String> temp = q.poll();
                String word = temp.get(temp.size()-1);
                
                if(word.equals(end)){
                    
                    if(ans.size()==0){
                        ans.add(temp);
                    }else if(ans.get(0).size() == temp.size()){
                        ans.add(temp);
                    }
                    continue;
                }
                
                for(int i = 0 ; i < word.length() ; i++){
                    char tempArr[] = word.toCharArray();
                    for(char ch = 'a' ; ch <= 'z' ; ch++){
                        tempArr[i] = ch;
                        String tempS = new String(tempArr);
                        
                        if(hs.contains(tempS)){
                            toDel.add(tempS);
                            temp.add(tempS);
                            q.add(new ArrayList<>(temp));
                            temp.remove(tempS);
                        }
                    }
                }
            }
            
            for(String str : toDel){
                hs.remove(str);
            }
            toDel = new HashSet();
        }
        
        return ans;
    }
}