class Solution {
    public int removeDuplicates(int[] arr) {
        
        int n = arr.length;
        int cnt = 1;
        int i = 0;
        for(int j = 1; j < n ; j++){
            if(arr[i] != arr[j]){
                i++;
                swap(arr,i,j);
                cnt++;
            }
        }
        
        return cnt;
    }
    public static void swap(int arr[],int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}