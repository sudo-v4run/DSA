//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
    int min = Integer.MAX_VALUE;
	public void push(int a,Stack<Integer> s)
	{
	    min = Math.min(a,min);
	    s.push(a);
	}
	public int pop(Stack<Integer> s)
    {
        if(s.isEmpty()){
            return -1;
        }
        int ans = s.pop();
        
        return ans;
	}
	public int min(Stack<Integer> s)
    {
        int ans = -1;
        if(s.isEmpty()){
            return -1;
        }
        return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
    {
        if(s.size()==n){
            return true;
        }
        return false;
	}
	public boolean isEmpty(Stack<Integer>s)
    {
        return s.isEmpty();
	}
}