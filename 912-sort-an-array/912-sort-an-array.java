class Solution {
    public int[] sortArray(int[] arr) {
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public static void quickSort(int arr[],int l , int h){
        if(l<h){
            int pivot = partitioningLogic(arr,l,h);
            quickSort(arr,l,pivot-1);
            quickSort(arr,pivot+1,h);
        }
    }
    public static int partitioningLogic(int arr[], int l , int h){
        int pivot = arr[l];
        int i = l;
        int j = h;
        
        while(i<j){
            while(i<j && arr[i]<=pivot) i++;
            while(arr[j]>pivot) j--;
            
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        
        return j;
    }
    public static void swap(int arr[],int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}