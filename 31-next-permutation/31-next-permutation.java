class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int idx = -1;
        
        for(int i = n-1 ; i >  0 ; i--){
            if(arr[i]>arr[i-1]){
                idx = i-1;
                break;
            }
        }
        
        if(idx == -1){
            Arrays.sort(arr);
        }else{
            
            for(int i = n-1; i >=idx+1 ; i--){
                if(arr[i]>arr[idx]){
                    swap(arr,i,idx);
                    break;
                }
            }
            reverse(arr,idx+1,n-1);
        }
    }
    public static void reverse(int arr[] , int s , int e){
        while(s<=e){
            swap(arr,s,e);
            s++;
            e--;
        }
    }
    public static void swap(int arr[] , int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}