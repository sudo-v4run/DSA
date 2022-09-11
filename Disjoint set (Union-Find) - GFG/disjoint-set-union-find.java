//{ Driver Code Starts
import java.util.*;
class Disjoint{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n+1];
			for(int i=1;i<=n;i++)
				a[i]=i;
			int k=sc.nextInt();
			GfG g=new GfG();
			for(int i=0;i<k;i++){
				String s=sc.next();
				if(s.equals("UNION")){
					int x=sc.nextInt();
					int z=sc.nextInt();
					g.unionSet(a,x,z);
				}
				else{
					int x=sc.nextInt();
					int parent=g.find(a,x);
					System.out.print(parent+" ");
				}
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


class GfG
{
	int find(int parent[],int x)
    {
          if(parent[x]!=x){
              parent[x] = find(parent,parent[x]);
          }
          
          return parent[x];
	}
	void unionSet(int parent[],int x,int z)
    {
         int parX = find(parent,x);
         int parZ = find(parent,z);
         
         if(parX==parZ){
             return;
         }
         
         parent[parX] = parZ;
	}
}
