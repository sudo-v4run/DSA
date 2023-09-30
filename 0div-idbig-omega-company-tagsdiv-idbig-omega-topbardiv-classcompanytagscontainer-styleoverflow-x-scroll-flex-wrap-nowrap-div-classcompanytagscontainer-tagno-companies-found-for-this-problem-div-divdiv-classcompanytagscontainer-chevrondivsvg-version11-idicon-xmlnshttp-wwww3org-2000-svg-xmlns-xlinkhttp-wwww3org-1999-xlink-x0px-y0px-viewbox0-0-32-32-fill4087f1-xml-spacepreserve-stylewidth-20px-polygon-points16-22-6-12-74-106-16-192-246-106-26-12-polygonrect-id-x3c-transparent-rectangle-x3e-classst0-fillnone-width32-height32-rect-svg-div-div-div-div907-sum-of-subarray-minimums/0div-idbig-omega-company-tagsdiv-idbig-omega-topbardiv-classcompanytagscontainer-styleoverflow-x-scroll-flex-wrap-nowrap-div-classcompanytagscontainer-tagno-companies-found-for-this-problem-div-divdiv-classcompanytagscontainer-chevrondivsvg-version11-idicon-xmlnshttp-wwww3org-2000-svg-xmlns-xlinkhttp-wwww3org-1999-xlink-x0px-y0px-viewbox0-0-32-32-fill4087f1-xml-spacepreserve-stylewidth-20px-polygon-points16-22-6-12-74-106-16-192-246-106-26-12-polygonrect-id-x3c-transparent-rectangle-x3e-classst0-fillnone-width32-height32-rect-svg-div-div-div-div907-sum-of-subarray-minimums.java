class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;
        int mod = (int)1e9+7;
        
        Stack<Integer> s = new Stack<>();
        
        int left[] = new int[n];
        int right[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
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
        
        for(int i = n-1 ; i >= 0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] > arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                right[i] = n;
            }else{
                right[i] = s.peek();
            }
            s.push(i);
        }
        
        long sum = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            int leftBoundary = left[i]+1;
            int rightBoundary = right[i]-1;
            
            int leftCnt = i-leftBoundary+1;
            int rightCnt = rightBoundary-i+1;
            
            if(leftCnt == 0){
                leftCnt = 1;
            }
            if(rightCnt == 0){
                rightCnt = 1;
            }
            
            long noOfSubarrays = (leftCnt*rightCnt)%mod;
            long temp = (noOfSubarrays*arr[i])%mod;
            
            sum = (sum+temp)%mod;
        }
        
        return (int)sum;
    }
}