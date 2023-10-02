class Solution {
    public int minSizeSubarray(int[] arr, int target) {
        
        int n = arr.length;
        
        int sum = 0;
        
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
        }
        
        int k = target/sum;
        int rem = target%sum;
        if(rem == 0){
            return k*n;
        }
        target = rem;
        
        int newarr[] = new int[2*n];
        int l = 0;
        
        for(int i = 0 ; i < n ; i++){
            newarr[l++] = arr[i];
        }
        for(int i = 0 ; i < n ; i++){
            newarr[l++] = arr[i];
        }
        
        n = newarr.length;
        sum = 0;
        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while(j < n){
            sum += newarr[j];
            
            if(sum < target){
                j++;
            }else if(sum == target){
                ans = Math.min(ans,j-i+1);
                j++;
            }else{
                while(sum > target){
                    sum = sum-newarr[i];
                    i++;
                }
                if(sum == target){
                    ans = Math.min(ans,j-i+1);
                }
                j++;
            }
        }
        
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        
        return k*arr.length+ans;
    }
}