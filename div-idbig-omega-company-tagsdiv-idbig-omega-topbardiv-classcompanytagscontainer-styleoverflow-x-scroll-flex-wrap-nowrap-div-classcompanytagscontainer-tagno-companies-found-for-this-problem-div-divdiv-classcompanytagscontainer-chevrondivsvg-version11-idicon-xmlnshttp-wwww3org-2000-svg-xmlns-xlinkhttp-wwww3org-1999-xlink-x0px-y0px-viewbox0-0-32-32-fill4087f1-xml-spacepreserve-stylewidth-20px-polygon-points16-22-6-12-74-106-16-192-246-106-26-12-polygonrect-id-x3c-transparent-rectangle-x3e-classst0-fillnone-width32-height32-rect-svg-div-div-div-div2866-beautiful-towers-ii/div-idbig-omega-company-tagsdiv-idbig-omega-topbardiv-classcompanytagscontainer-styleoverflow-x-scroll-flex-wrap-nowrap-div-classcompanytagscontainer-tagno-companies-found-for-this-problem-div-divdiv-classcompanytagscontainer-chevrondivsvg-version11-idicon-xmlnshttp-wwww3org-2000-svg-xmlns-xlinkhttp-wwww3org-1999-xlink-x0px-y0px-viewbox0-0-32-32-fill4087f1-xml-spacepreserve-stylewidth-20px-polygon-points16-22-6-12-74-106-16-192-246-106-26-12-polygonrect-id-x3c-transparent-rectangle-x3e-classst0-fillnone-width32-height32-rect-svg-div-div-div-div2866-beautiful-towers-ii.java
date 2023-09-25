class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        
        int n = maxHeights.size();
        
        int arr[] = new int[n];
        int k = 0;
        for(int ele : maxHeights){
            arr[k++] = ele;
        }
        
        // Finding Next Smaller Element Index to the left of i and Calculations...
        
        long pre[] = new long[n];
        pre[0] = arr[0];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        
        for(int i = 1 ; i < n ; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            int minInd = -1;
            if(!s.isEmpty()){
                minInd = s.peek();
            }
            long left = 1l*(i-minInd)*1l*arr[i];
            if(minInd != -1){
                left += pre[minInd];
            }
            pre[i] = left;
            s.push(i);
        }
        
        // Finding Next Smaller Element Index to the right of i and Calculations...
        
        long suf[] = new long[n];
        suf[n-1] = arr[n-1];
        s = new Stack<>();
        s.push(n-1);
        
        for(int i = n-2 ; i >=0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            int minInd = n;
            if(!s.isEmpty()){
                minInd = s.peek();
            }
            long right = 1l*(minInd-i)*1l*arr[i];
            if(minInd != n){
                right += suf[minInd];
            }
            suf[i] = right;
            s.push(i);
        }
        
        long ans = 0;
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans,pre[i]+suf[i]-arr[i]);
        }
        
        return ans;
    }
}