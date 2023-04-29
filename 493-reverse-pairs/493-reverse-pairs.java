class Solution {
    
    static int cnt;
    
    public int reversePairs(int[] nums) {
        
        cnt = 0;
        merge(nums,0,nums.length-1);
        
        return cnt;
    }
    public static void merge(int arr[], int l, int h){
        if(l < h){
            int mid = l+(h-l)/2;
            
            merge(arr,l,mid);
            merge(arr,mid+1,h);
            mergeSort(arr,l,mid,h);
        }
    }
    public static void mergeSort(int arr[], int l, int mid, int h){
        int left = l;
        int right = mid+1;
        
        int j = right;
        for(int i = l ; i <= mid ; i++){
            while(j <= h && arr[i]/2.0 > arr[j]){
                j++;
            }
            
            cnt += j - right;
        }
        
        int temp[] = new int[(mid-l+1)+(h-right+1)];
        int k = 0;
        
        while(left <= mid && right <= h){
            if(arr[left] < arr[right]){
                temp[k++] = arr[left++];
            }else{
                temp[k++] = arr[right++];
            }
        }
        while(left <= mid){
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