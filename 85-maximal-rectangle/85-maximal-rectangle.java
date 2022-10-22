class Solution {
    public int maximalRectangle(char[][] arr) {
        int m = arr[0].length;
        
        int maxA = 0;
        int curRow[] = new int[m];
        
        for(char[] row : arr){
            for(char i = 0 ; i < m ; i++){
                if(row[i]=='0'){
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