class Solution {
    public void nextPermutation(int[] arr) {
        
        int n = arr.length;
        if(n<=1){
            return;
        }

        int i = n-2;
        while(i>=0 && arr[i]>=arr[i+1]){        // finding beakpoint
            i--;
        }
        
        if(i>=0){
            for(int j = n-1 ; j >= 0 ; j--){
                if(arr[j]>arr[i]){
                    swap(arr,i,j);
                    break;
                }
            }
        }
        
        reverse(arr,i+1,n-1);
    }
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int arr[],int s,int e){
        while(s<=e){
            swap(arr,s,e);
            s++;
            e--;
        }
    }
}