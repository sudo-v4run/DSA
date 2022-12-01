class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        
        k = k%n;
        
        rotate(arr,0,n-1);
        rotate(arr,0,k-1);
        rotate(arr,k,n-1);
    }
    public static void rotate(int arr[],int s,int e){
        while(s<=e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}