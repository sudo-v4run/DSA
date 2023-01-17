//{ Driver Code Starts
import java.io.*;
import java.util.*;

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
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends

class Solution
{
    static ArrayList<Integer> res;
     
    Solution(){
        res = new ArrayList<>();
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	    if(node==null){
	        return res;
	    }
	    
	    res.add(node.data);
	    
	    if(node.left==null && node.right==null){
	        return res;
	    }
	    
	    leftB(node);
	    leafNodes(node);
	    rightB(node);
	    
	    return res;
	}
	public static void leftB(Node root){
	    Node cur = root.left;
	    
	    while(cur!=null){
	        
	        if(!isLeaf(cur)){
	            res.add(cur.data);
	        }
	        
	        if(cur.left!=null){
	            cur = cur.left;
	        }else{
	            cur = cur.right;
	        }
	    }
	}
	public static void leafNodes(Node root){
	    
	    if(root==null){
	        return;
	    }
	    
	    if(isLeaf(root)){
	        res.add(root.data);
	    }
	    
	    leafNodes(root.left);
	    leafNodes(root.right);
	}
	public static void rightB(Node root){
	    
	    Node cur = root.right;
	    Stack<Integer> s = new Stack<>();
	    
	    while(cur!=null){
	        
	        if(!isLeaf(cur)){
	            s.push(cur.data);
	        }
	            
            if(cur.right!=null){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
	    }
	    
	    while(!s.isEmpty()){
	        res.add(s.pop());
	    }
	}
	
	public static boolean isLeaf(Node node){
	    
	    if(node==null){
	        return false;
	    }
	    
	    if(node.left==null && node.right==null){
	        return true;
	    }
	    
	    return false;
	}
}
