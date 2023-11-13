class Solution {
    public int minOperations(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        
        int arr1new[] = arr1.clone();
        int arr2new[] = arr2.clone();
        
        int swap = getOperations(arr1,arr2);
        if(swap == -1){
            return -1;
        }
        
        int temp = arr1new[n-1];
        arr1new[n-1] = arr2new[n-1];
        arr2new[n-1] = temp;
        
        int noSwap = getOperations(arr1new,arr2new);
        if(noSwap == -1){
            return -1;
        }
        
        return Math.min(swap,noSwap+1);
    }
    public int getOperations(int arr1[], int arr2[]){
        
        int n = arr1.length;
        int ops = 0;
        
        for(int i = 0 ; i < n-1 ; i++){
            if(arr1[i] > arr1[n-1] || arr2[i] > arr2[n-1]){
                int temp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = temp;
                
                ops++;
            }
            
            if(arr1[i] > arr1[n-1] || arr2[i] > arr2[n-1]){
                return -1;
            }
        }
        
        return ops;
    }
}