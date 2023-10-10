class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int arr[][] = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0){
                    arr[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }else{
                    arr[i][j] = matrix[i][j] != '0' ? matrix[i][j] -'0' + arr[i-1][j] : 0;
                }
            }
        }
        
        int ans = 0;
        
        for(int row[] : arr){
            int area = largestRectangleArea(row);
            ans = Math.max(ans,area);
        }
        
        return ans;
    }
    
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        
        int left[] = new int[n];
        int right[] = new int[n];
        
        Stack<Integer> s = new Stack<>();
        
        // Precompute left immediate smaller index for the current i
        
        for(int i = 0 ; i < n ; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = s.peek();
            }
            s.push(i);
        }
        
        s = new Stack<>();
        
        // Precompute right immediate smaller index for the current i
        
        for(int i = n-1 ; i >= 0 ; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                right[i] = n;
            }else{
                right[i] = s.peek();
            }
            s.push(i);
        }
        
        int max = 0;
        
        for(int i = 0 ; i < n ; i++){
            int leftBoundary = left[i]+1;
            int rightBoundary = right[i]-1;
            
            int dist = rightBoundary-leftBoundary+1;
            
            max = Math.max(max,dist*heights[i]);
        }
        
        return max;
        
//         TC - O(N+N)...
        
//         Stack<Integer> s = new Stack<>();
//         int maxA = 0;
        
//         for(int i = 0 ; i <= n ; i++){
//             while(!s.isEmpty() && (i==n||heights[s.peek()]>=heights[i])){
//                 int h = heights[s.peek()];
//                 s.pop();
//                 int width = s.isEmpty() ? i : i - s.peek() -1;
//                 maxA = Math.max(maxA,h*width);
//             }
//             s.push(i);
//         }
        
//         return maxA;
        
    }
}