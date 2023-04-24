class Solution {
    
    static int gCnt;
    static int lCnt;
    
    public boolean isIdealPermutation(int[] nums){
        
        gCnt = 0;
        lCnt = 0;
        int n = nums.length;
        
        for(int i = 0 ; i < n-1 ; i++){
            if(nums[i] > nums[i+1]){
                lCnt++;
            }
        }
        
        merge(nums,0,n-1);
        
        return gCnt == lCnt;
    }
    static void merge(int arr[], int l, int h){
        if(l < h){
            int mid = (l+h)/2;
            
            merge(arr,l,mid);
            merge(arr,mid+1,h);
            mergeSort(arr,l,mid,h);
        }
    }
    static void mergeSort(int arr[], int l, int m, int h){
        int left = l;
        int right = m+1;
        int n = (m-l+1) + (h-m+1+1);
        int temp[] = new int[n];
        int k = 0;
        
        while(left <= m && right <= h){
            if(arr[left] > arr[right]){
                gCnt += m - left + 1;
                temp[k++] = arr[right++];
            }else{
                temp[k++] = arr[left++];
            }
        }
        while(left <= m){
            temp[k++] = arr[left++];
        }
        while(right <= h){
            temp[k++] = arr[right++];
        }
        
        k = 0;
        for(int i = l ; i <= h ; i++){
            arr[i] = temp[k++];
        }
    }
}