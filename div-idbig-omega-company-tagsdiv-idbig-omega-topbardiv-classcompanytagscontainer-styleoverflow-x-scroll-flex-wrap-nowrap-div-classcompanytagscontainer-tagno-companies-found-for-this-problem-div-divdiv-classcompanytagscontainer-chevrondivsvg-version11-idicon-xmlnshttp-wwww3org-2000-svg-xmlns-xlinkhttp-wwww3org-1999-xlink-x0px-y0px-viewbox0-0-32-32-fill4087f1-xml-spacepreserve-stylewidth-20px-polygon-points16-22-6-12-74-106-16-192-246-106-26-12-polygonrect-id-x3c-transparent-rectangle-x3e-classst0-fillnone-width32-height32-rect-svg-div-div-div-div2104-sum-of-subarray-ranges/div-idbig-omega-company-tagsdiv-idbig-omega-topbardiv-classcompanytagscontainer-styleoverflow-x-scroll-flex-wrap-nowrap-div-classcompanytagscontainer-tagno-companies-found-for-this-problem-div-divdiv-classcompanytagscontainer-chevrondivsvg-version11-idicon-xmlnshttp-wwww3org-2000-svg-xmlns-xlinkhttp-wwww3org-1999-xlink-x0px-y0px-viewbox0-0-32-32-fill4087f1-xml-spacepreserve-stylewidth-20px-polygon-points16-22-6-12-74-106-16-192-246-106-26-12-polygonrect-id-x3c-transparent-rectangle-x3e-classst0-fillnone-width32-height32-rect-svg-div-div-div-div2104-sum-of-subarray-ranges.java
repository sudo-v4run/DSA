class Solution {
    public long subArrayRanges(int[] arr) {
        
        int n = arr.length;
        
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        
        int leftMin[] = new int[n];
        int rightMin[] = new int[n];
        
        Stack<Integer> smax = new Stack<>();
        Stack<Integer> smin = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            while(!smax.isEmpty() && arr[smax.peek()] <= arr[i]){
                smax.pop();
            }
            if(smax.isEmpty()){
                leftMax[i] = -1;
            }else{
                leftMax[i] = smax.peek();
            }
            smax.push(i);
            
            while(!smin.isEmpty() && arr[smin.peek()] >= arr[i]){
                smin.pop();
            }
            if(smin.isEmpty()){
                leftMin[i] = -1;
            }else{
                leftMin[i] = smin.peek();
            }
            smin.push(i);
        }
        
        smax = new Stack<>();
        smin = new Stack<>();
        
        for(int i = n-1 ; i >= 0 ; i--){
            while(!smax.isEmpty() && arr[smax.peek()] < arr[i]){
                smax.pop();
            }
            if(smax.isEmpty()){
                rightMax[i] = n;
            }else{
                rightMax[i] = smax.peek();
            }
            smax.push(i);
            
            while(!smin.isEmpty() && arr[smin.peek()] > arr[i]){
                smin.pop();
            }
            if(smin.isEmpty()){
                rightMin[i] = n;
            }else{
                rightMin[i] = smin.peek();
            }
            smin.push(i);
        }
        
        long toAdd = 0;
        long toSub = 0;
        
        for(int i = 0 ; i < n ; i++){
            int leftMaxBoundary = leftMax[i]+1;
            int rightMaxBoundary = rightMax[i]-1;
            
            int toLeft = i-leftMaxBoundary+1;
            int toRight = rightMaxBoundary-i+1;
            
            toAdd += (toLeft*toRight)*1l*arr[i];
            
            int leftMinBoundary = leftMin[i]+1;
            int rightMinBoundary = rightMin[i]-1;
            
            toLeft = i-leftMinBoundary+1;
            toRight = rightMinBoundary-i+1;
            
            toSub += (toLeft*toRight)*1l*arr[i];
        }
        
        return toAdd-toSub;
    }
}