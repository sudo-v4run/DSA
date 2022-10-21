class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int left[] = new int[n];
        int right[] = new int[n];
        
        left[0] = 0;
        right[n-1] = n-1;
        
        
        //   O(n*n)             **********************************
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
        
        //********************************************************
        
        
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i = 1; i<n ; i++){
            int cur = heights[i];
            
            while(!s.isEmpty() && heights[s.peek()]>=cur){
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
        
        s.push(n-1);
        
        
        for(int i = n-2; i>=0 ; i--){
            int cur = heights[i];
            
            while(!s.isEmpty() && heights[s.peek()]>=cur){
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
            int h = heights[i];
            area = Math.max(area,width*h);
        }
        
        return area;
    }
}