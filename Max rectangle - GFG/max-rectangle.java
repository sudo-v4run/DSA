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

class Solution {
    public int maxArea(int arr[][], int n, int m) {
        int maxA = 0;
        int curRow[] = new int[m];
        
        for(int[] row : arr){
            for(int i = 0 ; i < m ; i++){
                if(row[i]==0){
                    curRow[i] = 0;
                }else{
                    curRow[i]++;
                }
            }
            maxA = Math.max(maxA,largestRectangleArea(curRow));
        }
        
        return maxA;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int left[] = new int[n];
        int right[] = new int[n];
        
        //   O(n*n)             ************************************
        // left[0] = 0;
        // right[n-1] = n-1;
        // for(int i = 0; i < n ; i++){
        //     int j = i-1;
        //     while(j>=0 && heights[j]>=heights[i]){
        //         j--;
        //     }
        //     left[i] = j+1;
        //     j = i+1;
        //     while(j<=n-1 && heights[j]>=heights[i]){
        //         j++;
        //     }
        //     right[i] = j-1;
        // }
        
        //***********************************************************
        
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i<n ; i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            
            if(s.isEmpty()){
                left[i] = 0;
            }else{
                left[i] = s.peek()+1;
            }
            
            s.push(i);
        }
        
        
        while(!s.isEmpty()) s.pop();
        
        
        for(int i = n-1; i>=0 ; i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            
            if(s.isEmpty()){
                right[i] = n-1;
            }else{
                right[i] = s.peek()-1;
            }
            
            s.push(i);
        }
        
        int area = 0;
        
        for(int i = 0 ; i < n ; i++){
            int width = right[i]-left[i]+1;
            area = Math.max(area,width*heights[i]);
        }
        
        return area;
        
        
        
        //***********************************************************
        
        
//         Stack<Integer> s = new Stack<>();
//         int maxA = 0;
        
//         for(int i = 0 ; i <= n; i++){
//             while(!s.isEmpty()&& (i==n || heights[s.peek()]>=heights[i]) ){
//                 int h = heights[s.pop()];
//                 int width;
//                 if(s.isEmpty()){
//                     width = i;
//                 }else{
//                     width = (i-s.peek()-1);
//                 }
//                 maxA = Math.max(maxA,h*width);
//             }
//             s.push(i);
//         }
        
//         return maxA;
        
    }
}