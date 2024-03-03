class Solution {
    public int[] resultArray(int[] arr) {
        
        int n = arr.length;
        
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        
        arr1.add(arr[0]);
        arr2.add(arr[1]);
        
        for(int i = 2 ; i < n ; i++){
            if(arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1)){
                arr1.add(arr[i]);
            }else{
                arr2.add(arr[i]);
            }
        }
        
        int res[] = new int[n];
        int k = 0;
        
        for(int x : arr1){
            res[k] = x;
            k++;
        }
        for(int x : arr2){
            res[k] = x;
            k++;
        }
        
        return res;
    }
}