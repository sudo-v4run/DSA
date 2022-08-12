//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int m[][], int r, int c) {
        int curRow[] = new int[c];
        curRow = m[0];
        int maxAns = maxHistogram(curRow);
        for(int i = 1 ; i<r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(m[i][j]==1){
                    curRow[j]+=1;
                }else{
                    curRow[j]=0;
                }
            }
            int curAns = maxHistogram(curRow);
            maxAns= Math.max(maxAns,curAns);
        }
        
        return maxAns;
    }
    static int maxHistogram(int arr[]){
        int ps[] = new int[arr.length];
        int ns[] = new int[arr.length];
        ps = ps(arr);
        ns = ns(arr);
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(ns[i]==-1){
                ns[i]=arr.length;
            }
            int width = ns[i]-ps[i]-1;
            ans = Math.max(ans,arr[i]*width);
        }
        
        return ans;
    }
    static int[] ps(int arr[]){
        Stack<Integer> s = new Stack<>();
        int res[] = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = s.peek();
            }
            s.push(i);
        }
        
        return res;
    }
    static int[] ns(int arr[]){
        Stack<Integer> s = new Stack<>();
        int res[] = new int[arr.length];
        for(int i = arr.length-1 ; i >= 0 ; i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = s.peek();
            }
            s.push(i);
        }
        
        return res;
    }
}