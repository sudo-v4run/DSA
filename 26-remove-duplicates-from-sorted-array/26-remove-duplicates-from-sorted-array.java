class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 0;
        int j = 1;
        int k = 1;
        
        while(j<arr.length){
            if(arr[i]!=arr[j]){
                int temp = arr[i+1];
                arr[i+1] = arr[j];
                arr[j] = temp;
                i++;
                j++;
                k++;
            }else{
                j++;
            }
        }
        
        return k;
    }
}