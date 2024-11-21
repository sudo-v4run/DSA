class Solution {
    public int minZeroArray(int[] arr, int[][] queries) {
        
        int n = arr.length;
        
        int sum = 0;
        for(int x : arr){
            sum += x;
        }
        if(sum == 0){
            return 0;
        }
        
        int lo = 0;
        int hi = queries.length-1;
        int ans = -1;
        
        while(lo <= hi){
            
            int mid = lo+(hi-lo)/2;
            
            if(isPossible(arr,mid,queries)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        if(ans == -1){
            return -1;
        }
        
        return ans+1;
            // +1 coz we worked on indices and indices starts from 0 not 1.
    }
    public boolean isPossible(int arr[], int k, int[][] queries){
        
        int n = arr.length;
        
        int freq[] = new int[n+1];
        
        for(int i = 0 ; i <= k ; i++){
            
            int q[] = queries[i];
            
            int l = q[0];
            int r = q[1];
            int val = q[2];
            
            freq[l] += val;
            freq[r+1] -= val;
        }
        
        int pre[] = new int[n];
        pre[0] = freq[0];
        
        for(int i = 1 ; i < n ; i++){
            pre[i] = pre[i-1] + freq[i];
        }
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > pre[i]){
                return false;
            }
        }
        
        return true;
    }
}