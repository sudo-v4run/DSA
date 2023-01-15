class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];
        
        
//         O(n*n) ......................................
        
//         for(int i = 0 ; i < n ; i++){
//             int j = i-1;
//             while(j>=0 && heights[j]>=heights[i]){
//                 j--;
//             }
//             left[i] = j+1;
            
//             j = i+1;
//             while(j<n && heights[j]>=heights[i]){
//                 j++;
//             }
//             right[i] = j-1;
//         }

//         .............................................
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            left[i] = s.isEmpty() ? 0 : s.peek()+1;
            
            s.push(i);
        }
        
        while(!s.isEmpty()){
            s.pop();
        }
        
        for(int i = n-1 ; i >=0 ; i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            right[i] = s.isEmpty() ? n-1 : s.peek()-1;
            
            s.push(i);
        }
        
        int maxA = -1;
        
        for(int i = 0 ; i < n ; i++){
            int width = right[i] - left[i] + 1;
            maxA = Math.max(maxA,width*heights[i]);
        }
        
        return maxA;
    }
}