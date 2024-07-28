class Solution {
    public boolean canAliceWin(int[] arr) {
        
        int n = arr.length;
        
        int a = 0;
        int b = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            if(arr[i] <= 9){
                a += arr[i];
            }else{
                b +=arr[i];
            }
        }
        
        return !(a==b);
    }
}