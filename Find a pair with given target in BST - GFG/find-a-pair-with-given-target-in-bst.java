//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // root : the root Node of the given BST
    // target : the target sum
    HashSet<Integer> hs = new HashSet<>();
    int ans = 0;
    // public int isPairPresent(Node root, int target)
    // {
    //     if(root==null){
    //         return 0;
    //     }
    //     isPairPresentUtil(root,target);
       
    //     return ans;
    // }
    // public void isPairPresentUtil(Node root, int target)
    // {
    //     if(root==null){
    //         return;
    //     }
    //     isPairPresent(root.left,target);
    //     if(!hs.contains(target-root.data)){
    //         hs.add(root.data);
    //     }else{
    //         ans = 1;
    //     }
    //     isPairPresent(root.right,target);
    // }
    Node head = null;
    public int isPairPresent(Node root, int target)
    {
        if(root==null){
            return 0;
        }
        if(head==null){
            head = root;
        }
        if(root.left!=null)
            isPairPresent(root.left,target);
            
        findComp(head,target-root.data);
            
        if(root.right!=null)
            isPairPresent(root.right,target);
        
        return ans;
    }
    public void findComp(Node root,int target){
        if(root==null){
            return;
        }
        if(root.data==target){
            ans = 1;
        }
        if(target>root.data){
            findComp(root.right,target);
        }
        
        if(target<root.data){
            findComp(root.left,target);
        }
    }
}
