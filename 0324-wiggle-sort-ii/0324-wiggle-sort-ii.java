class Solution {
    public void wiggleSort(int[] arr) {
        
        int n = arr.length;
        
        if(n <= 1){
            return;
        }
        
        int median = kthLargest(n/2,arr);
        
        // Dutch National Flag...
        
        int low = 0;
        int mid = 0;
        int high = n-1;
        
        while(mid <= high){
            if(arr[mid] < median){
                swap(arr,low,mid);
                mid++;
                low++;
            }else if(arr[mid] == median){
                mid++;
            }else if(arr[mid] > median){
                swap(arr,mid,high);
                high--;
            }
        }
        
        // Simulate Wiggle...
        
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
    public int kthLargest(int k, int arr[]){
        
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < k ; i++){
            pq.add(arr[i]);
        }
        
        for(int i = k ; i < n ; i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        
        return pq.peek();
    }
    public void swap(int arr[], int i, int j){
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


// class Solution {
//     public void wiggleSort(int[] arr) {
        
//         int n = arr.length;
        
//         Arrays.sort(arr);
        
//         int temp[] = new int[n];
        
//         int j = n-1;
//         int i = 1;
        
//         while(i < n){
//             temp[i] = arr[j];
            
//             j--;
//             i = i+2;
//         }
        
//         i = 0;
        
//         while(i < n){
//             temp[i] = arr[j];
            
//             j--;
//             i = i+2;
//         }
        
//         for(int k = 0 ; k < n ; k++){
//             arr[k] = temp[k];
//         }
//     }
// }