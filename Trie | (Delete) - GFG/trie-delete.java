//{ Driver Code Starts
import java.util.*;
 
class TrieNode 
{
    char content; 
    boolean isEnd; 
    int count;  
    LinkedList<TrieNode> childList; 
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }  
    public TrieNode subNode(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}
public class TrieTest
{   private static TrieNode root;
    TrieTest(){
        root = new TrieNode(' '); 
		}
    public static void main(String[] args)
    {   Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		TrieTest z=new TrieTest(); 
		Solution g = new Solution();
		int n=sc.nextInt();
		ArrayList<String> keys=new ArrayList<String>();
		for(int i=0;i<n;i++){
			keys.add(sc.next());}
		for(int i = 0; i < keys.size(); i++)
		{
			insert(keys.get(i));
		}
		String abc=sc.next();
		g.deleteKey(root,abc.toCharArray());
		if(ifExsist(abc)==false)
		    System.out.println("1");
		else
			System.out.println("0");
		}
	}		
	public static boolean ifExsist(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd == true) 
            return true;
        return false;
    }
	public static void insert(String word)
    {
        if (ifExsist(word) == true) 
            return;        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }
}
// } Driver Code Ends

class Solution
{
    public static void deleteKey(TrieNode root,char[] key)
    {
        // TrieNode cur = root;
        // for(char ch : key){
        //     if(cur.subNode(ch) != null){
        //         cur = cur.subNode(ch);
        //     }
        // }
        // cur.isEnd = false;
        
        int len = key.length;
        remove(root.subNode(key[0]),key,0,len-1);
    }
    
    
    public static void remove(TrieNode root,char[] key , int level , int len){
        TrieNode cur = root;
        if(level==len){
            if(cur.isEnd==true){
                cur.isEnd= false;
            }
            if(isFreeNode(cur)){
                cur = null;
            }
            return;
        }
        remove(cur.subNode(key[level+1]),key,level+1,len);
    }
    public static boolean isFreeNode(TrieNode root){
        return root.childList.size()>=1?false:true;
    }
    
    
    // public static void deleteKey(TrieNode root,char[] key)
    // {
    //     int len = key.length;
    //     remove(root,key,0,len);
    // }
    // public static void remove(TrieNode root,char[] key , int level , int len){
    //     TrieNode cur = root;
    //     if(level==len){
    //         if(cur.isEnd==true){
    //             cur.isEnd= false;
    //         }
    //         if(isFreeNode(cur)){
    //             cur = null;
    //         }
    //         return;
    //     }
    //     remove(cur.subNode(key[level]),key,level+1,len);
    // }
    // public static boolean isFreeNode(TrieNode root){
    //     return root.childList.size()>=1?false:true;
    // }
}