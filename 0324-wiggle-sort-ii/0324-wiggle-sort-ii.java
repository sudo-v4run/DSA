class Solution {
    public void wiggleSort(int[] arr) {
        
        int n = arr.length;
        
        Arrays.sort(arr);
        
        int temp[] = new int[n];
        
        int j = n-1;
        int i = 1;
        
        while(i < n){
            temp[i] = arr[j];
            
            j--;
            i = i+2;
        }
        
        i = 0;
        
        while(i < n){
            temp[i] = arr[j];
            
            j--;
            i = i+2;
        }
        
        for(int k = 0 ; k < n ; k++){
            arr[k] = temp[k];
        }
    }
}