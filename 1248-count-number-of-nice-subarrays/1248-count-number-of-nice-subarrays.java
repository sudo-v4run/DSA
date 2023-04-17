class Solution {
    public int numberOfSubarrays(int[] nums, int k){
        
        return atmostK(nums,k) - atmostK(nums,k-1);
    }
    public static int atmostK(int arr[], int k){
        int i = 0, j =0;
        int n = arr.length;
        int cnt = 0;
        int totCnt = 0;
        
        while(j < n){
            if(arr[j] % 2 != 0){
                cnt++;
            }
            
            if(cnt <= k){
                totCnt += j-i+1;
                j++;
            }else if(cnt > k){
                while(i <= j && cnt > k){
                    if(arr[i] % 2 != 0){
                        cnt--;
                    }
                    i++;
                }
                totCnt += j-i+1;
                j++;
            }
        }
        
        return totCnt;
    }
}