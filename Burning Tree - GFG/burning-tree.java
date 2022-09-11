//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        HashMap<Node,Node> hm = new HashMap<>();
        Node tar = createParents(root,hm,target);
        int t = burnTree(tar,hm);
        
        return t;
    }
    public static Node createParents(Node root,HashMap<Node,Node> hm,int target){
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        hm.put(root,null);
        
        Node res = null;
        
        while(!q.isEmpty()){
            Node pop = q.poll();
            
            if(pop.data==target){
                res = pop;
            }
            
            if(pop.left!=null){
                q.offer(pop.left);
                hm.put(pop.left,pop);
            }
            
            if(pop.right!=null){
                q.offer(pop.right);
                hm.put(pop.right,pop);
            }
        }
        
        return res;
    }
    
    public static int burnTree(Node root,HashMap<Node,Node> hm){
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Boolean> vis = new HashMap<>();
        
        q.offer(root);
        vis.put(root,true);
        int t = 0;
        
        while(!q.isEmpty()){
            int flg = 0;
            int sz = q.size();
            for(int i = 0 ; i < sz ; i++){
                
                Node pop = q.poll();
                
                if(pop.left!=null && vis.get(pop.left)==null){
                    q.offer(pop.left);
                    vis.put(pop.left,true);
                    flg = 1;
                }
                if(pop.right!=null && vis.get(pop.right)==null){
                    q.offer(pop.right);
                    vis.put(pop.right,true);
                    flg = 1;
                }
                if(hm.get(pop)!=null && vis.get(hm.get(pop))==null){
                    q.offer(hm.get(pop));
                    vis.put(hm.get(pop),true);
                    flg = 1;
                }
            }
            
            if(flg==1){
                t++;
            }
        }
        
        return t;
    }
}