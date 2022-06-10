// { Driver Code Starts
/* package whatever; // don't place package name! */
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}

class Remove_Duplicate_From_LL
{
    Node head;  
    Node temp;
	public void addToTheLast(Node node) 
	{

	  if (head == null) 
	  {
	    head = node;
	    temp = node;
	  }
	  else{
	      temp.next = node;
	      temp = node;
	  }
	}

      void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	/* Drier program to test above functions */
	public static void main(String args[])
    {
       
        
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		  
		 while(t>0)
         {
			int n = sc.nextInt();
			Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL();
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
		//llist.printList();	
        Solution g = new Solution();
		llist.head = g.removeDuplicates(llist.head);
		llist.printList();
		
        t--;		
        }
    }
}
// } Driver Code Ends


/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/
class Solution
{
    //Function to remove duplicates from unsorted linked list.
	public Node removeDuplicates(Node head)  
    { 
        //using set to store already seen values in list. 
        HashSet<Integer> hs = new HashSet<>(); 
      
        //using two pointers one of which stores first node other null.
        Node current = head; 
        Node prev = null; 
        
        //traversing over the linked list.
        while (current != null)  
        { 
            int curval = current.data; 
              
            //if data at current node is already present in set, we skip the 
            //current node and store the node next to current in link of prev. 
            if (hs.contains(curval)) { 
                prev.next = current.next;
                //deleting current node which contains duplicates. 
                current=null;
            }
            //else we just insert the data at current node in set and update 
            //prev to the current node.
            else { 
                hs.add(curval); 
                prev = current; 
            }
            //updating current to the next node of prev.
             current = prev.next; 
        } 
        return head;
    } 
}