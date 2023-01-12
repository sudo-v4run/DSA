class Solution {
    public int[] sortArray(int[] arr) {
        
        // Insertion Sort...
        
//         int n = arr.length;
//         if(n == 0 || n == 1) return arr;
        
//         for(int i = 0 ; i < n ; i++){
//             int cur = arr[i];
//             int j = i-1;
//             while(j>=0 && arr[j]>cur){
//                 arr[j+1] = arr[j];
//                 j--;
//             }
//             arr[j+1] = cur;
//         }
        
//         return arr;
        
        
        // MergeSort...
        
        int n = arr.length;
        partition(arr,0,n-1);
        return arr;
        
        
        
        
        // QuickSort....
        
        // quickSort(arr,0,arr.length-1);
        // return arr;
    }
    
    // MergeSort...
    
    public static void partition(int arr[],int l ,int h){
       
        if(l<h){
            int m = (l+h)/2;
            partition(arr,l,m);
            partition(arr,m+1,h);
            merge(arr,l,m,h);
        }
        return;
    }
    public static void merge(int arr[], int l , int m , int r){
        int n = r-l+1;
        int res[] = new int[n];
        int i = l;
        int j = m+1;
        int k = 0;
        
        while(i<=m && j<=r){
            if(arr[i]<arr[j]){
                res[k++] = arr[i++];
            }else{
                res[k++] = arr[j++];
            }
        }
        while(i<=m){
            res[k++] = arr[i++];
        }
        while(j<=r){
            res[k++] = arr[j++];
        }
        
        i = l;
        k = 0;
        for( ; i<=r ; i++){
            arr[i] = res[k++];
        }
    }
    
    
    
    
    
    
    
    
    // Quick Sort...
    
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